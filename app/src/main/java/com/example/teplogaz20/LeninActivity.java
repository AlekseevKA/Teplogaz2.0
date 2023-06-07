package com.example.teplogaz20;

import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
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

        // Получаем ссылку на базу данных Firebase
        databaseReference = FirebaseDatabase.getInstance("https://bash-1b828-default-rtdb.europe-west1.firebasedatabase.app/").getReference("data/lenin");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String data = dataSnapshot.getValue(String.class);
                    formatAndDisplayText(data);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Если произошла ошибка при чтении из базы данных
                Toast.makeText(LeninActivity.this, "Ошибка!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void formatAndDisplayText(String text) {
        String[] paragraphs = text.split("\n\n");
        StringBuilder formattedTextBuilder = new StringBuilder();

        for (String paragraph : paragraphs) {
            String formattedParagraph = "<p style=\"text-indent: 20px;\">"+paragraph+"</p>";
            formattedTextBuilder.append(formattedParagraph);
        }

        String formattedText = formattedTextBuilder.toString();

        Spanned spannedText;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            spannedText = Html.fromHtml(formattedText, Html.FROM_HTML_MODE_COMPACT);
        } else {
            spannedText = HtmlCompat.fromHtml(formattedText, HtmlCompat.FROM_HTML_MODE_LEGACY);
        }

        textViewData2.setText(spannedText);
    }
}