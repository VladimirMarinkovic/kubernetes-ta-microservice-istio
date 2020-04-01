package vlada.spring.putniciresourceserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vlada.spring.putniciresourceserver.model.Putnik;

import java.util.List;

@Repository
public interface PutnikRepository extends JpaRepository<Putnik, Long> {

    List<Putnik> findAllByTuraId(String turaId);
}
