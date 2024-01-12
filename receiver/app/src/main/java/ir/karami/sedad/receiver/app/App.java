package ir.karami.sedad.receiver.app;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import ir.karami.sedad.receiver.app.di.AppComponent;
import ir.karami.sedad.receiver.app.di.DaggerAppComponent;

public class App extends Application {
    public AppComponent appComponent;
    private static final long INTERVAL = 60 * 1000;


    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .application(this)
                .build();
        scheduleAlarm();
    }

    private void scheduleAlarm() {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(this, PeriodicAlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), INTERVAL, pendingIntent);
    }
}
