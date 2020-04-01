package vlada.spring.turaresourceserver.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TuraSadrzaj {


    private String id;

    String nazivTure;

    String vremePocetka;

    String vremeZavrsetka;

    String destinacija;

    private TuraPutniciLista turaPutniciLista;

    private VozaciTuraLista vozaciTuraLista;

}
