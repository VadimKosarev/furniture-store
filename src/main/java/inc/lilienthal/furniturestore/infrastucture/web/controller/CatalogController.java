package inc.lilienthal.furniturestore.infrastucture.web.controller;

import inc.lilienthal.furniturestore.application.usecase.scenario.furniture.FurnitureUseCase;
import inc.lilienthal.furniturestore.domain.Furniture;
import inc.lilienthal.furniturestore.infrastucture.web.mapper.FurnitureUiMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.api.CatalogApi;
import org.openapitools.model.FurnitureDto;
import org.springframework.http.HttpStatus;
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
    Furniture furniture = furnitureUiMapper.toFurnitureDomain(furnitureDto);
    furnitureUseCase.save(furniture);
    log.debug("Furniture has article {}, added in catalog", furniture.getArticle());
    return null;
  }

  @Override
  public ResponseEntity<List<FurnitureDto>> getAllFurniture() {
    List<FurnitureDto> furnitureDtoList = furnitureUiMapper.toFurnitureDtoList(
      furnitureUseCase.findAll()
    );
    return ResponseEntity
      .status(HttpStatus.OK)
      .body(furnitureDtoList);
  }

  @Override public ResponseEntity<List<FurnitureDto>> getFurnitureByArticle(final String article) {
    return CatalogApi.super.getFurnitureByArticle(article);
  }

  @Override public ResponseEntity<List<FurnitureDto>> getFurnitureListByCategory(final String category) {
    return CatalogApi.super.getFurnitureListByCategory(category);
  }

  @Override public ResponseEntity<List<FurnitureDto>> getFurnitureListByModel(final String model) {
    return CatalogApi.super.getFurnitureListByModel(model);
  }

  @Override public ResponseEntity<Void> removeFurnitureByArticle(final String article) {
    return CatalogApi.super.removeFurnitureByArticle(article);
  }
}
