package poc.nats.server;

import io.nats.client.Connection;
import io.nats.client.Dispatcher;
import io.nats.client.Nats;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Application {

  public static void main(String[] args) throws IOException, InterruptedException {
    Connection connection = Nats.connect();
    Dispatcher dispatcher = connection.createDispatcher((message) -> {
      String data = new String(message.getData(), StandardCharsets.UTF_8);
      System.out.println("Received message > " + data);
    });
    dispatcher.subscribe("queue");
  }

}