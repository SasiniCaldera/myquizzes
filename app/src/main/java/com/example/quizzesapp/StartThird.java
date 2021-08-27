package com.example.quizzesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class StartThird extends AppCompatActivity {

    TextView tvTimer;
    TextView tvResult;
    ImageView ivShowImage;
    HashMap<String,Integer> map = new HashMap<>();
    ArrayList<String> techList = new ArrayList<>();
    int index;
    Button btn1, btn2, btn3, btn4;
    TextView tvPoints;
    int points;
    CountDownTimer countDownTimer;
    long millisUntilFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_game);
        tvTimer = findViewById(R.id.tvTimer);
        tvResult = findViewById(R.id.tvResult);
        ivShowImage = findViewById(R.id.ivShowImage);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        tvPoints = findViewById(R.id.tvPoints);
        index = 0;
        techList.add("Bulath");
        techList.add("Del");
        techList.add("Gotu kola");
        techList.add("Hathawariya");
        techList.add("Jack tree");
        techList.add("Karapincha");
        techList.add("Kuppamania");
        techList.add("Miris");
        techList.add("Polpala");
        techList.add("Rampe");
        techList.add("Walpenela");
        techList.add("wee");

        map.put(techList.get(0), R.drawable.bulath);
        map.put(techList.get(1), R.drawable.del);
        map.put(techList.get(2), R.drawable.gotukola);
        map.put(techList.get(3), R.drawable.hathawariya);
        map.put(techList.get(4), R.drawable.jack);
        map.put(techList.get(5), R.drawable.karapincha);
        map.put(techList.get(6), R.drawable.kuppamenia);
        map.put(techList.get(7), R.drawable.miris);
        map.put(techList.get(8), R.drawable.polpala);
        map.put(techList.get(9), R.drawable.rampe);
        map.put(techList.get(10), R.drawable.walpenala);
        map.put(techList.get(11), R.drawable.wee);
       
        Collections.shuffle(techList);
        millisUntilFinished = 10000;
        points = 0;
        startGame();
    }
    private void startGame() {
        millisUntilFinished = 10000;
        tvTimer.setText("" + (millisUntilFinished / 1000) + "s");
        tvPoints.setText(points + " / " + techList.size());
        generateQuestions(index);
        countDownTimer = new CountDownTimer(millisUntilFinished, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvTimer.setText("" + (millisUntilFinished / 1000) + "s");
            }

            @Override
            public void onFinish() {
                index++;
                if (index > techList.size() - 1){
                    ivShowImage.setVisibility(View.GONE);
                    btn1.setVisibility(View.GONE);
                    btn2.setVisibility(View.GONE);
                    btn3.setVisibility(View.GONE);
                    btn4.setVisibility(View.GONE);
                    Intent intent = new Intent(StartThird.this, GameOver.class);
                    intent.putExtra("points", points);
                    startActivity(intent);
                    finish();
                }else{
                    startGame();
                }
            }
        }.start();
    }

    private void generateQuestions(int index) {
        ArrayList<String> techListTemp = (ArrayList<String>) techList.clone();
        String correctAnswer = techList.get(index);
        techListTemp.remove(correctAnswer);
        Collections.shuffle(techListTemp);
        ArrayList<String> newList = new ArrayList<>();
        newList.add(techListTemp.get(0));
        newList.add(techListTemp.get(1));
        newList.add(techListTemp.get(2));
        newList.add(correctAnswer);
        Collections.shuffle(newList);
        btn1.setText(newList.get(0));
        btn2.setText(newList.get(1));
        btn3.setText(newList.get(2));
        btn4.setText(newList.get(3));
        ivShowImage.setImageResource(map.get(techList.get(index)));
    }

    public void nextQuestion(View view) {
        countDownTimer.cancel();
        index++;
        if(index > techList.size() - 1){
            ivShowImage.setVisibility(View.GONE);
            btn1.setVisibility(View.GONE);
            btn2.setVisibility(View.GONE);
            btn3.setVisibility(View.GONE);
            btn4.setVisibility(View.GONE);
            Intent intent = new Intent(StartThird.this, GameOver.class);
            intent.putExtra("points", points);
            startActivity(intent);
            finish();
        }else{
            startGame();
        }
    }

    public void answerSelected(View view) {
        countDownTimer.cancel();
        String answer = ((Button) view).getText().toString().trim();
        String correctAnswer = techList.get(index);
        if (answer.equals(correctAnswer)){
            points++;
            tvPoints.setText(points + " / " +techList.size());
            tvResult.setText("Correct");
        }else{
            tvResult.setText("Wrong");
        }
    }
}


