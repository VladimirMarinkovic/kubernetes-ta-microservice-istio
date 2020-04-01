package vlada.spring.turaresourceserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;
import vlada.spring.turaresourceserver.dto.PutnikDto;
import vlada.spring.turaresourceserver.model.Putnik;
import vlada.spring.turaresourceserver.model.TuraPutniciLista;



@Service
public class PutniciPodaciService {


    @Autowired
    OAuth2RestTemplate oAuth2RestTemplate;



    @Value("${PUTNICI_SERVER_URI:http://localhost:8082}")
    private String putniciResourceServerUrl;


    public TuraPutniciLista prikaziPutnikeTure(String turaId) {
        return oAuth2RestTemplate.getForObject(putniciResourceServerUrl + "/putnicipodaci/tura/" + turaId, TuraPutniciLista.class);
    }


    public PutnikDto sacuvajPutnikaTure(PutnikDto putnikDto,String turaId) {
        return  oAuth2RestTemplate.postForObject(putniciResourceServerUrl + "/putnicipodaci/putnik/" + turaId, putnikDto, PutnikDto.class);
    }



    public PutnikDto mapPutnikUPutnikDto(Putnik putnik) {
        return PutnikDto.builder()
                .ime(putnik.getIme())
                .prezime(putnik.getPrezime())
                .brPasosa(putnik.getBrPasosa())
                .turaId(putnik.getTuraId())
                .build();
    }




}
