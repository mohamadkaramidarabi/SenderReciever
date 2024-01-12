package ir.karami.sadad.receiver.domain;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

public interface Repository {

    void save(CacheData data);

    void sync();

    Flowable<List<CacheData>> getCachedValues();

}