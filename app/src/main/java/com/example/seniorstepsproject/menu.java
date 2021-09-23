package com.example.seniorstepsproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;

public class menu extends AppCompatActivity {
CardView cardfirst;
CardView cardView;
CardView card3;
CardView card4;
CardView card5;
CardView card6;
ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Firebase.setAndroidContext(this);
cardfirst=findViewById(R.id.first);
cardView=findViewById(R.id.second);
card3=findViewById(R.id.third);
card4=findViewById(R.id.four);
card5=findViewById(R.id.five);
card6=findViewById(R.id.six);
img=findViewById(R.id.mymenu);
cardfirst.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(menu.this,systeminformation.class));
        overridePendingTransition(R.anim.slideinright,R.anim.slideoutleft);
    }
});
cardView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(menu.this,traininformation.class));
        overridePendingTransition(R.anim.slideinright,R.anim.slideoutleft);

    }
});
card3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(menu.this,businformation.class));
        overridePendingTransition(R.anim.slideinright,R.anim.slideoutleft);

    }
});
card4.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(menu.this,tripinformation.class));
        overridePendingTransition(R.anim.slideinright,R.anim.slideoutleft);

    }
});
card5.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(menu.this,mylasttrips.class));
        overridePendingTransition(R.anim.slideinright,R.anim.slideoutleft);
    }
});
card6.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
startActivity(new Intent(menu.this,userinformation.class));
        overridePendingTransition(R.anim.slideinright,R.anim.slideoutleft);

    }
});
img.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        PopupMenu popupMenu=new PopupMenu(menu.this,img);
        popupMenu.getMenuInflater().inflate(R.menu.menus,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(menu.this,Login.class));
                overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);
                return true;
            }
        });
        popupMenu.show();
    }
});
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}
