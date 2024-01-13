package ir.karami.sedad.receiver.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Objects;

import javax.inject.Inject;

import ir.karami.sadad.common.model.Constants;
import ir.karami.sadad.receiver.domain.CacheData;
import ir.karami.sadad.receiver.domain.Repository;

public class InfoBroadcastReceiver extends BroadcastReceiver {

    @Inject
    Repository repository;


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("onReceive","reach hear");
        ((App) context.getApplicationContext()).appComponent.inject(this);
        if (Objects.equals(intent.getAction(), Constants.RECEIVER_ACTION_NAME)) {
            String value = Objects.requireNonNull(intent.getStringExtra(Constants.STRING_KEY));
            repository.save(new CacheData(value));
        }
    }
}
