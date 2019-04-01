package poc.nats.server;

import io.nats.client.Connection;
import io.nats.client.Message;
import io.nats.client.Nats;
import io.nats.client.Subscription;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

public class Application {

  public static void main(String[] args) throws IOException, InterruptedException {
    Connection connection = Nats.connect();
    Subscription subscription = connection.subscribe("queue");
    while (Boolean.TRUE) {
      Message message = subscription.nextMessage(Duration.ofMillis(500));
      if (message != null) {
        String response = new String(message.getData(), StandardCharsets.UTF_8);
        System.out.println("Received message > " + response);
      }
    }
  }

}