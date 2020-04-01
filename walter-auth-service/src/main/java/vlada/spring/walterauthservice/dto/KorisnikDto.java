package vlada.spring.walterauthservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KorisnikDto {

    private Long id;
    private String korisnickoIme;
    private String email;

}
