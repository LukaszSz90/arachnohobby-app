package LukaszSz90.arachnohobbyapp.domain.repository;

import LukaszSz90.arachnohobbyapp.domain.model.Arachnid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArachnidRepository extends JpaRepository<Arachnid, Long> {

    Arachnid getById(Long id);

    List<Arachnid> getAllByGenusId(Long genusId);

    List<Arachnid> getAllByLifeStyleId(Long lifeStyleId);

    List<Arachnid> getAllByLevelOfDifficultyId(Long levelOfDifficultyId);

    @Query(value = "SELECT species FROM Arachnid ar WHERE ar.species = species_name")
    boolean existBySpecies(@Param("species_name") String species);
}
