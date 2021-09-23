package com.example.seniorstepsproject;

import android.os.Bundle;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class mylasttrips extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<inserttofirebase> insert;
    adapter5 getAdapter;
    DatabaseReference ref1;
    RelativeLayout re;
    menu m=new menu();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mylasttrips);
        Firebase.setAndroidContext(this);
recyclerView=findViewById(R.id.rec1);

recyclerView.setLayoutManager(new LinearLayoutManager(this));
insert=new ArrayList<>();
String s=FirebaseAuth.getInstance().getCurrentUser().getUid();
         FirebaseUser firebase= FirebaseAuth.getInstance().getCurrentUser();
        ref1= FirebaseDatabase.getInstance().getReference("childinformation").child(s);
        Query query=ref1.orderByChild("email").equalTo(firebase.getEmail());
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot data:dataSnapshot.getChildren()){
            inserttofirebase i=data.getValue(inserttofirebase.class);
            insert.add(i);
                }getAdapter=new adapter5(insert,mylasttrips.this);
                recyclerView.setAdapter(getAdapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });        overridePendingTransition(R.anim.slideinright,R.anim.slideoutleft);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);
    }
}
