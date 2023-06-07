package com.example.teplogaz20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RadiatorActivity extends AppCompatActivity {
    private TextView textViewRadiator, textViewRadiator2;
    private DatabaseReference databaseReference, databaseReference2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radiator);

        textViewRadiator = findViewById(R.id.textViewRadiator);
        textViewRadiator2 = findViewById(R.id.textViewRadiator2);
        databaseReference = FirebaseDatabase.getInstance("https://bash-1b828-default-rtdb.europe-west1.firebasedatabase.app/").getReference("data/radiators");
        databaseReference2 = FirebaseDatabase.getInstance("https://bash-1b828-default-rtdb.europe-west1.firebasedatabase.app/").getReference("data/radiators2");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String data = dataSnapshot.getValue(String.class);
                    textViewRadiator.setText(data);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                //Если ошибка
                Toast.makeText(RadiatorActivity.this, "Ошибка!", Toast.LENGTH_SHORT).show();
            }
        });
        databaseReference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String data2 = dataSnapshot.getValue(String.class);
                    textViewRadiator2.setText(data2);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                //Если ошибка
                Toast.makeText(RadiatorActivity.this, "Ошибка!", Toast.LENGTH_SHORT).show();
            }
        });


    }
}