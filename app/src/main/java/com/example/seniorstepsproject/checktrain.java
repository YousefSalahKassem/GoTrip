package com.example.seniorstepsproject;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class checktrain extends AppCompatActivity {
    TextView passengername,adult,kid,passpor,start,finish,starttime,date,price,chooseclass,phone,address,totalprice;
    Firebase fire4;
    LinearLayout linearLayout;
  inserttofirebase insertl=new inserttofirebase();
    private NotificationManagerCompat managerCompat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checktrain);
        Firebase.setAndroidContext(this);
        managerCompat.from(this);
        phone=findViewById(R.id.phone);
        address=findViewById(R.id.address);
        passengername=findViewById(R.id.errorr);
        kid=findViewById(R.id.kids);
        totalprice=findViewById(R.id.totalprice);
        passpor=findViewById(R.id.passenger);
        start=findViewById(R.id.from);
        finish=findViewById(R.id.to);
        starttime=findViewById(R.id.edtdeparture);
        date=findViewById(R.id.date);
        price=findViewById(R.id.mymoney);
        chooseclass=findViewById(R.id.classs);
        linearLayout=findViewById(R.id.linear2);
        Intent myintent=getIntent();
        final String a= myintent.getStringExtra("from");
        String b= myintent.getStringExtra("to");
        String c= myintent.getStringExtra("time");
        String d= myintent.getStringExtra("date");
        String e= myintent.getStringExtra("price");
        String f=myintent.getStringExtra("chooseclass");
        final String g=myintent.getStringExtra("planename");
        final String h=myintent.getStringExtra("duration");
        final String j=myintent.getStringExtra("timefinish");
        SharedPreferences preferences=getSharedPreferences("savedata", Context.MODE_PRIVATE);
        String t=preferences.getString("value","");
        String v=preferences.getString("kids","");
        String p=preferences.getString("passport","");
        String k=preferences.getString("phone","");
        String z=preferences.getString("address","");
        chooseclass.setText(f);
        start.setText(a);
        finish.setText(b);
        starttime.setText(c);
        date.setText(d);
        price.setText(e+"$");
        double valuee=Double.parseDouble(e)+Double.parseDouble(e)*14/100;
        String ss=String.valueOf(valuee);
        totalprice.setText(ss);
        kid.setText(v);
        passpor.setText(p);
        phone.setText(k);
        address.setText(z);
        passengername.setText(t);
        FirebaseUser firebase2=FirebaseAuth.getInstance().getCurrentUser();
        insertl.setEmail(firebase2.getEmail());
        insertl.setName(passengername.getText().toString());
        insertl.setPhone(phone.getText().toString());
        insertl.setAddress(address.getText().toString());
        insertl.setFrom(start.getText().toString());
        insertl.setTo(finish.getText().toString());
        insertl.setTimefrom(starttime.getText().toString());
        insertl.setTimeto(j);
        insertl.setDuration(h);
        insertl.setKid(kid.getText().toString());
        insertl.setPassport(passpor.getText().toString());
        insertl.setPrice(ss);
        insertl.setChooseclass(chooseclass.getText().toString());
        insertl.setTypetravel(g);
        insertl.setDate(d);
        managerCompat=NotificationManagerCompat.from(this);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fire4=new Firebase("https://senior-steps-project.firebaseio.com/");
                FirebaseUser firebase=FirebaseAuth.getInstance().getCurrentUser();
                Firebase newchild=fire4.child("childinformation").child(firebase.getUid());
                newchild.push().setValue(insertl);
                if(insertl.getEmail().equals(firebase.getEmail())){
                    Intent i=new Intent(checktrain.this,gettrainticket.class);
                    i.putExtra("name",passengername.getText().toString());
                    i.putExtra("placefrom",start.getText().toString());
                    i.putExtra("date",date.getText().toString());
                    i.putExtra("placeto",finish.getText().toString());
                    i.putExtra("chooseclas",chooseclass.getText().toString());
                    i.putExtra("price",totalprice.getText().toString());
                    i.putExtra("kids",kid.getText().toString());
                    i.putExtra("passport",passpor.getText().toString());
                    i.putExtra("planename",g);
                    i.putExtra("phone",phone.getText().toString());
                    i.putExtra("du",h);
                    i.putExtra("starttime",starttime.getText().toString());
                    i.putExtra("timefinish",j);
                    startActivity(i);
                    overridePendingTransition(R.anim.slideinright,R.anim.slideoutleft);
                    PendingIntent intent=PendingIntent.getActivity(checktrain.this,0,i,PendingIntent.FLAG_UPDATE_CURRENT);
                    Notification notification=new NotificationCompat.Builder(checktrain.this,notificationchanels.Chanel1_ID).setSmallIcon(R.drawable.ic_train_black_24dp).setContentTitle("booking successful").setContentText("your booking confirmed !! thanks for this trust").setSubText("congratulations !!").setPriority(NotificationCompat.PRIORITY_HIGH).setCategory(NotificationCompat.CATEGORY_MESSAGE).setColor(Color.BLUE).addAction(R.drawable.ic_train_black_24dp,"Ticket",intent).setAutoCancel(true).setOnlyAlertOnce(true).build();
                    managerCompat.notify(1,notification);
                }
            }
        });
    } @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);
    }
}
