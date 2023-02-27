package com.example.quizapp;

import static com.example.quizapp.MainActivity.listQA;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {
    private int TimeValue;
    private ProgressBar progressBar;
    private CountDownTimer countDownTimer;
    private List<Question_Answer> AllQuestion;
    private Question_Answer question_answer;
    private int index = 0;
    private TextView txt_question,aA,aB,aC,aD,a;
    private CardView cvA,cvB,cvC,cvD;
    private LinearLayout btnNext;
    private int CorrectCount = 0;
    private int WrongCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Init();

        AllQuestion = listQA;
        Collections.shuffle(AllQuestion);
        question_answer = listQA.get(index);

        setOnClickToAnswer();
        setAllData();
        runCountDown(true);
    }

    private void setAllData() {
        txt_question.setText(question_answer.getQuestion());
        aA.setText(question_answer.getaA());
        aB.setText(question_answer.getaB());
        aC.setText(question_answer.getaC());
        aD.setText(question_answer.getaD());

    }

    public void Init(){
        progressBar = findViewById(R.id.progress_bar);

        txt_question = findViewById(R.id.txt_question);
        aA = findViewById(R.id.txt_answer_a);
        aB = findViewById(R.id.txt_answer_b);
        aC = findViewById(R.id.txt_answer_c);
        aD = findViewById(R.id.txt_answer_d);

        cvA = findViewById(R.id.card_a);
        cvB = findViewById(R.id.card_b);
        cvC = findViewById(R.id.card_c);
        cvD = findViewById(R.id.card_d);

        btnNext = findViewById(R.id.btn_next);
    }

    public void Correct(CardView cardView){
        CorrectCount ++;
        cardView.setBackgroundColor(getResources().getColor(R.color.color_green));
        runCountDown(false);
    }

    public void Wrong(CardView cardView){
        WrongCount ++;
        cardView.setBackgroundColor(getResources().getColor(R.color.color_red));
        runCountDown(false);
    }

    public void EnableButton(){
        cvA.setClickable(true);
        cvB.setClickable(true);
        cvC.setClickable(true);
        cvD.setClickable(true);
    }

    public void DisableButton(){
        cvA.setClickable(false);
        cvB.setClickable(false);
        cvC.setClickable(false);
        cvD.setClickable(false);
    }

    public void ResetColor(){
        cvA.setBackgroundColor(getResources().getColor(R.color.white));
        cvB.setBackgroundColor(getResources().getColor(R.color.white));
        cvC.setBackgroundColor(getResources().getColor(R.color.white));
        cvD.setBackgroundColor(getResources().getColor(R.color.white));
    }

    private void gameWon() {
        Intent intent = new Intent(DashboardActivity.this,wonActivity.class);
        intent.putExtra("correct",CorrectCount);
        intent.putExtra("wrong",WrongCount);
        startActivity(intent);
    }

    public void runCountDown(Boolean check){
        if (check) {
            TimeValue = 100;
            progressBar.setProgress(0);
            progressBar.setVisibility(View.VISIBLE);
            countDownTimer = new CountDownTimer(20000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    progressBar.setProgress(TimeValue);
                    TimeValue -= 5;
                }

                @Override
                public void onFinish() {
                    progressBar.setProgress(TimeValue);
                    progressBar.setVisibility(View.INVISIBLE);
                    Dialog dialog = new Dialog(DashboardActivity.this, R.style.Dialoge);
                    Bitmap map = Blur.takeScreenShot(DashboardActivity.this);

                    Bitmap fast = Blur.fastblur(map, 5);
                    final Drawable draw = new BitmapDrawable(getResources(), fast);
                    dialog.getWindow().setBackgroundDrawable(draw);
                    dialog.setContentView(R.layout.layout_dialog);

                    dialog.findViewById(R.id.btn_try_again).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    });
                    dialog.show();
                }
            }.start();
        } else {
            countDownTimer.cancel();
            progressBar.setProgress(0);
            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.card_a:
                DisableButton();
                btnNext.setClickable(true);
                if(question_answer.getaA().equals(question_answer.getaTrue())){
                    Correct(cvA);
                    if(index >= listQA.size() - 1){
                        gameWon();
                    }
                } else {
                    Wrong(cvA);
                }
                break;
            case R.id.card_b:
                DisableButton();
                btnNext.setClickable(true);
                if(question_answer.getaB().equals(question_answer.getaTrue())){
                    Correct(cvB);
                    if(index >= listQA.size() - 1){
                        gameWon();
                    }
                } else {
                    Wrong(cvB);
                }
                break;
            case R.id.card_c:
                DisableButton();
                btnNext.setClickable(true);
                if(question_answer.getaC().equals(question_answer.getaTrue())){
                    Correct(cvC);
                    if(index >= listQA.size() - 1){
                        gameWon();
                    }
                } else {
                    Wrong(cvC);
                }
                break;
            case R.id.card_d:
                DisableButton();
                btnNext.setClickable(true);
                if(question_answer.getaD().equals(question_answer.getaTrue())){
                    Correct(cvD);
                    if(index >= listQA.size() - 1){
                        gameWon();
                    }
                } else {
                    Wrong(cvD);
                }
                break;
            case R.id.btn_next:

                if (index < listQA.size() - 1){
                    index ++;
                    question_answer = listQA.get(index);
                    ResetColor();
                    setAllData();
                    EnableButton();
                    countDownTimer.cancel();
                    runCountDown(true);
                } else {
                    gameWon();
                }
                break;
            default:
                break;
        }
    }

    public void setOnClickToAnswer(){
        cvA.setOnClickListener(this::onClick);
        cvB.setOnClickListener(this::onClick);
        cvC.setOnClickListener(this::onClick);
        cvD.setOnClickListener(this::onClick);
        btnNext.setOnClickListener(this::onClick);
    }

}