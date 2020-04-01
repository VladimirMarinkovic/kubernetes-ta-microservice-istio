package vlada.spring.turaresourceserver.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TuraInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    String nazivTure;
    @Column
    LocalDateTime vremePocetka;
    @Column
    LocalDateTime vremeZavrsetka;
    @Column
    String destinacija;
}
