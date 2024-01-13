package ir.karami.sedad.receiver.app;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import ir.karami.sadad.common.model.Constants;
import ir.karami.sedad.receiver.app.di.AppComponent;
import ir.karami.sedad.receiver.app.di.DaggerAppComponent;

public class App extends Application {
    public AppComponent appComponent;
    private static final long INTERVAL = 60 * 1000;


    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .application(this)
                .build();
        scheduleAlarm();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Constants.RECEIVER_ACTION_NAME);
        InfoBroadcastReceiver infoBroadcastReceiver = new InfoBroadcastReceiver();
        registerReceiver(infoBroadcastReceiver, filter);
    }

    private void scheduleAlarm() {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(this, PeriodicAlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), INTERVAL, pendingIntent);
    }
}
