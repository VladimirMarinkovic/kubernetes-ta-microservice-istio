package vlada.spring.turaresourceserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vlada.spring.turaresourceserver.model.TuraInfo;
import vlada.spring.turaresourceserver.model.TuraSadrzaj;
import vlada.spring.turaresourceserver.repository.TuraInfoRepository;
import vlada.spring.turaresourceserver.dto.TuraInfoDto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Service
public class TuraInfoService {

    @Autowired
    TuraInfoRepository turaInfoRepository;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");




    public TuraInfo sacuvajInfoTure(TuraInfoDto turaInfoDto) {
        return  turaInfoRepository.save(
                TuraInfo.builder()
                        .nazivTure(turaInfoDto.getNazivTure())
                        .destinacija(turaInfoDto.getDestinacija())
                        .vremePocetka(LocalDateTime.parse(turaInfoDto.getVremePocetka(), formatter))
                        .vremeZavrsetka(LocalDateTime.parse(turaInfoDto.getVremeZavrsetka(), formatter))
                        .build());
    }


    public TuraInfo findTuraInfoById(String turaInfoId) {
        return turaInfoRepository.findById(Long.parseLong(turaInfoId)).orElse(null);
    }





    public TuraInfoDto mapTuraSadrzajUTuraInfoDto(TuraSadrzaj turaSadrzaj) {
        return TuraInfoDto.builder()
                .nazivTure(turaSadrzaj.getNazivTure())
                .vremePocetka(turaSadrzaj.getVremePocetka())
                .vremeZavrsetka(turaSadrzaj.getVremeZavrsetka())
                .destinacija(turaSadrzaj.getDestinacija())
                .build();
    }
}



