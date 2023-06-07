package com.example.teplogaz20;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.squareup.picasso.Picasso;

public class ThirdActivity extends AppCompatActivity {


    private TextView textViewPipes;
    private DatabaseReference databaseReference;
    private ImageView imageViewPipe;
    private StorageReference storageReference;
    private StorageTask storageTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        textViewPipes = findViewById(R.id.textViewPipes);
        imageViewPipe = findViewById(R.id.imageViewPipe);

        //получаем ссылку на базу данных Firebase
        databaseReference = FirebaseDatabase.getInstance("https://bash-1b828-default-rtdb.europe-west1.firebasedatabase.app/").getReference("data/pipes");
        FirebaseStorage firebaseStorage = FirebaseStorage.getInstance("gs://bash-1b828.appspot.com");
        storageReference = firebaseStorage.getReferenceFromUrl("gs://bash-1b828.appspot.com/pipes/2b303a4cde14c04f479b58fa35354224.png");




        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String data = dataSnapshot.getValue(String.class);
                    textViewPipes.setText(data);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //Если ошибка
                Toast.makeText(ThirdActivity.this, "Ошибка!", Toast.LENGTH_SHORT).show();
            }
        });

        //storageReference = FirebaseStorage.getInstance("gs://bash-1b828.appspot.com").getReferenceFromUrl("gs://bash-1b828.appspot.com/pipes/2b303a4cde14c04f479b58fa35354224.png");
        String imageUrl = "https://firebasestorage.googleapis.com/v0/b/bash-1b828.appspot.com/o/pipes%2F2b303a4cde14c04f479b58fa35354224.png?alt=media";
        Picasso.get()
                .load(Uri.parse(imageUrl))
                .into(imageViewPipe);
    }
}