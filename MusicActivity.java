package com.example.a.afinal;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewAnimator;
import android.widget.SeekBar.OnSeekBarChangeListener;


public class MusicActivity extends AppCompatActivity{


    CountDownTimer MusicFlow;
    MediaPlayer Mpplayer = new MediaPlayer();
    ImageView cd,re;
    TextView title,artist,time,Musiclength;
    SeekBar Bar;
    Button send;
    ImageView quiz;
    int MusicTime;
    boolean looping;
    static boolean quiz_music;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        title = (TextView) findViewById(R.id.Title);
        artist = (TextView) findViewById(R.id.Artist);
        cd = (ImageView) findViewById(R.id.cd);
        re = (ImageView) findViewById(R.id.re);
        time = (TextView) findViewById(R.id.time);
        Musiclength = (TextView) findViewById(R.id.MusicLength);
        Bar = (SeekBar) findViewById(R.id.Musicbar);
        send = (Button) findViewById(R.id.PLAY);
        quiz = (ImageView) findViewById(R.id.quizbutton4);




        Resources res = getResources();




        Intent it = getIntent();
        int Titleid  = it.getIntExtra("Name",0);
        String Title = res.getString(Titleid);
        title.setText(Title);

        int Artistid = it.getIntExtra("Artist",0);
        String Artistname = res.getString(Artistid);
        artist.setText(Artistname);

        int Songid = it.getIntExtra("playmusic",0);

        Mpplayer = MediaPlayer.create(getApplicationContext(),Songid);

        MusicTime = Mpplayer.getDuration() / 1000;
        int min = MusicTime / 60;
        int second = MusicTime % 60;
        String songDur = min + ":" + second;
        Musiclength.setText(songDur);
        Bar.setMax(MusicTime);

        Bar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser) {
                    Mpplayer.seekTo(progress * 1000);
                }

            }

        });

        re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(looping == false) {
                    Toast.makeText(MusicActivity.this, "반복 설정", Toast.LENGTH_SHORT).show();
                    Mpplayer.pause();
                    Mpplayer.setLooping(!looping);
                    Mpplayer.start();
                }
                else {
                    Toast.makeText(MusicActivity.this, "반복 설정 해제", Toast.LENGTH_SHORT).show();
                    Mpplayer.pause();
                    Mpplayer.setLooping(!looping);
                    Mpplayer.start();
                }
                looping = !looping;
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RotateAnimation rotate = new RotateAnimation(0.0f,360.0f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                rotate.setInterpolator(new LinearInterpolator());
                rotate.setFillAfter(false);
                rotate.setDuration(3000);
                rotate.setRepeatCount(Animation.INFINITE);
                Resources res = getResources();
                if(Mpplayer.isPlaying()) {
                    Mpplayer.pause();
                    Drawable draw = res.getDrawable(R.drawable.playbutton);
                    send.setBackground(draw);
                    cd.clearAnimation();
                }
                else {
                    Mpplayer.setLooping(false);
                    Mpplayer.start();
                    MusicFlow.start();
                    cd.startAnimation(rotate);
                    Drawable draw2 = res.getDrawable(R.drawable.stopbutton);
                    send.setBackground(draw2);
                }
            }
        });

        MusicFlow = new CountDownTimer(Mpplayer.getDuration(), 1000) {
            @Override
            public void onTick(long l) {
                int allsec = Mpplayer.getCurrentPosition() / 1000;
                int min = allsec / 60;
                int second = allsec % 60;
                if(second < 10) {
                    String allsongDur = min + ":0" + second;
                    time.setText(allsongDur);
                }
                else {
                    String allsongDur = min + ":" + second;
                    time.setText(allsongDur);
                }
                Bar.setProgress(allsec);
            }

            @Override
            public void onFinish() {

            }
        };





    }
    protected void onStop() {
        Mpplayer.stop();
        MusicFlow.cancel();
        super.onStop();
    }

    protected void onDestroy() {
        Mpplayer.stop();
        Mpplayer.release();
        super.onDestroy();
    }

    public void quiztotal(View v) {
        int id = v.getId();
        ImageView VIEW = (ImageView) findViewById(id);
        String tag = (String) VIEW.getTag();
        if(tag.equals("3") && quiz_music == true) {
            Toast.makeText(this, "이미 푼 문제이므로 들어가실 수 없습니다.", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent it = new Intent(getApplicationContext(), QuizTotalActivity.class);
            it.putExtra("tag", tag);

            startActivity(it);
        }

    }
}
