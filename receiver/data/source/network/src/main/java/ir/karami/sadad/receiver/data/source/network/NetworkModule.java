package ir.karami.sadad.receiver.data.source.network;

import dagger.Module;
import dagger.Provides;

@Module
public class NetworkModule {

    @Provides
    NetworkApi provideNetworkApi(NetworkApiImpl impl) {
        return impl;
    }


}
