package vlada.spring.turaresourceserver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vlada.spring.turaresourceserver.dto.VozacDto;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VozaciTuraLista {

    private List<Vozac> vozaciTureLista;

}
