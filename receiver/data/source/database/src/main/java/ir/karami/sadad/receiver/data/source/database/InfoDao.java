package ir.karami.sadad.receiver.data.source.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;

@Dao
public interface InfoDao {

    @Insert
    Completable insertData(Info info);

    @Query("update info set is_sent = 1 where id=:id")
    Completable updateSent(int id);

    @Query("select * from info order by id desc")
    Flowable<List<Info>> getAllFlow();

    @Query("select * from info where is_sent=0")
    Maybe<List<Info>> getUnSyncedInfo();
}
