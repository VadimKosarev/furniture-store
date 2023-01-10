package inc.lilienthal.furniturestore.application.usecase.scenario.furniture;

import inc.lilienthal.furniturestore.application.usecase.access.furniture.FurnitureService;
import inc.lilienthal.furniturestore.domain.Furniture;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RequiredArgsConstructor
public class FurnitureUseCase {

  private final FurnitureService furnitureService;

  public void save(Furniture furniture) {
    furnitureService.save(furniture);
  }

  public List<Furniture> findAll() {
    return furnitureService.findAll();
  }

  public Furniture findByArticle(String article) {
    return furnitureService.findByArticle(article);
  }

  public void deleteByArticle(String article) {
    furnitureService.deleteByArticle(article);
  }

  public List<Furniture> findByCategory(String category) {
    return furnitureService.findByCategory(category);
  }

  public List<Furniture> findByModel(String model) {
    return furnitureService.findByModel(model);
  }
}
