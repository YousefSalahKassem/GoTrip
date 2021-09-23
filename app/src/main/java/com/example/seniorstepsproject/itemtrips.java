package com.example.seniorstepsproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class itemtrips extends AppCompatActivity {
TextView name,phone,address,from,to,date,starttime,timefinish,adults,kids,chooseclass,passport,price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemtrips);
        calling();
        Intent i=getIntent();
        String a=i.getStringExtra("name");
        String b= i.getStringExtra("phone");
        String c=i.getStringExtra("address");
        String d=i.getStringExtra("from");
        String e=i.getStringExtra("to");
        String f= i.getStringExtra("date");
        String g= i.getStringExtra("starttime");
        String h= i.getStringExtra("finishtime");
        String l=i.getStringExtra("kid");
        String m=i.getStringExtra("class");
        String n=i.getStringExtra("passport");
        String o=i.getStringExtra("price");
 name.setText(a);
 phone.setText(b);
 address.setText(c);
 from.setText(d);
 to.setText(e);
 date.setText(f);
 starttime.setText(g);
 timefinish.setText(h);

 kids.setText(l);
 chooseclass.setText(m);
 passport.setText(n);
 price.setText(o);
    }
    private void calling() {
        name=findViewById(R.id.errorr);
        phone=findViewById(R.id.phone);
        address=findViewById(R.id.address);
        from=findViewById(R.id.from);
        to=findViewById(R.id.to);
        date=findViewById(R.id.date);
        starttime=findViewById(R.id.starttime);
        timefinish=findViewById(R.id.edtdeparture);
        kids=findViewById(R.id.kids);
        chooseclass=findViewById(R.id.classs);
        passport=findViewById(R.id.passenger);
        price=findViewById(R.id.mymoney);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);
    }
}
