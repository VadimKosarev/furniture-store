package inc.lilienthal.furniturestore.infrastucture.web.mapper;

import inc.lilienthal.furniturestore.domain.Furniture;
import org.openapitools.model.FurnitureDto;
import java.util.List;

public interface FurnitureUiMapper {

   Furniture toFurnitureDomain(FurnitureDto furnitureDto);

   List<Furniture> toFurnitureDomainList(List<FurnitureDto> furnitureDtoList);

   FurnitureDto toFurnitureDto(Furniture furniture);

   List<FurnitureDto> toFurnitureDtoList(List<Furniture> furnitureList);

}
