package ir.karami.sadad.receiver.di;

import android.content.Context;

import androidx.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ir.karami.sadad.common.model.ApplicationContext;
import ir.karami.sadad.receiver.data.source.database.AppDatabase;

@Module
public class AppProviderModule {

    @Provides
    @Singleton
    AppDatabase provideDatabase(@ApplicationContext Context context)  {
        return Room.databaseBuilder(context, AppDatabase.class, "info.db")
                .addMigrations(AppDatabase.MIGRATION_2_3)
                .build();
    }
}
