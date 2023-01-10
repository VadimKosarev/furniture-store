package inc.lilienthal.furniturestore.infrastucture.persistence.postgres.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "furniture")
public class FurnitureEntity {

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name = "article")
  private String article;
  @Column(name = "name")
  private String name;
  @Column(name = "manufacturer")
  private String manufacturer;
  @Column(name = "category")
  private String category;
  @Column(name = "model")
  private String model;
  @Column(name = "description")
  private String description;
  @Column(name = "amount")
  private long amount;
}
