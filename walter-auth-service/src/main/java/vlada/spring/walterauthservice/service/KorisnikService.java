package vlada.spring.walterauthservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vlada.spring.walterauthservice.dto.KorisnikDto;
import vlada.spring.walterauthservice.dto.RegistracijaZahtev;
import vlada.spring.walterauthservice.exception.KorisnikNijePronadjenException;
import vlada.spring.walterauthservice.mapper.KorisnikMapper;
import vlada.spring.walterauthservice.model.Korisnik;
import vlada.spring.walterauthservice.repository.KorisnikRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;
    @Autowired
    KorisnikMapper korisnikMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;
    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }



    public List<KorisnikDto> nadjiSveKorisnike() {
        List<Korisnik> korisnici = korisnikRepository.findAll();
        return korisnici.stream().map(korisnikMapper::korisnikUKorisnikDto).collect(Collectors.toList());
    }

    public void  sacuvajKorisnika(RegistracijaZahtev registracijaZahtev) {
        Korisnik korisnik = new Korisnik();
        korisnik.setKorisnickoIme(registracijaZahtev.getKorisnickoIme());
        korisnik.setEmail(registracijaZahtev.getEmail());
        korisnik.setLozinka(encodePassword(registracijaZahtev.getLozinka()));
        korisnikRepository.save(korisnik);
    }


    public KorisnikDto izmeniKorisnika(Long id, KorisnikDto korisnikDto ) {
        Korisnik korisnik = korisnikRepository.findById(korisnikDto.getId()).orElseThrow(()-> new KorisnikNijePronadjenException("Nije pronadjen korisnik za id: " + id));
        korisnik.setKorisnickoIme(korisnikDto.getKorisnickoIme());
        korisnik.setEmail(korisnikDto.getEmail());
        korisnikRepository.save(korisnik);
        return KorisnikDto.builder()
                .id(korisnik.getId())
                .korisnickoIme(korisnik.getKorisnickoIme())
                .email(korisnik.getEmail())
                .build();
    }

    public void obrisiKorisnikaZaId(Long id) {
        Korisnik korisnik = korisnikRepository.findById(id).orElseThrow(() -> new KorisnikNijePronadjenException("Nije pronadjen korisnik za id: " + id));
        korisnikRepository.delete(korisnik);
    }

}
