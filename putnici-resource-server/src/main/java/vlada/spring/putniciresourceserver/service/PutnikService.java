package vlada.spring.putniciresourceserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vlada.spring.putniciresourceserver.dto.PutnikDto;
import vlada.spring.putniciresourceserver.mapper.PutniciMapper;
import vlada.spring.putniciresourceserver.model.Putnik;
import vlada.spring.putniciresourceserver.repository.PutnikRepository;

import java.util.List;

@Service
public class PutnikService {

    @Autowired
    PutnikRepository putnikRepository;

    @Autowired
    PutniciMapper putniciMapper;


    public List<Putnik> prikaziSvePutnikeTure(String turaId) {
        return  putnikRepository.findAllByTuraId(turaId);
    }


    public void sacuvajPutnika(PutnikDto putnikDto, String turaId) {
        Putnik putnik = putniciMapper.putnikDtoUPutnik(putnikDto);
        putnik.setTuraId(turaId);
        putnikRepository.save(putnik);
    }

}
