package com.example.a.afinal;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    ImageView background;
    VideoView video;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        background = (ImageView) findViewById(R.id.setimage);
        video = (VideoView) findViewById(R.id.View);


        Resources res = getResources();

        Intent it = getIntent();

        int hobby_id = it.getIntExtra("hobby_image",0);

        background.setImageResource(hobby_id);

       int Video = it.getIntExtra("hobby_video",0);
        Uri uri = Uri.parse("android.resource://com.example.a.afinal/"+Video);

        video.setVideoURI(uri);
        MediaController mc = new MediaController(this);

        video.setMediaController(mc);
        video.start();











    }
}
