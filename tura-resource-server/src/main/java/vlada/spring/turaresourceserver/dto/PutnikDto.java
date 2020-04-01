package vlada.spring.turaresourceserver.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PutnikDto {

    private String ime;
    private String prezime;
    private String brPasosa;
    private String turaId;



}
