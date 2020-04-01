package vlada.spring.walterauthservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vlada.spring.walterauthservice.model.Korisnik;

import java.util.Optional;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

    Korisnik findByKorisnickoIme(String korisnickoIme);
}
