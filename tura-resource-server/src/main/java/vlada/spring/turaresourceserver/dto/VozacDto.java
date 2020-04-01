package vlada.spring.turaresourceserver.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VozacDto {

    String ime;
    String prezime;
    String brTelefona;
    String turaId;
    String nazivFirme;
}
