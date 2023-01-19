package inc.lilienthal.furniturestore.infrastucture.persistence.postgres.repository;

import inc.lilienthal.furniturestore.infrastucture.persistence.postgres.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface OrderRepositoryJpa extends JpaRepository<OrderEntity, Long> {

  Optional<OrderEntity> findByTrackingNumber(String trackingNumber);

  void deleteByTrackingNumber(String trackingNumber);

}
