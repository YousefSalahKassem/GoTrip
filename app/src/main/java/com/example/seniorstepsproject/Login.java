package com.example.seniorstepsproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
ImageButton signin;
Button signup;
EditText email,password;
FirebaseAuth auth;
TextView forgetpas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Firebase.setAndroidContext(this);
        signin=findViewById(R.id.signin);
        signup=findViewById(R.id.signup);
        email=findViewById(R.id.email);
        forgetpas=findViewById(R.id.forget);
        password=findViewById(R.id.password);
        auth=FirebaseAuth.getInstance();
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,signup.class));
                overridePendingTransition(R.anim.slideinright,R.anim.slideoutleft);
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e=email.getText().toString();
                String p=password.getText().toString();
                if(TextUtils.isEmpty(e)){
                    email.setError("Email is Required");
                    return;
                }
                if(TextUtils.isEmpty(p)){
                    password.setError("Password is Required");
                    return;
                }
                auth.signInWithEmailAndPassword(e,p).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(Login.this,menu.class));
                            overridePendingTransition(R.anim.slideinright,R.anim.slideoutleft);
                            Toast.makeText(Login.this, "Successful login", Toast.LENGTH_SHORT).show();

                        }else{
                            Toast.makeText(Login.this, "Errors in Email or Password please try again!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
forgetpas.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
startActivity(new Intent(Login.this,forgetpassword.class));
        overridePendingTransition(R.anim.slideinright,R.anim.slideoutleft);

    }
});
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
        overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);
    }
}


