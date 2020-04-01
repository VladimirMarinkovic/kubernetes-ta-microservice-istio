package vlada.spring.turaresourceserver.dto;

import lombok.*;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TuraInfoDto {



    String nazivTure;
    String vremePocetka;
    String vremeZavrsetka;
    String destinacija;
}
