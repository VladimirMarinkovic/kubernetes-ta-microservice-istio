package vlada.spring.walterauthservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import vlada.spring.walterauthservice.dto.KorisnikDto;
import vlada.spring.walterauthservice.model.Korisnik;


@Mapper(componentModel = "spring")
public interface KorisnikMapper {


    @Mapping(source = "id", target = "id")
    KorisnikDto korisnikUKorisnikDto(Korisnik korisnik);

    @Mapping(source = "id", target = "id")
    Korisnik korisnikDtoUKorisnik(KorisnikDto korisnikDto);

}
