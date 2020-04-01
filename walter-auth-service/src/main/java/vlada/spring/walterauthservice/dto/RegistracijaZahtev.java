package vlada.spring.walterauthservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistracijaZahtev {

    private String korisnickoIme;
    private String lozinka;
    private String email;

}
