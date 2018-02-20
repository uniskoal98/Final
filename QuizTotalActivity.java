package com.example.a.afinal;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.logging.Level;

public class QuizTotalActivity extends AppCompatActivity {

    TextView Quiztext;
    EditText sol;
    Button Quizclear;
    String SOLUTION;
    String  Quiz1 = "신경성";
    String  Quiz2 = "C";
    String  Quiz3 = "512";
    String  Quiz4 = "프로그래머";
    String Leveltag;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiztotal);

        Quiztext = (TextView) findViewById(R.id.Quiztext);
        sol = (EditText) findViewById(R.id.solution);
        Quizclear = (Button) findViewById(R.id.QuizSend);

        Intent it = getIntent();

        String tag = it.getStringExtra("tag");
        Leveltag = tag;



        Resources res = getResources();
        int QUIZID = res.getIdentifier("QUIZ"+tag, "string",getPackageName());
        String QUIZTEXT = res.getString(QUIZID);
        Quiztext.setText(QUIZTEXT);

        Quizclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SOLUTION = sol.getText().toString();
                if(Leveltag.equals("1"))  {
                    if(SOLUTION.equals(Quiz1)) {
                        Toast.makeText(QuizTotalActivity.this, "정답을 맞추셨습니다. 다음 카테고리를 선택해주세요.", Toast.LENGTH_SHORT).show();
                        CategoryActivity.level += 1;
                        MainActivity.quiz_condition = true;
                        CategoryActivity.grantTWO = true;
                        Intent it2 = new Intent(getApplicationContext(),CategoryActivity.class);
                        startActivity(it2);
                    }
                    else {
                        Toast.makeText(QuizTotalActivity.this, "틀리셨습니다. 다시 생각해보세요.", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(Leveltag.equals("2")) {
                    if(SOLUTION.equals(Quiz2)) {
                        Toast.makeText(QuizTotalActivity.this, "정답을 맞추셨습니다. 다음 카테고리를 선택해주세요.", Toast.LENGTH_SHORT).show();
                        CategoryActivity.level += 1;
                        CategoryActivity.grantTHREE = true;
                        MainActivity.quiz_hobby = true;
                        Intent it2 = new Intent(getApplicationContext(),CategoryActivity.class);
                        startActivity(it2);
                    }
                    else {
                        Toast.makeText(QuizTotalActivity.this, "틀리셨습니다. 다시 생각해보세요.", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(Leveltag.equals("3")) {
                    if(SOLUTION.equals(Quiz3)) {
                        Toast.makeText(QuizTotalActivity.this, "정답을 맞추셨습니다. 다음 카테고리를 선택해주세요.", Toast.LENGTH_SHORT).show();
                        CategoryActivity.level += 1;
                        CategoryActivity.grantFOUR = true;
                        MusicActivity.quiz_music = true;
                        Intent it2 = new Intent(getApplicationContext(),CategoryActivity.class);
                        startActivity(it2);
                    }
                    else {
                        Toast.makeText(QuizTotalActivity.this, "틀리셨습니다. 다시 생각해보세요.", Toast.LENGTH_SHORT).show();
                    }
                }
                else if(Leveltag.equals("4")) {
                    if(SOLUTION.equals(Quiz4)) {
                        Toast.makeText(QuizTotalActivity.this, "정답을 맞추셨습니다. 모든 카테고리를 정복했습니다.", Toast.LENGTH_SHORT).show();
                        CategoryActivity.grantFIVE = true;
                        MainActivity.quiz_dream = true;
                        Intent it2 = new Intent(getApplicationContext(),CategoryActivity.class);
                        startActivity(it2);
                    }
                    else {
                        Toast.makeText(QuizTotalActivity.this, "틀리셨습니다. 다시 생각해보세요.", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });


    }
}
