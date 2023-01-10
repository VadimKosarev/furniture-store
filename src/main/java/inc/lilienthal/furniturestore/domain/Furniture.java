package inc.lilienthal.furniturestore.domain;

import lombok.Getter;

@Getter
public class Furniture {

  private String article;
  private String name;
  private String manufacturer;
  private String category;
  private String model;
  private String description;
  private long amount;

  private Furniture(final String article, final String name, final String manufacturer,
                    final String category, final String model, final String description, final long amount) {
    this.article = article;
    this.name = name;
    this.manufacturer = manufacturer;
    this.category = category;
    this.model = model;
    this.description = description;
    this.amount = amount;
  }

  public static Furniture of(final String article, final String name, final String manufacturer,
                             final String category, final String model, final String description, final long amount) {

    return new Furniture(article, name, manufacturer, category, model, description, amount);
  }

}
