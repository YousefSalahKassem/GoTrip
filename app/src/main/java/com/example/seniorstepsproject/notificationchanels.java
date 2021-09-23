package com.example.seniorstepsproject;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class notificationchanels extends Application {
    public static final String Chanel1_ID="chanel1";
    @Override
    public void onCreate() {
        createnotification();
        super.onCreate();
    }
    private void createnotification() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel(Chanel1_ID,"chanel 1", NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("this is chanel");
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }
}
