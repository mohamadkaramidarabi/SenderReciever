package ir.karami.sedad.receiver.app;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import javax.inject.Inject;

import ir.karami.sadad.receiver.domain.Repository;

public class PeriodicAlarmReceiver extends BroadcastReceiver {

    @Inject
    Repository repository;

    @SuppressLint("UnsafeProtectedBroadcastReceiver")
    @Override
    public void onReceive(Context context, Intent intent) {
        ((App) context.getApplicationContext()).appComponent.inject(this);
        repository.sync();

    }
}
