package vlada.spring.vozaciresourceserver.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import vlada.spring.vozaciresourceserver.dto.VozacDto;
import vlada.spring.vozaciresourceserver.model.Vozac;

@Mapper(componentModel = "spring")
public interface VozaciMapper {

    @Mapping(source = "ime", target = "ime")
    VozacDto vozacUVozacDto(Vozac vozac);

    @Mapping(source = "ime", target = "ime")
    Vozac vozacDtoUVozac(VozacDto vozacDto);


}
