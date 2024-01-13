package ir.karami.sadad.receiver.data.source.network;

import java.net.URISyntaxException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.socket.client.IO;
import io.socket.client.Socket;

@Module


public class NetworkModule {

    @Provides
    @Singleton
    NetworkApi provideNetworkApi(NetworkApiImpl impl) {
        return impl;
    }




}
