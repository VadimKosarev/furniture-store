package inc.lilienthal.furniturestore.infrastucture.persistence.postgres.model.mapper.order;

import inc.lilienthal.furniturestore.domain.Furniture;
import inc.lilienthal.furniturestore.domain.Order;
import inc.lilienthal.furniturestore.infrastucture.persistence.postgres.model.FurnitureEntity;
import inc.lilienthal.furniturestore.infrastucture.persistence.postgres.model.OrderEntity;
import inc.lilienthal.furniturestore.infrastucture.persistence.postgres.model.mapper.FurnitureEntityMapper;
import inc.lilienthal.furniturestore.infrastucture.persistence.postgres.model.mapper.OrderEntityMapper;
import inc.lilienthal.furniturestore.infrastucture.persistence.postgres.repository.FurnitureRepositoryJpa;
import lombok.RequiredArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class OrderEntityMapperImpl implements OrderEntityMapper {

  private final FurnitureEntityMapper furnitureEntityMapper;
  private final FurnitureRepositoryJpa furnitureRepositoryJpa;

  @Override
  public Order toOrderDomain(final OrderEntity orderEntity) {

    return Order.copyByParams(
      orderEntity.getTrackingNumber(),
      orderEntity.getDateOfCreation(),
      orderEntity.getClientName(),
      orderEntity.getClientEmail(),
      orderEntity.getTotalAmount(),
      furnitureEntityMapper.toFurnitureDomainList(orderEntity.getFurnitureEntityList())
    );
  }

  @Override
  public OrderEntity toOrderEntity(final Order order) {

    OrderEntity orderEntity = new OrderEntity();
    orderEntity.setTrackingNumber(order.getTrackingNumber());
    orderEntity.setDateOfCreation(order.getDateOfCreation());
    orderEntity.setClientName(order.getClientName());
    orderEntity.setClientEmail(order.getClientEmail());
    orderEntity.setTotalAmount(order.getTotalAmount());
    orderEntity.setFurnitureEntityList(getFurnitureList(order.getFurnitures()));
    return orderEntity;
  }

  private List<FurnitureEntity> getFurnitureList(List<Furniture> furnitureList) {

    List<FurnitureEntity> furnitureEntityList = new ArrayList<>();
    for (Furniture furniture : furnitureList) {
      FurnitureEntity furnitureEntity = furnitureRepositoryJpa.findByArticle(furniture.getArticle());
      furnitureEntityList.add(furnitureEntity);
    }
    return furnitureEntityList;
  }

  @Override
  public List<Order> toOrderDomainList(final List<OrderEntity> orderEntities) {

    return orderEntities.stream()
      .map(this::toOrderDomain)
      .collect(Collectors.toList());
  }

  @Override
  public List<OrderEntity> toOrderEntityList(final List<Order> orderList) {

    return orderList.stream()
      .map(this::toOrderEntity)
      .collect(Collectors.toList());
  }
}
