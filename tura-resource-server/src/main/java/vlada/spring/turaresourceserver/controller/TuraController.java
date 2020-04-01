package vlada.spring.turaresourceserver.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vlada.spring.turaresourceserver.dto.PutnikDto;
import vlada.spring.turaresourceserver.dto.TuraInfoDto;
import vlada.spring.turaresourceserver.dto.VozacDto;
import vlada.spring.turaresourceserver.model.*;
import vlada.spring.turaresourceserver.service.PutniciPodaciService;
import vlada.spring.turaresourceserver.service.TuraInfoService;
import vlada.spring.turaresourceserver.service.TuraSadrzajService;
import vlada.spring.turaresourceserver.service.VozaciTuraService;




@RestController
@RequestMapping("/tura")
public class TuraController {

    @Autowired
    PutniciPodaciService putniciPodaciService;
    @Autowired
    VozaciTuraService vozaciTuraService;
    @Autowired
    TuraInfoService turaInfoService;
    @Autowired
    TuraSadrzajService turaSadrzajService;


    @GetMapping("/proba")
    public String proba() {
        return "PROBA KUBERNETES!";
    }

    @GetMapping("/sadrzaj/{turaId}")
    public ResponseEntity<TuraSadrzaj> prikaziSadrzajTure(@PathVariable("turaId") String turaId) {
        return new ResponseEntity<>(turaSadrzajService.prikaziSadrzajTure(turaId), HttpStatus.OK);
    }


    @PostMapping("/kreirajinfo")
    ResponseEntity<TuraInfoDto> kreirajInfoTure(@RequestBody TuraInfoDto turaInfoDto) {
        turaInfoService.sacuvajInfoTure(turaInfoDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/putnik/{turaId}")
    public ResponseEntity sacuvajPutnika(@RequestBody PutnikDto putnikDto, @PathVariable("turaId") String turaId) {
        putniciPodaciService.sacuvajPutnikaTure(putnikDto, turaId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/vozac/{turaId}")
    public ResponseEntity<VozacDto> sacuvajVozaca(@RequestBody VozacDto vozacDto, @PathVariable("turaId") String turaId) {
        vozaciTuraService.sacuvajVozacaZaTuru(vozacDto, turaId);
        return new ResponseEntity(HttpStatus.OK);
    }



    @PostMapping("/kreirajsadrzaj")
    public ResponseEntity<TuraSadrzaj> sacuvajCelokupnuTuru(@RequestBody TuraSadrzaj turaSadrzaj) {
        turaSadrzajService.sacuvajCelokupnuTuru(turaSadrzaj);
       return new ResponseEntity<>(HttpStatus.OK);

    }












}






