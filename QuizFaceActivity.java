package com.example.a.afinal;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.logging.Level;

public class QuizFaceActivity extends AppCompatActivity {

    ImageView Face1,Face2,Face3,Face4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face);

        Face1 = (ImageView) findViewById(R.id.FaceOne);
        Face2 = (ImageView) findViewById(R.id.FaceTwo);
        Face3 = (ImageView) findViewById(R.id.FaceThree);
        Face4 = (ImageView) findViewById(R.id.FaceFour);

        Face1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CategoryActivity.level += 1;
                CategoryActivity.grantONE = true;
                CategoryActivity.grantQuiz1 = false;
                Toast.makeText(QuizFaceActivity.this, "첫번째 문제를 맞추셨습니다!! 다음부터는 서술형 문제입니다.", Toast.LENGTH_SHORT).show();
                Intent it = new Intent(getApplicationContext(),CategoryActivity.class);
                startActivity(it);
            }
        });
        Face2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(QuizFaceActivity.this, "아 틀리셨네요..", Toast.LENGTH_SHORT).show();
            }
        });
        Face3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(QuizFaceActivity.this, "아 틀리셨네요..", Toast.LENGTH_SHORT).show();
            }
        });
        Face4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(QuizFaceActivity.this, "아 틀리셨네요..", Toast.LENGTH_SHORT).show();
            }
        });




    }
}
