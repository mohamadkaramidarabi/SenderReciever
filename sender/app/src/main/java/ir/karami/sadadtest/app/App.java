package ir.karami.sadadtest.app;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import ir.karami.sadadtest.app.di.ApplicationComponent;
import ir.karami.sadadtest.app.di.DaggerApplicationComponent;

public class App extends Application {

    public ApplicationComponent appComponent =  DaggerApplicationComponent.create();


}
