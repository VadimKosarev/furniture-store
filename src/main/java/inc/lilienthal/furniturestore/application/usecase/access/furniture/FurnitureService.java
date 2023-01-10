package inc.lilienthal.furniturestore.application.usecase.access.furniture;

import inc.lilienthal.furniturestore.domain.Furniture;
import java.util.List;

public interface FurnitureService {

  void save(Furniture furniture);

  List<Furniture> findAll();

  Furniture findByArticle(String article);

  void deleteByArticle(String article);

  List<Furniture> findByCategory(String category);

  List<Furniture> findByModel(String model);
}
