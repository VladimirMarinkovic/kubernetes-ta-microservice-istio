package vlada.spring.vozaciresourceserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vlada.spring.vozaciresourceserver.dto.VozacDto;
import vlada.spring.vozaciresourceserver.model.VozaciTuraLista;
import vlada.spring.vozaciresourceserver.service.VozacService;


@RestController
@RequestMapping("/vozac")
public class VozacTuraController {


    @Autowired
    VozacService vozacService;

    @GetMapping("/tura/{turaId}")
    public VozaciTuraLista prikaziVozaceTure(@PathVariable("turaId") String turaId) {
        VozaciTuraLista vozaciTuraLista = new VozaciTuraLista();
        vozaciTuraLista.setVozaciTureLista(vozacService.prikaziVozaceTure(turaId));
        return vozaciTuraLista;
    }


    @PostMapping("/tura/{turaId}")
    public  ResponseEntity sacuvajVozacaZaTuru(@RequestBody VozacDto vozacDto, @PathVariable("turaId") String turaId) {
        vozacService.sacuvajVozacaZaTuru(vozacDto, turaId);
        return new ResponseEntity(HttpStatus.OK);
    }




}
