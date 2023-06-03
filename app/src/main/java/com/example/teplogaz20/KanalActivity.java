package com.example.teplogaz20;

import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.squareup.picasso.Picasso;

public class KanalActivity extends AppCompatActivity {


    private TextView textViewData3;
    private DatabaseReference databaseReference;
    private ImageView imageViewKanal;
    private StorageReference storageReference;
    private StorageTask storageTask;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kanal);

        textViewData3 = findViewById(R.id.textViewData3);
        imageViewKanal = findViewById(R.id.imageViewKanal);

        //получаем ссылку на базу данных Firebase
        databaseReference = FirebaseDatabase.getInstance("https://bash-1b828-default-rtdb.europe-west1.firebasedatabase.app/").getReference("data/kanal");
        FirebaseStorage firebaseStorage = FirebaseStorage.getInstance("gs://bash-1b828.appspot.com");
        storageReference = firebaseStorage.getReferenceFromUrl("gs://bash-1b828.appspot.com/pipes/2b303a4cde14c04f479b58fa35354224.png");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String data = dataSnapshot.getValue(String.class);
                    textViewData3.setText(data);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //Если ошибка
                Toast.makeText(KanalActivity.this, "Ошибка!", Toast.LENGTH_SHORT).show();
            }
        });
        String imageUrl = "https://firebasestorage.googleapis.com/v0/b/bash-1b828.appspot.com/o/kanal%2FDvuhtrubnaya-zakrytaya-sistema-otopleniya.jpg?alt=media&token=b44e1ae7-62d8-486a-a7a3-0ec8a65f66ca";
        Picasso.get()
                .load(Uri.parse(imageUrl))
                .into(imageViewKanal);
    }
}