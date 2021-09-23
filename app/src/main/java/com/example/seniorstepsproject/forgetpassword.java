package com.example.seniorstepsproject;

import android.app.Notification;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgetpassword extends AppCompatActivity {
EditText sendone;
Button confirm;
private FirebaseAuth auth;
    private NotificationManagerCompat managerCompat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_forgetpassword);

        sendone=findViewById(R.id.sendemail);
        confirm=findViewById(R.id.confirmsendemail);
        auth=FirebaseAuth.getInstance();
        managerCompat=NotificationManagerCompat.from(this);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String useremail=sendone.getText().toString();
                if(TextUtils.isEmpty(useremail)){sendone.setError("Email should be provided!");}
                else {
                    auth.sendPasswordResetEmail(useremail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                       if(task.isSuccessful()){
                           Toast.makeText(forgetpassword.this, "Please check your Email Account", Toast.LENGTH_SHORT).show();
                           Intent i=new Intent(forgetpassword.this,Login.class);
                           startActivity(i);
                           Notification notification=new NotificationCompat.Builder(forgetpassword.this,notificationchanels.Chanel1_ID).setSmallIcon(R.drawable.ic_email_white_18dp).setContentTitle("Check Email").setContentText("Please Check your Email to reset your password").setPriority(NotificationCompat.PRIORITY_HIGH).setCategory(NotificationCompat.CATEGORY_MESSAGE).setColor(Color.BLUE).setAutoCancel(true).setOnlyAlertOnce(true).build();
                           managerCompat.notify(1,notification);
                           overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);
                       }else {
                           String message=task.getException().getMessage();
                           Toast.makeText(forgetpassword.this, "Error happened: "+message, Toast.LENGTH_SHORT).show();
                       }
                        }
                    });
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slideinleft, R.anim.slideoutright);
    }
}
