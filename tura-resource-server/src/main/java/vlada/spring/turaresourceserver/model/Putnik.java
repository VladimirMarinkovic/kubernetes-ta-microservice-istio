package vlada.spring.turaresourceserver.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Putnik {

    String ime;
    String prezime;
    private String brPasosa;
    private String turaId;
}
