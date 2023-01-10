package inc.lilienthal.furniturestore.infrastucture.persistence.postgres.model.mapper;

import inc.lilienthal.furniturestore.domain.Furniture;
import inc.lilienthal.furniturestore.infrastucture.persistence.postgres.model.FurnitureEntity;
import java.util.List;

public interface FurnitureEntityMapper {

  Furniture toFurnitureDomain(FurnitureEntity furnitureEntity);

  FurnitureEntity toFurnitureEntity(Furniture furniture);

  List<Furniture> toFurnitureDomainList(List<FurnitureEntity> furnitureEntityList);

  List<FurnitureEntity> toFurnitureEntityList(List<Furniture> furnitureList);


}
