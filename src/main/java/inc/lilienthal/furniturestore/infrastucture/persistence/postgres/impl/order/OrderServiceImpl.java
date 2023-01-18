package inc.lilienthal.furniturestore.infrastucture.persistence.postgres.impl.order;

import inc.lilienthal.furniturestore.application.usecase.access.order.OrderService;
import inc.lilienthal.furniturestore.domain.Order;
import inc.lilienthal.furniturestore.infrastucture.persistence.postgres.model.mapper.FurnitureEntityMapper;
import inc.lilienthal.furniturestore.infrastucture.persistence.postgres.model.mapper.OrderEntityMapper;
import inc.lilienthal.furniturestore.infrastucture.persistence.postgres.repository.FurnitureRepositoryJpa;
import inc.lilienthal.furniturestore.infrastucture.persistence.postgres.repository.OrderRepositoryJpa;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {

  private final OrderEntityMapper orderEntityMapper;
  private final OrderRepositoryJpa orderRepositoryJpa;
  private final FurnitureRepositoryJpa furnitureRepositoryJpa;
  private final FurnitureEntityMapper furnitureEntityMapper;

  @Override
  public void save(final Order order) {
    orderRepositoryJpa.save(orderEntityMapper.toOrderEntity(order));
    furnitureRepositoryJpa.save(furnitureEntityMapper.toFurnitureEntityList(order.getFurnitures()));
  }

  @Override
  public List<Order> findAll() {
    return orderEntityMapper.toOrderDomainList(orderRepositoryJpa.findAll());
  }

  @Override
  public Order findOrderByTrackingNumber(final String trackingNumber) {
    return orderEntityMapper.toOrderDomain(
      orderRepositoryJpa.findByTrackingNumber(trackingNumber));
  }

  @Override
  public void deleteOrderByTrackingNumber(final String trackingNumber) {
    orderRepositoryJpa.deleteByTrackingNumber(trackingNumber);
  }
}
