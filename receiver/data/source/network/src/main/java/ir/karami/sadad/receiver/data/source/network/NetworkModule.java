package ir.karami.sadad.receiver.data.source.network;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class NetworkModule {

    @Provides
    @Singleton
    NetworkApi provideNetworkApi(NetworkApiImpl impl) {
        return impl;
    }




}
