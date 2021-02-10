package be.liantis.horeca.repositories;

import be.liantis.horeca.entities.Sector;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SectorRepository extends PagingAndSortingRepository<Sector, Long> {
   Optional<Sector> findSectorByCodeAndAndNaam(String code, String naam);
}
