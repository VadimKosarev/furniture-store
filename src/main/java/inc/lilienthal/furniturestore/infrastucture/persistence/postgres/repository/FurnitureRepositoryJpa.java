package inc.lilienthal.furniturestore.infrastucture.persistence.postgres.repository;

import inc.lilienthal.furniturestore.infrastucture.persistence.postgres.model.FurnitureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FurnitureRepositoryJpa extends JpaRepository<FurnitureEntity, Long> {

  FurnitureEntity findByArticle(final String article);

  List<FurnitureEntity> findAllByModel(final String model);

  List<FurnitureEntity> findAllByCategory(final String category);

  void deleteByArticle(final String article);
}
