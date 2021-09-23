package com.example.seniorstepsproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class boardingpass extends AppCompatActivity {
    String save;
    String save2;
    String d;
    String save3;
    TextView t1,t2,t3,t4;
RecyclerView recyclerView;
ArrayList<insertmydata>insert;

myadapter getAdapter;
    DatabaseReference ref1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boardingpass);
        t1=findViewById(R.id.yourdate);
        t2=findViewById(R.id.myhome);
        t3=findViewById(R.id.yourhome);
        t4=findViewById(R.id.getclass);
        final Intent myintent=getIntent();
      save=myintent.getStringExtra("send");
      save2=myintent.getStringExtra("send2");
      d=myintent.getStringExtra("date");
      save3=myintent.getStringExtra("class");
      t1.setText(d);
      t2.setText(save2);
      t3.setText(save);
t4.setText(save3 +" class");
        recyclerView=findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        insert=new ArrayList<>();
        ref1= FirebaseDatabase.getInstance().getReference().child("search");
        Query query=ref1.orderByChild("to").equalTo(save);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot data:dataSnapshot.getChildren()){
                    insertmydata i=data.getValue(insertmydata.class);
                    if(i.getFrom().equals(save2)&&i.getDate().equals(d))
                    insert.add(i);
                    Collections.sort(insert);
                }
getAdapter=new myadapter(insert,boardingpass.this);
                recyclerView.setAdapter(getAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }


}
