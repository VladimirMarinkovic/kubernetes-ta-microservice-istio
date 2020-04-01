package vlada.spring.turaresourceserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import vlada.spring.turaresourceserver.dto.TuraInfoDto;
import vlada.spring.turaresourceserver.model.Putnik;
import vlada.spring.turaresourceserver.model.TuraInfo;
import vlada.spring.turaresourceserver.model.TuraSadrzaj;
import vlada.spring.turaresourceserver.model.Vozac;
import vlada.spring.turaresourceserver.repository.TuraInfoRepository;

import java.util.List;

@Service
public class TuraSadrzajService {

    @Autowired
    TuraInfoService turaInfoService;
    @Autowired
    PutniciPodaciService putniciPodaciService;
    @Autowired
    VozaciTuraService vozaciTuraService;
    @Autowired
    TuraInfoRepository turaInfoRepository;



    public TuraSadrzaj prikaziSadrzajTure(String turaId) {
        TuraInfo turaInfo = turaInfoService.findTuraInfoById(turaId);
        TuraSadrzaj turaSadrzaj = mappTuraInfoUTuraSadrzaj(turaInfo);
        turaSadrzaj.setVozaciTuraLista(vozaciTuraService.prikaziVozaceTure(turaId));
        turaSadrzaj.setTuraPutniciLista(putniciPodaciService.prikaziPutnikeTure(turaId));
        return turaSadrzaj;
    }



    // Zahtev za kreiranje kompletne ture sa prosledjenim opstim informacijama,listama putnika i vozaca.
    public void sacuvajCelokupnuTuru(@RequestBody TuraSadrzaj turaSadrzaj) {
        TuraInfoDto turaInfoDto = turaInfoService.mapTuraSadrzajUTuraInfoDto(turaSadrzaj);
        TuraInfo turaInfo = turaInfoRepository.getOne(turaInfoService.sacuvajInfoTure(turaInfoDto).getId());
        List<Putnik> putnici = turaSadrzaj.getTuraPutniciLista().getListaPutnika();
        putnici.stream()
                .forEach(putnik -> putniciPodaciService.sacuvajPutnikaTure(putniciPodaciService.mapPutnikUPutnikDto(putnik),turaInfo.getId().toString()));
        List<Vozac> vozaci = turaSadrzaj.getVozaciTuraLista().getVozaciTureLista();
        vozaci.stream()
                .forEach(vozac -> vozaciTuraService.sacuvajVozacaZaTuru(vozaciTuraService.mapVozacUVozacDtoDto(vozac), turaInfo.getId().toString()));


    }



    public TuraSadrzaj mappTuraInfoUTuraSadrzaj(TuraInfo turaInfo) {
        return  TuraSadrzaj.builder()
                .id(turaInfo.getId().toString())
                .nazivTure(turaInfo.getNazivTure())
                .vremePocetka(turaInfo.getVremePocetka().toString())
                .vremeZavrsetka(turaInfo.getVremeZavrsetka().toString())
                .destinacija(turaInfo.getDestinacija())
                .build();
    }
}
