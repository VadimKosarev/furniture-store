package inc.lilienthal.furniturestore.domain;

import lombok.Getter;
import java.util.List;

@Getter
public class Order {
  private long id;
  private String trackingNumber;
  private String dateOfCreation;
  private String clientName;
  private String clientEmail;
  private long totalAmount;
  private List<Furniture> furnitures;

  private Order(final long id, final String trackingNumber, final String dateOfCreation, final String clientName,
                final String clientEmail, final long totalAmount, final List<Furniture> furnitures) {
    this.id = id;
    this.trackingNumber = trackingNumber;
    this.dateOfCreation = dateOfCreation;
    this.clientName = clientName;
    this.clientEmail = clientEmail;
    this.totalAmount = totalAmount;
    this.furnitures = furnitures;
  }

  public static Order of(final long id, final String trackingNumber, final String dateOfCreation,
                         final String clientName,
                         final String clientEmail, final long totalAmount, final List<Furniture> furnitures) {

    return new Order(id, trackingNumber, dateOfCreation, clientName, clientEmail, totalAmount, furnitures);
  }

}
