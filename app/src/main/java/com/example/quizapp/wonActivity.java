package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class wonActivity extends AppCompatActivity {
    private CircularProgressBar circularProgressBar;
    private TextView txtResult;
    private int Correct,Wrong;
    private LinearLayout btnShareYourScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won);

        Correct = getIntent().getIntExtra("correct", 0);
        Wrong = getIntent().getIntExtra("wrong", 0);
        circularProgressBar = findViewById(R.id.circularProgressBar);
        txtResult = findViewById(R.id.txt_result);
        btnShareYourScore = findViewById(R.id.btn_share_score);

        circularProgressBar.setProgress(Correct);
        txtResult.setText(Correct + "/" + (Correct + Wrong));
        btnShareYourScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}