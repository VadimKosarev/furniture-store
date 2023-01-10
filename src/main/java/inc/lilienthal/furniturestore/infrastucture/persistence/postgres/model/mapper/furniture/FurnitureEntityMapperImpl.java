package inc.lilienthal.furniturestore.infrastucture.persistence.postgres.model.mapper.furniture;

import inc.lilienthal.furniturestore.domain.Furniture;
import inc.lilienthal.furniturestore.infrastucture.persistence.postgres.model.FurnitureEntity;
import inc.lilienthal.furniturestore.infrastucture.persistence.postgres.model.mapper.FurnitureEntityMapper;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class FurnitureEntityMapperImpl implements FurnitureEntityMapper {
  @Override
  public Furniture toFurnitureDomain(final FurnitureEntity furnitureEntity) {
    return Furniture.of(
      furnitureEntity.getId(),
      furnitureEntity.getArticle(),
      furnitureEntity.getName(),
      furnitureEntity.getManufacturer(),
      furnitureEntity.getCategory(),
      furnitureEntity.getModel(),
      furnitureEntity.getDescription(),
      furnitureEntity.getAmount()
    );
  }

  @Override
  public FurnitureEntity toFurnitureEntity(final Furniture furniture) {

    FurnitureEntity furnitureEntity = new FurnitureEntity();
    furnitureEntity.setId(furniture.getId());
    furnitureEntity.setArticle(furnitureEntity.getArticle());
    furnitureEntity.setName(furnitureEntity.getName());
    furnitureEntity.setCategory(furnitureEntity.getCategory());
    furnitureEntity.setModel(furnitureEntity.getModel());
    furnitureEntity.setDescription(furnitureEntity.getDescription());
    furnitureEntity.setAmount(furnitureEntity.getAmount());
    furnitureEntity.setManufacturer(furnitureEntity.getManufacturer());

    return furnitureEntity;
  }

  @Override
  public List<Furniture> toFurnitureDomainList(final List<FurnitureEntity> furnitureEntityList) {
    return furnitureEntityList.stream()
      .map(this::toFurnitureDomain)
      .collect(Collectors.toList());
  }

  @Override
  public List<FurnitureEntity> toFurnitureEntityList(final List<Furniture> furnitureList) {
    return furnitureList.stream()
      .map(this::toFurnitureEntity)
      .collect(Collectors.toList());
  }
}
