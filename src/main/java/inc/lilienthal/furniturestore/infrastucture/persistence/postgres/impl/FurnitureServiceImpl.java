package inc.lilienthal.furniturestore.infrastucture.persistence.postgres.impl;

import inc.lilienthal.furniturestore.application.usecase.access.furniture.FurnitureService;
import inc.lilienthal.furniturestore.domain.Furniture;
import inc.lilienthal.furniturestore.infrastucture.persistence.postgres.model.mapper.FurnitureEntityMapper;
import inc.lilienthal.furniturestore.infrastucture.persistence.postgres.repository.FurnitureRepositoryJpa;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class FurnitureServiceImpl implements FurnitureService {

  private final FurnitureEntityMapper furnitureEntityMapper;
  private final FurnitureRepositoryJpa furnitureRepositoryJpa;

  @Override
  public void save(final Furniture furniture) {
    furnitureRepositoryJpa.save(furnitureEntityMapper.toFurnitureEntity(furniture));
    log.debug("Объект furniture с артикулом = {} сохранен в БД", furniture.getArticle());
  }

  @Override
  public List<Furniture> findAll() {
    return furnitureEntityMapper.toFurnitureDomainList(furnitureRepositoryJpa.findAll());
  }

  @Override
  public Furniture findByArticle(final String article) {
    return furnitureEntityMapper.toFurnitureDomain(furnitureRepositoryJpa.findByArticle(article));
  }

  @Override
  public void deleteByArticle(final String article) {
    furnitureRepositoryJpa.deleteByArticle(article);
  }

  @Override
  public List<Furniture> findByCategory(final String category) {
    return furnitureEntityMapper.toFurnitureDomainList(furnitureRepositoryJpa.findAllByCategory(category));
  }

  @Override
  public List<Furniture> findByModel(final String model) {
    return furnitureEntityMapper.toFurnitureDomainList(furnitureRepositoryJpa.findAllByModel(model));
  }
}
