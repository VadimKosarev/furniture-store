package inc.lilienthal.furniturestore.infrastucture.persistence.postgres.model.mapper;

import inc.lilienthal.furniturestore.domain.Order;
import inc.lilienthal.furniturestore.infrastucture.persistence.postgres.model.OrderEntity;
import java.util.List;

public interface OrderEntityMapper {

  Order toOrderDomain(OrderEntity orderEntity);

  OrderEntity toOrderEntity(Order order);

  List<Order> toOrderDomainList(List<OrderEntity> orderEntities);

  List<OrderEntity> toOrderEntityList(List<Order> orderList);
}
