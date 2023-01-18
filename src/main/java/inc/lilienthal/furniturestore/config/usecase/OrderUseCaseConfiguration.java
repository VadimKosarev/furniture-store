package inc.lilienthal.furniturestore.config.usecase;

import inc.lilienthal.furniturestore.application.usecase.access.order.OrderService;
import inc.lilienthal.furniturestore.application.usecase.scenario.order.OrderUseCase;
import inc.lilienthal.furniturestore.infrastucture.persistence.postgres.impl.order.OrderServiceImpl;
import inc.lilienthal.furniturestore.infrastucture.persistence.postgres.model.mapper.OrderEntityMapper;
import inc.lilienthal.furniturestore.infrastucture.persistence.postgres.model.mapper.order.OrderEntityMapperImpl;
import inc.lilienthal.furniturestore.infrastucture.persistence.postgres.repository.OrderRepositoryJpa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderUseCaseConfiguration {

  @Bean
  public OrderEntityMapper orderEntityMapper() {
    return new OrderEntityMapperImpl();
  }

  @Bean
  public OrderService orderService(OrderEntityMapper orderEntityMapper,
                                   OrderRepositoryJpa orderRepositoryJpa) {
    return new OrderServiceImpl(orderEntityMapper, orderRepositoryJpa);
  }

  @Bean
  public OrderUseCase orderUseCase(OrderService orderService) {
    return new OrderUseCase(orderService);
  }
}
