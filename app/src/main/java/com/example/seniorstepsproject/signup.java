package com.example.seniorstepsproject;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
public class signup extends AppCompatActivity {
EditText email;
EditText password;
        EditText confirm;
FirebaseAuth auth;
ImageButton signup;
Button signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
email=findViewById(R.id.name);
password=findViewById(R.id.password);
confirm=findViewById(R.id.confirmpass);
signup=findViewById(R.id.signup);
signin=findViewById(R.id.signin);
auth=FirebaseAuth.getInstance();
signin.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(signup.this,Login.class));
        overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);

    }
});
signup.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String e=email.getText().toString();
        String pass=password.getText().toString();
        String cpass=confirm.getText().toString();
        if (TextUtils.isEmpty(e)){email.setError("Email should be provided");return;}
       else if (TextUtils.isEmpty(pass)){password.setError("Password should be provided");return;}
      else  if (pass.length()<6){password.setError("Password should be greater than 6 characters");return;}
       else if (TextUtils.isEmpty(cpass)){confirm.setError("Password should be provided");return;}

        else{
        auth.createUserWithEmailAndPassword(e,pass).addOnCompleteListener(signup.this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(signup.this, "Successful Register", Toast.LENGTH_SHORT).show();
startActivity(new Intent(signup.this,Login.class));
                    overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);
                }
            else {
                    Toast.makeText(signup.this, "error happened ! ,please try again..", Toast.LENGTH_SHORT).show();

                }}
        });
    }}
});

    }
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);}

}