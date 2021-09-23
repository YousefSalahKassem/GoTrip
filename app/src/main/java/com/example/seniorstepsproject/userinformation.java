package com.example.seniorstepsproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class userinformation extends AppCompatActivity {
EditText f,l,p,a,pss;
Button s;
Firebase fire4;
DatabaseReference ref1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userinformation);
        Firebase.setAndroidContext(this);
        calling();
s.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(TextUtils.isEmpty(f.getText().toString())){f.setError("First Name is required!");}
        else if(TextUtils.isEmpty(l.getText().toString())){l.setError("Last Name is required!");}
        else if(TextUtils.isEmpty(p.getText().toString())){p.setError("Phone is required!");}
        else if(TextUtils.isEmpty(a.getText().toString())){a.setError("Address is required!");}
        else if(TextUtils.isEmpty(pss.getText().toString())){pss.setError("Passport is required");}
        else {
            FirebaseUser firebase = FirebaseAuth.getInstance().getCurrentUser();
            insertuserinformation insert = new insertuserinformation();
            insert.setEmail(firebase.getEmail());
            insert.setFname(f.getText().toString());
            insert.setLname(l.getText().toString());
            insert.setPhone(p.getText().toString());
            insert.setAddress(a.getText().toString());
            insert.setPassport(pss.getText().toString());
            fire4 = new Firebase("https://senior-steps-project.firebaseio.com/");
            FirebaseUser fire = FirebaseAuth.getInstance().getCurrentUser();
            Firebase fireb = fire4.child("userinformation").child(fire.getUid());
            fireb.push().setValue(insert);
            startActivity(new Intent(userinformation.this, menu.class));
            overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);
        }
    }
});
        String snote=FirebaseAuth.getInstance().getCurrentUser().getUid();
        FirebaseUser f2= FirebaseAuth.getInstance().getCurrentUser();
        ref1= FirebaseDatabase.getInstance().getReference("userinformation").child(snote);
        Query query=ref1.orderByChild("email").equalTo(f2.getEmail());
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot data:dataSnapshot.getChildren()){
                    insertuserinformation i=data.getValue(insertuserinformation.class);
                    f.setText(i.getFname());
                    l.setText(i.getLname());
                    p.setText(i.getPhone());
                    a.setText(i.getAddress());
                    pss.setText(i.getPassport());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }


    private void calling() {
        f=findViewById(R.id.ff);
        l=findViewById(R.id.ll);
        p=findViewById(R.id.pp);
        a=findViewById(R.id.aa);
        pss=findViewById(R.id.ps);
s=findViewById(R.id.ss);
    }
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);
    }
}
