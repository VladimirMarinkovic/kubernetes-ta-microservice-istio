package vlada.spring.vozaciresourceserver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vozac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    String ime;
    @Column
    String prezime;
    @Column
    String brTelefona;

    @Column
    String turaId;

    @Column
    String nazivFirme;
}
