package be.liantis.horeca.repositories;

import be.liantis.horeca.entities.Restaurant;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends PagingAndSortingRepository<Restaurant, Long> {
}
