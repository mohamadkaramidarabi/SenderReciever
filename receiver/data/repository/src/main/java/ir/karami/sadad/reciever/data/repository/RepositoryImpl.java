package ir.karami.sadad.reciever.data.repository;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import ir.karami.sadad.receiver.data.source.database.AppDatabase;
import ir.karami.sadad.receiver.data.source.database.Info;
import ir.karami.sadad.receiver.domain.CacheData;
import ir.karami.sadad.receiver.domain.Repository;

public class RepositoryImpl implements Repository {
    AppDatabase appDatabase;

    @Inject
    public RepositoryImpl(AppDatabase appDatabase) {
        this.appDatabase  = appDatabase;
        appDatabase.getInfoDao().insertData(new Info("test",false));
        appDatabase.getInfoDao().getAllFlow()
                .distinctUntilChanged()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext( infos -> {
                    infos.forEach(info -> {
                        Log.d("data", info.cachedValue + "  " + info.id);
                    });
                })
                .subscribe();
    }
    @Override
    public void save(CacheData data) {
        appDatabase.getInfoDao().insertData(new Info(data.value))
                .subscribeOn(Schedulers.io())
                .subscribe();
    }


    @Override
    public Flowable<List<CacheData>> getCachedValues() {
        return appDatabase.getInfoDao().getAllFlow().map(this::mapper);
    }

    private List<CacheData> mapper(List<Info> infos) {
        ArrayList<CacheData> list = new ArrayList<>();
        infos.forEach(info -> {
            list.add(new CacheData(
                    info.cachedValue,
                    info.isSent,
                    info.id
            ));
        });
        return list;
    }

    @Override
    public void sync() {
        appDatabase.getInfoDao().getUnSyncedInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .doOnSuccess(infos -> {
                    infos.forEach(info -> {
                        appDatabase.getInfoDao().updateSent(info.id).subscribe();
                    });
                })
                .subscribe();

    }
}
