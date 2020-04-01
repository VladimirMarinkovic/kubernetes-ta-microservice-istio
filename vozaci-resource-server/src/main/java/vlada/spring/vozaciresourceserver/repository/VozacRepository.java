package vlada.spring.vozaciresourceserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vlada.spring.vozaciresourceserver.model.Vozac;

import java.util.List;

@Repository
public interface VozacRepository extends JpaRepository<Vozac, Long> {

    List<Vozac> findAllByTuraId(String turaId);

}
