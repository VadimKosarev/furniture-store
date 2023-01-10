package inc.lilienthal.furniturestore.config.usecase;

import inc.lilienthal.furniturestore.application.usecase.access.furniture.FurnitureService;
import inc.lilienthal.furniturestore.application.usecase.scenario.furniture.FurnitureUseCase;
import inc.lilienthal.furniturestore.infrastucture.persistence.postgres.impl.FurnitureServiceImpl;
import inc.lilienthal.furniturestore.infrastucture.persistence.postgres.model.mapper.FurnitureEntityMapper;
import inc.lilienthal.furniturestore.infrastucture.persistence.postgres.model.mapper.furniture.FurnitureEntityMapperImpl;
import inc.lilienthal.furniturestore.infrastucture.persistence.postgres.repository.FurnitureRepositoryJpa;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FurnitureUseCaseConfiguration {

  @Bean
  public FurnitureEntityMapper furnitureEntityMapper() {
    return new FurnitureEntityMapperImpl();
  }

  @Bean
  public FurnitureService furnitureService(FurnitureEntityMapper furnitureEntityMapper,
                                           @Qualifier("furnitureRepositoryJpa") FurnitureRepositoryJpa furnitureRepositoryJpa) {
    return new FurnitureServiceImpl(furnitureEntityMapper, furnitureRepositoryJpa);
  }

  @Bean
  public FurnitureUseCase furnitureUseCase(FurnitureService furnitureService) {
    return new FurnitureUseCase(furnitureService);
  }
}
