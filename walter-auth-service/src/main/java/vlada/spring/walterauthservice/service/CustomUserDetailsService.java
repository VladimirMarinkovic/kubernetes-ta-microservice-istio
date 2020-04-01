package vlada.spring.walterauthservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vlada.spring.walterauthservice.model.Korisnik;
import vlada.spring.walterauthservice.repository.KorisnikRepository;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service(value = "customKorisnikService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private KorisnikRepository korisnikRepository;

    public UserDetails loadUserByUsername(String korisnikId) throws UsernameNotFoundException {
        Korisnik korisnik = korisnikRepository.findByKorisnickoIme(korisnikId);
        if(korisnik == null){
            throw new UsernameNotFoundException("Pogresno korisnicko ime ili lozinka");
        }
        return new org.springframework.security.core.userdetails.User(korisnik.getKorisnickoIme(), korisnik.getLozinka(), getAuthority());
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

}
