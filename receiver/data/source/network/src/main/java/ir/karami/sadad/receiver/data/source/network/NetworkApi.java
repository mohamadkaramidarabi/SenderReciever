package ir.karami.sadad.receiver.data.source.network;

import java.util.stream.Stream;

public interface NetworkApi {

    void sendMessage(String message);

    void sendMessages(Stream<String> messages);
}
