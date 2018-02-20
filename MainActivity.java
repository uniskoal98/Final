package com.example.a.afinal;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.icu.util.Measure;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.solver.Goal;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import android.widget.ViewAnimator;

public class MainActivity extends AppCompatActivity {
    //Background
    ConstraintLayout background;
    //leveling
    LinearLayout face,condition,hobby,Music,MyDream;

    //hobby
    ImageView hobby_Game,hobby_Basketball,hobby_programming;

    //Music
    ImageView bestsong1,bestsong2,Song1,Song2,Song3,Song4,Song5,Song6;

    //Face
    ImageView Quiz_Face;

    //condition
    ImageView  Quiz_Condition;
    static String tag;

    //Dream
    LinearLayout SlideLayout;
    ImageView left,right;
    int slide = 1;

    private ViewAnimator my_ani;
    Animation to_left;
    Animation out_left;
    Animation to_right;
    Animation out_right;
    LinearLayout Dreamlayout,Planlayout,Goallayout;
    Button DREAM,PLAN,GOAL;
    VideoView Goal_gamemaker;
    static boolean quiz_condition,quiz_hobby,quiz_dream;





    //quiz
    boolean grantQ1,grantQ2,grantQ3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ConstraintLayout
        background = (ConstraintLayout) findViewById(R.id.Background);

        //finish

        //leveling
        face = (LinearLayout) findViewById(R.id.Face);
        condition = (LinearLayout) findViewById(R.id.Condition);
        hobby = (LinearLayout) findViewById(R.id.Hobby);
        Music = (LinearLayout) findViewById(R.id.lovemusic);
        MyDream = (LinearLayout) findViewById(R.id.MyDream);

        Intent it = getIntent();
        int LEVEL = it.getIntExtra("level",0);

        if(LEVEL == 1) {
            face.setVisibility(View.VISIBLE);
            condition.setVisibility(View.GONE);
            hobby.setVisibility(View.GONE);
            Music.setVisibility(View.GONE);
            MyDream.setVisibility(View.GONE);
        }
        else if(LEVEL == 2) {
            face.setVisibility(View.GONE);
            condition.setVisibility(View.VISIBLE);
            hobby.setVisibility(View.GONE);
            Music.setVisibility(View.GONE);
            MyDream.setVisibility(View.GONE);
        }
        else if(LEVEL == 3) {
            face.setVisibility(View.GONE);
            condition.setVisibility(View.GONE);
            hobby.setVisibility(View.VISIBLE);
            Music.setVisibility(View.GONE);
            MyDream.setVisibility(View.GONE);
            background.setBackgroundResource(R.drawable.hobbybackground);
        }
        else if(LEVEL == 4) {
            face.setVisibility(View.GONE);
            condition.setVisibility(View.GONE);
            hobby.setVisibility(View.GONE);
            Music.setVisibility(View.VISIBLE);
            MyDream.setVisibility(View.GONE);
            background.setBackgroundResource(R.drawable.musicbackground);
        }
        else if(LEVEL == 5) {
            face.setVisibility(View.GONE);
            condition.setVisibility(View.GONE);
            hobby.setVisibility(View.GONE);
            Music.setVisibility(View.GONE);
            MyDream.setVisibility(View.VISIBLE);
        }

        //leveling finish

        //Face

        Quiz_Face = (ImageView) findViewById(R.id.quizbutton);

        Quiz_Face.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(CategoryActivity.grantQuiz1 == true) {

                    Intent it = new Intent(getApplicationContext(), QuizFaceActivity.class);
                    startActivity(it);
                }
                else {
                    Toast.makeText(MainActivity.this, "이미 푼 문제이므로 들어갈 수 없습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //Face finish

        //Condition

        //finish



        //hobby
        hobby_Game = (ImageView) findViewById(R.id.Terraria);
        hobby_Basketball = (ImageView) findViewById(R.id.basketball);
        hobby_programming = (ImageView) findViewById(R.id.programming);

                hobby_Game.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent it = new Intent(getApplicationContext(),VideoActivity.class);
                        it.putExtra("hobby_image",R.drawable.terraria);
                        it.putExtra("hobby_video",R.raw.terrariamovie);
                        startActivity(it);

                    }
                });
                hobby_Basketball.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent it = new Intent(getApplicationContext(),VideoActivity.class);
                        it.putExtra("hobby_image",R.drawable.basketball);
                        it.putExtra("hobby_video",R.raw.nba);
                        startActivity(it);

                    }
                });
                hobby_programming.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent it = new Intent(getApplicationContext(),VideoActivity.class);
                        it.putExtra("hobby_image",R.drawable.programming);
                        it.putExtra("hobby_video",R.raw.programming);
                        startActivity(it);

            }
        });
                //hobby finish



        //Music
        bestsong1 = (ImageView) findViewById(R.id.MyBestsong);
        bestsong2 = (ImageView) findViewById(R.id.MyBestsong2);
        Song1 = (ImageView) findViewById(R.id.Song1);
        Song2 = (ImageView) findViewById(R.id.Song2);
        Song3 = (ImageView) findViewById(R.id.Song3);
        Song4 = (ImageView) findViewById(R.id.Song4);
        Song5 = (ImageView) findViewById(R.id.Song5);
        Song6 = (ImageView) findViewById(R.id.Song6);

        bestsong1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(),MusicActivity.class);
                it.putExtra("Name",R.string.music1);
                it.putExtra("Artist",R.string.artist1);
                it.putExtra("playmusic",R.raw.song1);


                startActivity(it);
            }
        });
        bestsong2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(),MusicActivity.class);
                it.putExtra("Name",R.string.music2);
                it.putExtra("playmusic",R.raw.song2);
                it.putExtra("Artist",R.string.artist2);


                startActivity(it);
            }
        });
        Song1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(),MusicActivity.class);
                it.putExtra("Name",R.string.music3);
                it.putExtra("Artist",R.string.artist3);
                it.putExtra("playmusic",R.raw.song3);


                startActivity(it);
            }
        });
        Song2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(),MusicActivity.class);
                it.putExtra("Name",R.string.music4);
                it.putExtra("Artist",R.string.artist4);
                it.putExtra("playmusic",R.raw.song4);


                startActivity(it);
            }
        });
        Song3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(),MusicActivity.class);
                it.putExtra("Name",R.string.music5);
                it.putExtra("Artist",R.string.artist5);
                it.putExtra("playmusic",R.raw.song5);


                startActivity(it);
            }
        });
        Song4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(),MusicActivity.class);
                it.putExtra("Name",R.string.music6);
                it.putExtra("Artist",R.string.artist6);
                it.putExtra("playmusic",R.raw.song6);


                startActivity(it);
            }
        });
        Song5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(),MusicActivity.class);
                it.putExtra("Name",R.string.music7);
                it.putExtra("Artist",R.string.artist7);
                it.putExtra("playmusic",R.raw.song7);


                startActivity(it);
            }
        });
        Song6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(),MusicActivity.class);
                it.putExtra("Name",R.string.music8);
                it.putExtra("Artist",R.string.artist8);
                it.putExtra("playmusic",R.raw.song8);


                startActivity(it);
            }
        });
        //music finish

        //Dream
        my_ani = (ViewAnimator) findViewById(R.id.imageslide);
        Dreamlayout = (LinearLayout) findViewById(R.id.DreamLayout);
        Planlayout = (LinearLayout) findViewById(R.id.PlanLayout);
        Goallayout = (LinearLayout) findViewById(R.id.GoalLayout);
        DREAM = (Button) findViewById(R.id.DREAM);
        PLAN = (Button) findViewById(R.id.PLAN);
        GOAL = (Button) findViewById(R.id.GOAL);
        to_left = AnimationUtils.loadAnimation(this, R.anim.to_left);
        out_left = AnimationUtils.loadAnimation(this, R.anim.out_left);
        to_right = AnimationUtils.loadAnimation(this, R.anim.to_right);
        out_right = AnimationUtils.loadAnimation(this, R.anim.out_right);
        SlideLayout = (LinearLayout) findViewById(R.id.PlanImage);
        left = (ImageView) findViewById(R.id.left);
        right = (ImageView) findViewById(R.id.right);
        Goal_gamemaker = (VideoView) findViewById(R.id.GoalVideo);

        DREAM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dreamlayout.setVisibility(View.VISIBLE);
                Planlayout.setVisibility(View.GONE);
                Goallayout.setVisibility(View.GONE);
                Goal_gamemaker.pause();
            }
        });
        PLAN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dreamlayout.setVisibility(View.GONE);
                Planlayout.setVisibility(View.VISIBLE);
                Goallayout.setVisibility(View.GONE);
                Goal_gamemaker.pause();
            }
        });
        GOAL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dreamlayout.setVisibility(View.GONE);
                Planlayout.setVisibility(View.GONE);
                Goallayout.setVisibility(View.VISIBLE);

                Resources res = getResources();
                Uri uri = Uri.parse("android.resource://com.example.a.afinal/"+R.raw.gamemakerdream);

                Goal_gamemaker.setVideoURI(uri);
                Goal_gamemaker.start();
            }
        });

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slideLeft();
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slideRight();
            }
        });
    }
    public void slideLeft() {
        my_ani.setInAnimation(to_right);  //기껏 코드 짰더니 반대로 진행되서 이름이 반대입니다 이해해주시길.
        my_ani.setOutAnimation(out_right);
        my_ani.showPrevious();
    }
    public void slideRight() {
        my_ani.setInAnimation(to_left);
        my_ani.setOutAnimation(out_left);
        my_ani.showNext();
    }
    public void quiztotal(View v) {
        int id = v.getId();
        ImageView VIEW = (ImageView) findViewById(id);
        String tag = (String) VIEW.getTag();
        if(tag.equals("1") && quiz_condition == true) {
            Toast.makeText(this, "이미 푼 문제이므로 들어가실 수 없습니다.", Toast.LENGTH_SHORT).show();
        }
        else if(tag.equals("2") && quiz_hobby == true) {
            Toast.makeText(this, "이미 푼 문제이므로 들어가실 수 없습니다.", Toast.LENGTH_SHORT).show();
        }
        else if(tag.equals("4") && quiz_dream == true) {
            Toast.makeText(this, "이미 푼 문제이므로 들어가실 수 없습니다.", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent it = new Intent(getApplicationContext(), QuizTotalActivity.class);
            it.putExtra("tag", tag);

            startActivity(it);
        }


    }
}
