package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final int NOTIFICATION_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Main Activity");

        Button btn_SendNotofication = findViewById(R.id.btn_SendNotification);
        btn_SendNotofication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification();
                Intent intent = new Intent(MainActivity.this, Click_Activity.class);
                startActivity(intent);
            }
        });


//        View buttonNotify = findViewById(R.id.buttonNotify);
//        NotificationChannel channel;
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            channel = new NotificationChannel("My Notification", "My Notification", NotificationManager.IMPORTANCE_HIGH);
//            channel.setLightColor(Color.GRAY);
//            channel.enableLights(true);
//            AudioAttributes audioAttributes = new AudioAttributes.Builder()
//                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
//                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
//                    .build();
//            channel.setSound(uri, audioAttributes);
//            NotificationManager manager = getSystemService(NotificationManager.class);
//            manager.createNotificationChannel(channel);
//        }
//        buttonNotify.setOnClickListener(v -> sendNotification());
    }

    private void sendNotification() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sound_1);

        // Create an Intent for the activity you want to start
        Intent resultIntent = new Intent(this, Click_Activity.class);
        // Create the TaskStackBuilder and add the intent, which inflates the back stack
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addNextIntentWithParentStack(resultIntent);
        // Get the PendingIntent containing the entire back stack
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(NOTIFICATION_ID,
                        PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        Notification notification = new NotificationCompat.Builder(MainActivity.this, "CHANNEL 1")
                .setContentTitle("title")
                .setContentText("Text")
                .setSound(uri)
                .setColor(getResources().getColor(R.color.purple_500))
                .setSmallIcon(R.drawable.icons8_kali_linux)
                .setLargeIcon(bitmap)
                .setContentIntent(resultPendingIntent)
                .build();

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(NOTIFICATION_ID, notification);
    }

//    public Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sound_1);
//    private void sendNotification() {
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
//
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "My Notification");
//        builder.setSmallIcon(R.drawable.icons8_kali_linux);
//        builder.setLargeIcon(bitmap);
//        builder.setSound(uri);
//        builder.setContentTitle("New Message");
//        builder.setContentText("Chúc mừng bạn đã tạo một thông báo mới thành công");
//        builder.setAutoCancel(true);
//        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
//        managerCompat.notify(1, builder.build());
//    }
}