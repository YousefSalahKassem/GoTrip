package com.example.seniorstepsproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class gettrainticket extends AppCompatActivity {
    TextView passengername,adult,kid,passpor,start,finish,starttime,date,price,chooseclass,planename,finishtime,totaltime,phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gettrainticket);
        calling();
        Intent i=getIntent();
        String a=i.getStringExtra("name");
        String b=i.getStringExtra("placefrom");
        String c=i.getStringExtra("placeto");
        String d=i.getStringExtra("date");
        String e=i.getStringExtra("chooseclas");
        String f=i.getStringExtra("price");
        String h=i.getStringExtra("kids");
        String j=i.getStringExtra("passport");
        String k=i.getStringExtra("planename");
        String l=i.getStringExtra("du");
        String m=i.getStringExtra("timefinish");
        String n=i.getStringExtra("starttime");
        String z=i.getStringExtra("phone");
        passengername.setText(a);
        kid.setText(h);
        passpor.setText(j);
        start.setText(b);
        finish.setText(c);
        starttime.setText(n);
        finishtime.setText(m);
        date.setText(d);
        chooseclass.setText(e);
        price.setText(f);
        planename.setText(k);
        totaltime.setText(l);
        phone.setText(z);
    }
    private void calling() {
        passengername=findViewById(R.id.showname);
        kid=findViewById(R.id.showkids);
        passpor=findViewById(R.id.showpassport);
        start=findViewById(R.id.showfrom);
        finish=findViewById(R.id.showto);
        starttime=findViewById(R.id.showtimeto);
        date=findViewById(R.id.showdate);
        price=findViewById(R.id.showprice);
        chooseclass=findViewById(R.id.showclass);
        planename=findViewById(R.id.showairname);
        finishtime=findViewById(R.id.showt);
        totaltime=findViewById(R.id.showduration);
        phone=findViewById(R.id.showphone);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(gettrainticket.this,menu.class));
        overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);
    }}


