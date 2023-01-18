package inc.lilienthal.furniturestore.infrastucture.web.controller;

import inc.lilienthal.furniturestore.application.usecase.scenario.order.OrderUseCase;
import inc.lilienthal.furniturestore.domain.Order;
import inc.lilienthal.furniturestore.infrastucture.web.mapper.order.OrderUiMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openapitools.api.OrderApi;
import org.openapitools.model.FullOrder;
import org.openapitools.model.OrderResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class OrderController implements OrderApi {

  private final OrderUseCase orderUseCase;
  private final OrderUiMapper orderUiMapper;

  @Override
  public ResponseEntity<Void> createOrder(final FullOrder fullOrder) {

    Order order = orderUiMapper.toOrderDomain(fullOrder);
    orderUseCase.save(order);
    return null;
  }

  @Override
  public ResponseEntity<List<OrderResponse>> getAllOrders() {

    List<OrderResponse> orderResponseList = orderUiMapper.toOrderResponseList(
      orderUseCase.findAll()
    );

    return ResponseEntity
      .status(HttpStatus.OK)
      .body(orderResponseList);
  }

  @Override
  public ResponseEntity<FullOrder> getOrderByTrackingNumber(final String trackingNumber) {

    final FullOrder fullOrder = orderUiMapper.toFullOrder(
      orderUseCase.findOrderByTrackingNumber(trackingNumber)
    );

    return ResponseEntity
      .status(HttpStatus.OK)
      .body(fullOrder);
  }

  @Override
  public ResponseEntity<Void> removeOrderByTrackingNumber(final String trackingNumber) {

    orderUseCase.deleteOrderByTrackingNumber(trackingNumber);

    return null;
  }
}
