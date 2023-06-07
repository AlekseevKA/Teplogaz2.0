package com.example.teplogaz20;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class SecondActivity extends AppCompatActivity {
    AppCompatButton opisBtn, cotelButton, radiatorButton, bakButton, buttonNasos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        opisBtn = findViewById(R.id.opisBtn);
        cotelButton = findViewById(R.id.cotelButton);
        radiatorButton = findViewById(R.id.radiatorButton);
        bakButton = findViewById(R.id.bakButton);
        buttonNasos = findViewById(R.id.buttonNasos);

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
        opisBtn.setTextColor(colorStateList);
        cotelButton.setTextColor(colorStateList);
        radiatorButton.setTextColor(colorStateList);
        bakButton.setTextColor(colorStateList);
        buttonNasos.setTextColor(colorStateList);


        opisBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this, ThirdActivity.class));
            }
        });
        cotelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this, cotelActivity.class));
            }
        });
        radiatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this, RadiatorActivity.class));
            }
        });
        bakButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this, BakActivity.class));
            }
        });
        buttonNasos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this, NasosActivity.class));
            }
        });
    }
}