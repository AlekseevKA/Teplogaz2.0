package com.example.teplogaz20;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class FiveActivity extends AppCompatActivity {

    AppCompatButton leninBtn, samotekBtn, kanalBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);



        leninBtn = findViewById(R.id.leninBtn);
        samotekBtn = findViewById(R.id.samotekBtn);
        kanalBtn = findViewById(R.id.kanalBtn);

        // Создание цветового состояния для нажатия
        ColorStateList colorStateList = new ColorStateList(
                new int[][]{
                        new int[]{android.R.attr.state_pressed},
                        new int[]{}
                },
                new int[]{
                        Color.YELLOW, // Цвет текста для состояния нажатия (синий)
                        Color.BLACK // Цвет текста для обычного состояния (белый)
                }
        );
// Установка цветового состояния для текста кнопки
        leninBtn.setTextColor(colorStateList);
        samotekBtn.setTextColor(colorStateList);
        kanalBtn.setTextColor(colorStateList);

        leninBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FiveActivity.this, LeninActivity.class));
            }
        });
        samotekBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FiveActivity.this, SamotekActivity.class));
            }
        });
        kanalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FiveActivity.this, KanalActivity.class));
            }
        });
    }
}