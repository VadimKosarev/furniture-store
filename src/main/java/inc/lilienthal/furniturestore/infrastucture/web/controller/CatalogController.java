package inc.lilienthal.furniturestore.infrastucture.web.controller;

import inc.lilienthal.furniturestore.application.usecase.scenario.furniture.FurnitureUseCase;
import inc.lilienthal.furniturestore.infrastucture.web.mapper.FurnitureUiMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.api.CatalogApi;
import org.openapitools.model.FurnitureDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CatalogController implements CatalogApi {
  final FurnitureUseCase furnitureUseCase;
  final FurnitureUiMapper furnitureUiMapper;

  @Override
  public ResponseEntity<Void> createFurniture(final FurnitureDto furnitureDto) {
    log.info("createFurniture start");
    furnitureUseCase.save(furnitureUiMapper.toFurnitureDomain(furnitureDto));
    return null;
  }

  @Override
  public ResponseEntity<List<FurnitureDto>> getAllFurniture() {
    return CatalogApi.super.getAllFurniture();
  }

  @Override
  public ResponseEntity<List<FurnitureDto>> getFurnitureByArticle(final String article) {
    return CatalogApi.super.getFurnitureByArticle(article);
  }

  @Override
  public ResponseEntity<List<FurnitureDto>> getFurnitureListByCategory(final String category) {
    return CatalogApi.super.getFurnitureListByCategory(category);
  }

  @Override
  public ResponseEntity<List<FurnitureDto>> getFurnitureListByModel(final String model) {
    return CatalogApi.super.getFurnitureListByModel(model);
  }

  @Override
  public ResponseEntity<Void> removeFurnitureByArticle(final String article) {
    return CatalogApi.super.removeFurnitureByArticle(article);
  }
}
