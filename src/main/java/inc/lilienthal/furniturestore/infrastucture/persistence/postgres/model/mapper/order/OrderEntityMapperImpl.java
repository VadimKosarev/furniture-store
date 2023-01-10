package inc.lilienthal.furniturestore.infrastucture.persistence.postgres.model.mapper.order;

import inc.lilienthal.furniturestore.domain.Order;
import inc.lilienthal.furniturestore.infrastucture.persistence.postgres.model.OrderEntity;
import inc.lilienthal.furniturestore.infrastucture.persistence.postgres.model.mapper.FurnitureEntityMapper;
import inc.lilienthal.furniturestore.infrastucture.persistence.postgres.model.mapper.OrderEntityMapper;
import java.util.List;
import java.util.stream.Collectors;

public class OrderEntityMapperImpl implements OrderEntityMapper {

  FurnitureEntityMapper furnitureEntityMapper;

  @Override
  public Order toOrderDomain(final OrderEntity orderEntity) {
    return Order.of(
      orderEntity.getId(),
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
    orderEntity.setId(order.getId());
    orderEntity.setTrackingNumber(order.getTrackingNumber());
    orderEntity.setDateOfCreation(order.getDateOfCreation());
    orderEntity.setClientName(order.getClientName());
    orderEntity.setTotalAmount(order.getTotalAmount());

    return orderEntity;
  }

  @Override
  public List<Order> toOrderDomainList(final List<OrderEntity> orderEntities) {
    return orderEntities.stream()
      .map(this::toOrderDomain)
      .collect(Collectors.toList());
  }

  @Override public List<OrderEntity> toOrderEntityList(final List<Order> orderList) {
    return orderList.stream()
      .map(this::toOrderEntity)
      .collect(Collectors.toList());
  }
}