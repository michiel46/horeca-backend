package be.liantis.horeca.repositories;

import be.liantis.horeca.entities.Winkelgebied;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WinkelgebiedRepository extends PagingAndSortingRepository<Winkelgebied, Long> {
   Optional<Winkelgebied> findWinkelgebiedByNaamAndSubcentrum(String naam, String subcentrum);
}
