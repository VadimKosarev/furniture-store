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
    furnitureEntity.setArticle(furniture.getArticle());
    furnitureEntity.setName(furniture.getName());
    furnitureEntity.setCategory(furniture.getCategory());
    furnitureEntity.setModel(furniture.getModel());
    furnitureEntity.setDescription(furniture.getDescription());
    furnitureEntity.setAmount(furniture.getAmount());
    furnitureEntity.setManufacturer(furniture.getManufacturer());

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
