package inc.lilienthal.furniturestore.application.usecase.scenario.order;


import inc.lilienthal.furniturestore.application.usecase.access.order.OrderService;
import inc.lilienthal.furniturestore.domain.Order;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RequiredArgsConstructor
public class OrderUseCase {

  private final OrderService orderService;

  public void save(Order order) {
    orderService.save(order);
  }

  public List<Order> findAll() {
    return orderService.findAll();
  }

  public Order findOrderByTrackingNumber(String trackingNumber) {
    return orderService.findOrderByTrackingNumber(trackingNumber);
  }

  public void deleteOrderByTrackingNumber(String trackingNumber) {
    orderService.deleteOrderByTrackingNumber(trackingNumber);
  }
}
