package com.example.seniorstepsproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class businformation extends AppCompatActivity {
    EditText name,from,to,kids,date,myclass,phone;
    LinearLayout layout;
    Spinner spinner;
    Context context;
    ArrayList<String> myarraylist = new ArrayList<>();
    Firebase firebase1;
    SharedPreferences sharedPreferences;
    DatabaseReference ref1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_businformation);
        Firebase.setAndroidContext(this);
        calling();
        String snote= FirebaseAuth.getInstance().getCurrentUser().getUid();
        FirebaseUser f2= FirebaseAuth.getInstance().getCurrentUser();
        ref1= FirebaseDatabase.getInstance().getReference("userinformation").child(snote);
        Query query=ref1.orderByChild("email").equalTo(f2.getEmail());
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot dataSnapshot) {
                for (com.google.firebase.database.DataSnapshot data:dataSnapshot.getChildren()){
                    insertuserinformation i=data.getValue(insertuserinformation.class);
                    String a=i.getFname()+" "+i.getLname();
                    String b=i.getPhone();
                    name.setText(a);
                    phone.setText(b);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        firebase1=new Firebase("https://senior-steps-project.firebaseio.com/Timecountry");
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(businformation.this, android.R.layout.simple_spinner_dropdown_item, myarraylist);
        spinner.setAdapter(adapter);
        firebase1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String Childvalue = dataSnapshot.getValue(String.class);
                myarraylist.add(Childvalue);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(name.getText().toString())){name.setError("Name is required!");}
                else if(TextUtils.isEmpty(phone.getText().toString())){phone.setError("Phone is required! ");}
                else if(TextUtils.isEmpty(from.getText().toString())){from.setError("Place is required! ");}
                else if(TextUtils.isEmpty(to.getText().toString())){to.setError("Place is required! ");}
                else if(TextUtils.isEmpty(date.getText().toString())){date.setError("Date is required! ");}
                else  if(TextUtils.isEmpty(myclass.getText().toString())){myclass.setError("Class is required! ");}
                else{
                sharedPreferences=getSharedPreferences("savedata",context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("value",name.getText().toString());
                editor.putString("kids",kids.getText().toString());
                editor.putString("phone",phone.getText().toString());
                editor.apply();
                Intent i=new Intent(businformation.this,searchbus.class);
                i.putExtra("send",to.getText().toString());
                i.putExtra("send2",from.getText().toString());
                i.putExtra("class",myclass.getText().toString());
                i.putExtra("date",date.getText().toString());
                startActivity(i);
                overridePendingTransition(R.anim.slideinright,R.anim.slideoutleft);
            }}
        });
    }
    private void calling() {
        phone=findViewById(R.id.phone);
        name=findViewById(R.id.passengername);
        from=findViewById(R.id.from);
        to=findViewById(R.id.to);
        kids=findViewById(R.id.kids);
        date=findViewById(R.id.date);
        layout=findViewById(R.id.linear);
        spinner=findViewById(R.id.edtdeparture);
        myclass=findViewById(R.id.classs);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);
    }
    }

