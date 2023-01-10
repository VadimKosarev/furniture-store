package inc.lilienthal.furniturestore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class FurnitureStoreApplication {

  public static void main(String[] args) {
    SpringApplication.run(FurnitureStoreApplication.class, args);
  }

}
