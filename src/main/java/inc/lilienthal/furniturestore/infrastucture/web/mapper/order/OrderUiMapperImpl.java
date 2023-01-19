package inc.lilienthal.furniturestore.infrastucture.web.mapper.order;

import inc.lilienthal.furniturestore.domain.Furniture;
import inc.lilienthal.furniturestore.domain.Order;
import inc.lilienthal.furniturestore.infrastucture.persistence.postgres.model.FurnitureEntity;
import inc.lilienthal.furniturestore.infrastucture.persistence.postgres.model.mapper.FurnitureEntityMapper;
import inc.lilienthal.furniturestore.infrastucture.persistence.postgres.repository.FurnitureRepositoryJpa;
import inc.lilienthal.furniturestore.infrastucture.web.mapper.furniture.FurnitureUiMapper;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.FullOrder;
import org.openapitools.model.OrderResponse;
import org.openapitools.model.SaveOrderRequest;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderUiMapperImpl implements OrderUiMapper {


  private final FurnitureUiMapper furnitureUiMapper;

  private final FurnitureEntityMapper furnitureEntityMapper;
  private final FurnitureRepositoryJpa furnitureRepositoryJpa;

  @Override
  public OrderResponse toOrderResponse(final Order order) {

    OrderResponse orderResponse = new OrderResponse();

    orderResponse.setNameClient(order.getClientName());
    orderResponse.setEmailClient(order.getClientEmail());
    orderResponse.setDateOfCreation(order.getDateOfCreation());
    orderResponse.setTrackingNumber(order.getTrackingNumber());
    orderResponse.setTotalAmount((int)order.getTotalAmount());

    return orderResponse;
  }

  @Override
  public List<OrderResponse> toOrderResponseList(final List<Order> orderList) {
    return orderList.stream()
      .map(this::toOrderResponse)
      .collect(Collectors.toList());
  }

  @Override
  public FullOrder toFullOrder(final Order order) {

    final FullOrder fullOrder = new FullOrder();
    fullOrder.setNameClient(order.getClientName());
    fullOrder.setEmailClient(order.getClientEmail());
    fullOrder.setFurnitureList(furnitureUiMapper.toFurnitureDtoList(order.getFurnitures()));

    return fullOrder;
  }

  @Override
  public List<FullOrder> toFullOrderList(final List<Order> orderList) {
    return orderList.stream()
      .map(this::toFullOrder)
      .collect(Collectors.toList());
  }

  @Override
  public Order toOrderDomain(final FullOrder fullOrder) {
    return Order.of(
      fullOrder.getNameClient(),
      fullOrder.getEmailClient(),
      furnitureUiMapper.toFurnitureDomainList(fullOrder.getFurnitureList())
    );
  }

  @Override
  public List<Order> toOrderDomainList(final List<FullOrder> fullOrderList) {
    return fullOrderList.stream()
      .map(this::toOrderDomain)
      .collect(Collectors.toList());
  }

  @Override
  public Order toOrderDomain(final SaveOrderRequest saveOrderRequest) {
    final List<FurnitureEntity> furnitureEntityList = new ArrayList<>();

    for (String furnitureArticle : saveOrderRequest.getFurnitureList()) {
      FurnitureEntity item = furnitureRepositoryJpa.findByArticle(furnitureArticle);
      furnitureEntityList.add(item);
    }

    List<Furniture> furnitureList = furnitureEntityMapper
      .toFurnitureDomainList(furnitureEntityList);

    return Order.of(
      saveOrderRequest.getNameClient(),
      saveOrderRequest.getEmailClient(),
      furnitureList
    );
  }


}
