package com.example.seniorstepsproject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
VideoView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        Firebase.setAndroidContext(this);
view=findViewById(R.id.vedio);
      view.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.firstsplash);
      view.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
          @Override
          public void onCompletion(MediaPlayer mp) {
              if (FirebaseAuth.getInstance().getCurrentUser()!=null){
                  startActivity(new Intent(MainActivity.this,menu.class));
                  overridePendingTransition(R.anim.slideinright, R.anim.slideoutleft);
              }
              else {
                  startActivity(new Intent(MainActivity.this, Login.class));
                  overridePendingTransition(R.anim.slideinright, R.anim.slideoutleft);
              }
          }
      });
      view.start();
    }
}

