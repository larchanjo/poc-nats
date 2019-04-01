package poc.nats.client;

import io.nats.client.Connection;
import io.nats.client.Nats;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Application {

  public static void main(String[] args) throws IOException, InterruptedException {
    Connection connection = Nats.connect();
    while (Boolean.TRUE) {
      TimeUnit.SECONDS.sleep(1);
      String message = UUID.randomUUID().toString();
      System.out.println("Sending message > " + message);
      connection.publish("queue", message.getBytes(StandardCharsets.UTF_8));
    }
  }

}