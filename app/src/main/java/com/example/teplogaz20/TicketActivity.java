package com.example.teplogaz20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.animation.Animator;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TicketActivity extends AppCompatActivity {
    private EditText nameEditText, descriptionEditText;
    private AppCompatButton createTicket;
    private DatabaseReference databaseReference;
    private StorageReference storageReference;
    private TicketRepository ticketRepository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        nameEditText = findViewById(R.id.nameEditText);
        descriptionEditText = findViewById(R.id.descriptionEditText);
        createTicket = findViewById(R.id.createTicket);


        ticketRepository = new TicketRepository();
        createTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString().trim();
                String description = descriptionEditText.getText().toString().trim();

                // Создание объекта TicketData
                Blocks blocks = new Blocks("{\"value\":\"" + name + "\"}", "{\"value\":\"" + description + "\"}");
                TicketData ticketData = new TicketData(blocks);

                // Вызов метода для создания заявки
                Call<TicketResponse> call = ticketRepository.createTicket("0BE069EC0C8B403EAA8AF47BC2", ticketData);
                call.enqueue(new Callback<TicketResponse>() {
                    @Override
                    public void onResponse(Call<TicketResponse> call, Response<TicketResponse> response) {
                        //Если успешно
                        if (response.isSuccessful()) {
                            TicketResponse ticketResponse = response.body();
                            if (ticketResponse != null) {
                                // Обработка успешного ответа
                                Toast.makeText(TicketActivity.this, "Заявка создана успешно!", Toast.LENGTH_SHORT).show();





                            }
                        } else {
                            // Обработка ошибки
                            Toast.makeText(TicketActivity.this, "Ошибка при создании заявки. Код ошибки: " + response.code(), Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<TicketResponse> call, Throwable t) {
                        // Обработка ошибки
                        Toast.makeText(TicketActivity.this, "Ошибка при создании заявки: " + t.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }


}