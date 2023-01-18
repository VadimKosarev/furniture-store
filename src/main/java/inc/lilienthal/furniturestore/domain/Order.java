package inc.lilienthal.furniturestore.domain;

import lombok.Getter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
public class Order {
  private String trackingNumber;
  private String dateOfCreation;
  private String clientName;
  private String clientEmail;
  private long totalAmount;
  private List<Furniture> furnitures;

  private Order(final String trackingNumber, final String dateOfCreation, final String clientName,
                final String clientEmail, final long totalAmount, final List<Furniture> furnitures) {
    this.trackingNumber = trackingNumber;
    this.dateOfCreation = dateOfCreation;
    this.clientName = clientName;
    this.clientEmail = clientEmail;
    this.totalAmount = totalAmount;
    this.furnitures = furnitures;
  }

  public static Order of(final String clientName, final String clientEmail,
                         final List<Furniture> furnitures) {

    return new Order(
      generateUUID().toString(), LocalDateTime.now().toString(), clientName, clientEmail, calculateTotalSum(furnitures),
      furnitures
    );
  }

  private static long calculateTotalSum(List<Furniture> furnitures) {
    return furnitures.stream()
      .mapToLong(Furniture::getAmount).sum();
  }

  private static UUID generateUUID() {
    return UUID.randomUUID();
  }


}
