package ir.karami.sadad.receiver.di;

import dagger.Module;
import ir.karami.sadad.receiver.data.source.database.DataBaseDiModule;
import ir.karami.sadad.receiver.data.source.network.di.NetworkModule;

@Module(includes = {
        NetworkModule.class,
        DataBaseDiModule.class
})
public class AppProviderModule {


}
