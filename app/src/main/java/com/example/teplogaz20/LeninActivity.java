package com.example.teplogaz20;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LeninActivity extends AppCompatActivity {


    private TextView textViewData2;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lenin);

        textViewData2 = findViewById(R.id.textViewData2);

        //получаем ссылку на базу данных Firebase
        databaseReference = FirebaseDatabase.getInstance("https://bash-1b828-default-rtdb.europe-west1.firebasedatabase.app/").getReference("data/lenin");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String data = dataSnapshot.getValue(String.class);
                    textViewData2.setText(data);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //Если ошибка
                Toast.makeText(LeninActivity.this, "Ошибка!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}