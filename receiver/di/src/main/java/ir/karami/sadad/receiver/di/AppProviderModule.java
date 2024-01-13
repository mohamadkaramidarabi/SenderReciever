package ir.karami.sadad.receiver.di;

import dagger.Module;
import ir.karami.sadad.receiver.data.source.database.DataBaseDiModule;
import ir.karami.sadad.receiver.data.source.network.NetworkModule;
import ir.karami.sadad.reciever.data.repository.RepositoryDi;

@Module(includes = {
        NetworkModule.class,
        DataBaseDiModule.class,
        RepositoryDi.class
})
public class AppProviderModule {}
