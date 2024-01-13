package ir.karami.sadad.receiver.data.source.network;

import android.util.Log;

import java.net.URISyntaxException;
import java.util.Objects;
import java.util.stream.Stream;

import javax.inject.Inject;

import io.socket.client.IO;
import io.socket.client.Socket;

class NetworkApiImpl implements NetworkApi {


    private Socket socket;


    @Inject
    NetworkApiImpl() {
        try {
            socket = IO.socket("http://localhost/");
        } catch (URISyntaxException exception) {
            Log.d("exception", Objects.requireNonNull(exception.getMessage()));
        }
    }

    @Override
    public void sendMessage(String message) {
        socket.connect();
        if (socket.connected()) {
            socket.emit("new message",message);
        }
        socket.disconnect();
    }

    @Override
    public void sendMessages(Stream<String> messages) {
        socket.connected();
        if (socket.connected()) {
            messages.forEach( s -> {
                socket.emit("new message", s);
            });
        }
        socket.disconnect();
    }
}
