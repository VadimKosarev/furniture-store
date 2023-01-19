package inc.lilienthal.furniturestore.infrastucture.web.controller;

import inc.lilienthal.furniturestore.application.usecase.access.order.OrderService;
import inc.lilienthal.furniturestore.infrastucture.web.mapper.order.OrderUiMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.api.OrderApi;
import org.openapitools.model.FullOrder;
import org.openapitools.model.OrderResponse;
import org.openapitools.model.SaveOrderRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class OrderController implements OrderApi {

  private final OrderService orderService;

  private final OrderUiMapper orderUiMapper;

  @Override
  public ResponseEntity<Void> createOrder(final SaveOrderRequest saveOrderRequest) {
    orderService.save(orderUiMapper.toOrderDomain(saveOrderRequest));
    return null;
  }

  @Override
  public ResponseEntity<List<OrderResponse>> getAllOrders() {
    return ResponseEntity.ok(orderUiMapper.toOrderResponseList(orderService.findAll()));
  }

  @Override
  public ResponseEntity<FullOrder> getOrderByTrackingNumber(final String trackingNumber) {
    return ResponseEntity.ok(orderUiMapper.toFullOrder(orderService.findOrderByTrackingNumber(trackingNumber)));
  }

  @Override
  public ResponseEntity<Void> removeOrderByTrackingNumber(final String trackingNumber) {
    orderService.deleteOrderByTrackingNumber(trackingNumber);
    return null;
  }
}
