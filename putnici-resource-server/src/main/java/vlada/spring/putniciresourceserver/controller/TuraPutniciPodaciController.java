package vlada.spring.putniciresourceserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vlada.spring.putniciresourceserver.dto.PutnikDto;
import vlada.spring.putniciresourceserver.model.TuraPutniciLista;
import vlada.spring.putniciresourceserver.service.PutnikService;


@RestController
@RequestMapping("/putnicipodaci")
public class TuraPutniciPodaciController {


    @Autowired
    PutnikService putnikService;


    @GetMapping("/tura/{turaId}")
    public TuraPutniciLista prikaziPutnikeTure(@PathVariable("turaId") String turaId) {
        TuraPutniciLista turaPutniciLista = new TuraPutniciLista();
        turaPutniciLista.setListaPutnika(putnikService.prikaziSvePutnikeTure(turaId));
        return turaPutniciLista;
    }


    @PostMapping("/putnik/{turaId}")
    public ResponseEntity sacuvajPutnikaTure(@RequestBody PutnikDto putnikDto, @PathVariable("turaId") String turaId) {
        putnikService.sacuvajPutnika(putnikDto, turaId);
        return new ResponseEntity(HttpStatus.OK);
    }





}
