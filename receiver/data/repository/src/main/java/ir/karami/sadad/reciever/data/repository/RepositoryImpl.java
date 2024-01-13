package ir.karami.sadad.reciever.data.repository;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import ir.karami.sadad.receiver.data.source.database.Info;
import ir.karami.sadad.receiver.data.source.database.InfoDao;
import ir.karami.sadad.receiver.domain.CacheData;
import ir.karami.sadad.receiver.domain.Repository;

public class RepositoryImpl implements Repository {
    InfoDao infoDao;

    @Inject
    public RepositoryImpl(InfoDao appDatabase) {
        this.infoDao = appDatabase;
        infoDao.insertData(new Info("test",false));
        infoDao.getAllFlow()
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
        infoDao.insertData(new Info(data.value))
                .subscribeOn(Schedulers.io())
                .subscribe();
    }


    @Override
    public Flowable<List<CacheData>> getCachedValues() {
        return infoDao.getAllFlow().map(this::mapper);
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
        infoDao.getUnSyncedInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .doOnSuccess(infos -> {
                    infos.forEach(info -> {
                        infoDao.updateSent(info.id).subscribe();
                    });
                })
                .subscribe();

    }
}
