package ir.karami.sadad.receiver.di;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import ir.karami.sadad.receiver.domain.Repository;
import ir.karami.sadad.reciever.data.repository.RepositoryImpl;

@Module
public abstract class AppModule {

    @Binds
    @Singleton
    abstract Repository bindRepository(RepositoryImpl repository);
}
