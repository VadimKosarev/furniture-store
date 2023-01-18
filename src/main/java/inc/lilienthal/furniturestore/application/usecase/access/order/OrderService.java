package inc.lilienthal.furniturestore.application.usecase.access.order;

import inc.lilienthal.furniturestore.domain.Order;
import java.util.List;

public interface OrderService {

  void save(Order order);

  List<Order> findAll();

  Order findOrderByTrackingNumber(String trackingNumber);

  void deleteOrderByTrackingNumber(String trackingNumber);

}
