package vlada.spring.vozaciresourceserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vlada.spring.vozaciresourceserver.dto.VozacDto;
import vlada.spring.vozaciresourceserver.mapper.VozaciMapper;
import vlada.spring.vozaciresourceserver.model.Vozac;
import vlada.spring.vozaciresourceserver.repository.VozacRepository;

import java.util.List;


@Service
public class VozacService {

    @Autowired
    VozacRepository vozacRepository;
    @Autowired
    VozaciMapper vozaciMapper;




    public List<Vozac> prikaziVozaceTure(String turaId) {
        return vozacRepository.findAllByTuraId(turaId);
    }

    public ResponseEntity<VozacDto> sacuvajVozacaZaTuru(VozacDto vozacDto, String turaId) {
        vozacDto.setTuraId(turaId);
        vozacRepository.save(vozaciMapper.vozacDtoUVozac(vozacDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
