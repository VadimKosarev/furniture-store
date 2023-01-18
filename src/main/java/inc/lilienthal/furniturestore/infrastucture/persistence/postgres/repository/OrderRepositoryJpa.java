package inc.lilienthal.furniturestore.infrastucture.persistence.postgres.repository;

import inc.lilienthal.furniturestore.infrastucture.persistence.postgres.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepositoryJpa extends JpaRepository<OrderEntity, Long> {

  OrderEntity findByTrackingNumber(String trackingNumber);

  void deleteByTrackingNumber(String trackingNumber);

}
