package ir.karami.sadad.reciever.data.repository;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import ir.karami.sadad.receiver.domain.Repository;

@Module
public abstract class RepositoryDi {
    @Binds
    @Singleton
    abstract Repository provideRepository(RepositoryImpl impl);
}
