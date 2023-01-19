package inc.lilienthal.furniturestore.infrastucture.web.mapper.order;

import inc.lilienthal.furniturestore.domain.Order;
import org.openapitools.model.FullOrder;
import org.openapitools.model.OrderResponse;
import org.openapitools.model.SaveOrderRequest;
import java.util.List;

public interface OrderUiMapper {

  OrderResponse toOrderResponse(Order order);

  List<OrderResponse> toOrderResponseList(List<Order> orderList);

  FullOrder toFullOrder(Order order);

  List<FullOrder> toFullOrderList(List<Order> orderList);

  Order toOrderDomain(FullOrder fullOrder);

  List<Order> toOrderDomainList(List<FullOrder> fullOrderList);

  Order toOrderDomain(SaveOrderRequest saveOrderRequest);
}
