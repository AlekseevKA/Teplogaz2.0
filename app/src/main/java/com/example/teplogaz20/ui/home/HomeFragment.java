package com.example.teplogaz20.ui.home;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.teplogaz20.FourthActivity;
import com.example.teplogaz20.R;
import com.example.teplogaz20.SecondActivity;
import com.example.teplogaz20.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    AppCompatButton materialBtn, ustrBtn;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;



    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        materialBtn = (AppCompatButton) getActivity().findViewById(R.id.materialBtn);

        ustrBtn = (AppCompatButton) getActivity().findViewById(R.id.ustrBtn);

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
        materialBtn.setTextColor(colorStateList);
        ustrBtn.setTextColor(colorStateList);

        materialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SecondActivity.class);
                startActivity(intent);
            }
        });


        ustrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), FourthActivity.class);
                startActivity(intent);
            }
        });

    }

}