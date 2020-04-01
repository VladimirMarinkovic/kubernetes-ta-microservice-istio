package vlada.spring.walterauthservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vlada.spring.walterauthservice.dto.KorisnikDto;
import vlada.spring.walterauthservice.dto.RegistracijaZahtev;
import vlada.spring.walterauthservice.service.KorisnikService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/korisnici")
public class KorisnikController {

    @Autowired
    KorisnikService korisnikService;

    @GetMapping("/ulogovan")
    public Principal getUser(Principal principal) {
        return principal;
    }


    @GetMapping("/svi-korisnici")
    public ResponseEntity<List<KorisnikDto>> prikaziSveKorisnike() {
        return new ResponseEntity<>(korisnikService.nadjiSveKorisnike(), HttpStatus.OK);
    }


    @PostMapping("/registruj-korisnika")
    public ResponseEntity registracija(@RequestBody RegistracijaZahtev registracijaZahtev) {
        korisnikService.sacuvajKorisnika(registracijaZahtev);
        return new ResponseEntity(HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<KorisnikDto> izmeniKorisnika(@PathVariable Long id,  @RequestBody KorisnikDto korisnikDto) {
        return new ResponseEntity<>(korisnikService.izmeniKorisnika(id, korisnikDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void obrisiKorisnika(@PathVariable Long id) {
        korisnikService.obrisiKorisnikaZaId(id);
    }




}
