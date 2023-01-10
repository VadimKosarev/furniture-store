package inc.lilienthal.furniturestore.infrastucture.persistence.postgres.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class OrderEntity {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "tracking_number")
  private String trackingNumber;
  @Column(name = "date_of_creation")
  private String dateOfCreation;
  @Column(name = "name_client")
  private String clientName;
  @Column(name = "email_client")
  private String clientEmail;
  @Column(name = "total_amount")
  private long totalAmount;

  @ManyToMany
  @JoinTable(
    name = "furniture_orders",
    joinColumns = @JoinColumn(name = "orders_id"),
    inverseJoinColumns = @JoinColumn(name = "furniture_id")
  )
  private List<FurnitureEntity> furnitureEntityList = new ArrayList<>();
}
