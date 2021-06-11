package com.gurusankar149.trimevideotutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class FinalVideoActivity extends AppCompatActivity {
VideoView videoView;
Uri VideoUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fina_video);
        Intent getUri = getIntent();
        String VideoUriString = getUri.getStringExtra(MainActivity.VideoUri);
        VideoUri= Uri.parse(VideoUriString);
        videoView=findViewById(R.id.final_video_view);
        MediaController mediaController=new MediaController(this);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(VideoUri);
        videoView.start();

    }
}