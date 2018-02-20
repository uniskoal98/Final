package com.example.a.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class CategoryActivity extends AppCompatActivity {

    ImageView cate1,cate2,cate3,cate4,cate5;
    static int level = 1;
    static boolean grantONE,grantTWO,grantTHREE,grantFOUR,grantFIVE;
    ConstraintLayout Background;
    static boolean grantQuiz1 = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Background = (ConstraintLayout) findViewById(R.id.ConBackground);
        Background.setBackgroundResource(R.drawable.background);


        cate1 = (ImageView) findViewById(R.id.face);
        cate2 = (ImageView) findViewById(R.id.condition);
        cate3 = (ImageView) findViewById(R.id.hobby);
        cate4 = (ImageView) findViewById(R.id.music);
        cate5 = (ImageView) findViewById(R.id.DreamPlan);

            cate1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(level == 1 || grantONE == true) {
                        Intent it = new Intent(getApplicationContext(), MainActivity.class);
                        it.putExtra("level", 1);
                        startActivity(it);
                    }


                }
            });


            cate2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(level == 2 || grantTWO == true) {
                        Intent it = new Intent(getApplicationContext(), MainActivity.class);
                        it.putExtra("level", 2);
                        startActivity(it);
                    }
                    else {
                        Toast.makeText(CategoryActivity.this, "자신의 역사 퀴즈를 맞혀주세요.", Toast.LENGTH_SHORT).show();
                    }
                }
            });



            cate3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(level == 3 || grantTHREE == true) {
                        Intent it = new Intent(getApplicationContext(), MainActivity.class);
                        it.putExtra("level", 3);
                        startActivity(it);
                    }
                    else {
                        Toast.makeText(CategoryActivity.this, "성격 퀴즈를 맞혀주세요.", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            cate4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(level == 4 || grantFOUR == true) {
                        Intent it = new Intent(getApplicationContext(), MainActivity.class);
                        it.putExtra("level", 4);
                        startActivity(it);
                    }
                    else {
                        Toast.makeText(CategoryActivity.this, "취미 퀴즈를 맞혀주세요", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        cate5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(level == 5 || grantFIVE == true) {
                    Intent it = new Intent(getApplicationContext(), MainActivity.class);
                    it.putExtra("level", 5);
                    startActivity(it);
                }
                else {
                    Toast.makeText(CategoryActivity.this, "음악 퀴즈를 맞혀주세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void onBackPressed() {
        if(level == 1) {
            super.onBackPressed();
        }
        else {
            Toast.makeText(CategoryActivity.this, "이젠 뒤로 가실 수 없습니다.", Toast.LENGTH_SHORT).show();
        }

    }
}
