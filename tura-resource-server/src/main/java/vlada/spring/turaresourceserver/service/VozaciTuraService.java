package vlada.spring.turaresourceserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;
import vlada.spring.turaresourceserver.dto.VozacDto;
import vlada.spring.turaresourceserver.model.Vozac;
import vlada.spring.turaresourceserver.model.VozaciTuraLista;


@Service
public class VozaciTuraService {


    @Autowired
    OAuth2RestTemplate oAuth2RestTemplate;


    @Value("${VOZACI_SERVER_URI:http://localhost:8083}")
    private String vozaciResourceServerUrl;


    public VozaciTuraLista prikaziVozaceTure(String turaId) {

        return oAuth2RestTemplate.getForObject(vozaciResourceServerUrl + "/vozac/tura/" + turaId, VozaciTuraLista.class);
    }


    public VozacDto sacuvajVozacaZaTuru(VozacDto vozacDto,String turaId) {
        return  oAuth2RestTemplate.postForObject(vozaciResourceServerUrl + "/vozac/tura/" + turaId, vozacDto, VozacDto.class);
    }



    public VozacDto mapVozacUVozacDtoDto(Vozac vozac) {
        return VozacDto.builder()
               .ime(vozac.getIme())
                .prezime(vozac.getPrezime())
                .brTelefona(vozac.getBrTelefona())
                .nazivFirme(vozac.getNazivFirme())
                .build();

    }

}


