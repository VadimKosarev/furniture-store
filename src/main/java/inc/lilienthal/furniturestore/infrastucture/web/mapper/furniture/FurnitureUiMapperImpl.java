package inc.lilienthal.furniturestore.infrastucture.web.mapper.furniture;

import inc.lilienthal.furniturestore.domain.Furniture;
import inc.lilienthal.furniturestore.infrastucture.web.mapper.FurnitureUiMapper;
import org.openapitools.model.FurnitureDto;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FurnitureUiMapperImpl implements FurnitureUiMapper {
  @Override
  public Furniture toFurnitureDomain(final FurnitureDto furnitureDto) {
    return Furniture.of(
      furnitureDto.getArticle(),
      furnitureDto.getName(),
      furnitureDto.getManufacturer(),
      furnitureDto.getCategory(),
      furnitureDto.getModel(),
      furnitureDto.getDescription(),
      furnitureDto.getAmount()
    );
  }

  @Override
  public List<Furniture> toFurnitureDomainList(final List<FurnitureDto> furnitureDtoList) {
    return furnitureDtoList.stream()
      .map(this::toFurnitureDomain)
      .collect(Collectors.toList());
  }

  @Override
  public FurnitureDto toFurnitureDto(final Furniture furniture) {

    final FurnitureDto furnitureDto = new FurnitureDto();

    furnitureDto.setName(furniture.getName());
    furnitureDto.setArticle(furniture.getArticle());
    furnitureDto.setCategory(furniture.getCategory());
    furnitureDto.setManufacturer(furniture.getManufacturer());
    furnitureDto.setModel(furniture.getModel());
    furnitureDto.setDescription(furniture.getDescription());
    furnitureDto.setAmount((int)furniture.getAmount());

    return furnitureDto;
  }

  @Override
  public List<FurnitureDto> toFurnitureDtoList(final List<Furniture> furnitureList) {
    return furnitureList.stream()
      .map(this::toFurnitureDto)
      .collect(Collectors.toList());
  }
}
