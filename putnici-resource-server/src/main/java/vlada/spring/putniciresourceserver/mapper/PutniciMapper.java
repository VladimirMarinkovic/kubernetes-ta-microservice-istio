package vlada.spring.putniciresourceserver.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import vlada.spring.putniciresourceserver.dto.PutnikDto;
import vlada.spring.putniciresourceserver.model.Putnik;

@Mapper(componentModel = "spring")
public interface PutniciMapper {

    @Mapping(source = "brPasosa", target = "brPasosa")
    PutnikDto putnikUPutnikDto (Putnik putnik);

    @Mapping(source = "brPasosa", target = "brPasosa")
    Putnik putnikDtoUPutnik(PutnikDto putnikDto);


}
