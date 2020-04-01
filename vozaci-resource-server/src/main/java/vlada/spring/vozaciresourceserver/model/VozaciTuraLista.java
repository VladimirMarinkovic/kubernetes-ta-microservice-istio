package vlada.spring.vozaciresourceserver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vlada.spring.vozaciresourceserver.dto.VozacDto;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VozaciTuraLista {

    private List<Vozac> vozaciTureLista;


}
