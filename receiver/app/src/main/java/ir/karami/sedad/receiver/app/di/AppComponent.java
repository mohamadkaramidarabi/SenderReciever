package ir.karami.sedad.receiver.app.di;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import ir.karami.sadad.common.model.ApplicationContext;
import ir.karami.sadad.receiver.di.AppModule;
import ir.karami.sadad.receiver.di.AppProviderModule;
import ir.karami.sedad.receiver.app.InfoBroadcastReceiver;
import ir.karami.sedad.receiver.app.PeriodicAlarmReceiver;
import ir.karami.sedad.receiver.app.main.MainActivity;
import ir.karami.sedad.receiver.app.main.view.MainAdapter;

@Component(modules = {
        AppProviderModule.class,
        AppModule.class
})
@Singleton
public interface AppComponent {

    @Component.Builder
    interface Builder {
        AppComponent build();
        @BindsInstance

        Builder application(@ApplicationContext Context app);
    }


    void inject(MainActivity mainActivity);
    void inject(PeriodicAlarmReceiver periodicAlarmReceiver);
    void inject(InfoBroadcastReceiver infoBroadcastReceiver);

}
