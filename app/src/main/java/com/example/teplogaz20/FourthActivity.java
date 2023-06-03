package com.example.teplogaz20;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class FourthActivity extends AppCompatActivity {
    AppCompatButton blagoBtn, vneshBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        blagoBtn = findViewById(R.id.blagoBtn);
        vneshBtn = findViewById(R.id.vneshBtn);


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
        blagoBtn.setTextColor(colorStateList);
        vneshBtn.setTextColor(colorStateList);


        blagoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FourthActivity.this, FiveActivity.class));

            }
        });

        vneshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FourthActivity.this, VneshInActivity.class));

            }
        });
    }
}