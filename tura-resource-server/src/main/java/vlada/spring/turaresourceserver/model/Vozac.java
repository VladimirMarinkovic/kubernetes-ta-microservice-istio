package vlada.spring.turaresourceserver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vozac {


    String ime;
    String prezime;
    String brTelefona;
    String turaId;
    String nazivFirme;
}
