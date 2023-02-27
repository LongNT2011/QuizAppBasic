package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static List<Question_Answer> listQA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listQA = new ArrayList<>();

        listQA.add(new Question_Answer("Khoanh tròn vào chữ cái trước từ có tiếng “bảo” mang nghĩa: “giữ, chịu trách nhiệm”",
                "Bảo kiếm", "Bảo toàn", "Bảo ngọc", "Gia bảo", "Bảo toàn"));
        listQA.add(new Question_Answer("Đồng nghĩa với từ hạnh phúc là từ:",
                "Sung sướng", "Toại nguyện", "Phúc hậu", "Giàu có", "Sung sướng"));
        listQA.add(new Question_Answer("Trái nghĩa với từ hạnh phúc là từ:",
                "Túng thiếu", "Bất hạnh", "Gian khổ", "Phúc tra", "Bất hạnh"));
        listQA.add(new Question_Answer("Từ nào dưới đây có tiếng “bảo” không có nghĩa là “giữ, chịu trách nhiệm”.",
                "bảo vệ", "bảo hành", "bảo kiếm", "bảo quản", "bảo kiếm"));
        listQA.add(new Question_Answer("Từ nào dưới đây không đồng nghĩa với các từ còn lại?",
                "Cầm", "Nắm", "Cõng", "Xách", "Cõng"));
        listQA.add(new Question_Answer("Từ nào sau đây gần nghĩa nhất với từ hoà bình?",
                "Bình yên", "Hòa thuận", "Thái bình", "Hiền hòa", "Thái bình"));
        setDelay();
    }

    public void setDelay(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,DashboardActivity.class);
                startActivity(intent);

            }
        },1500);
    }

}