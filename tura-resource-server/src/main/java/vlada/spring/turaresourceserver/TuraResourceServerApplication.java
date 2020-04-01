package vlada.spring.turaresourceserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import vlada.spring.turaresourceserver.dto.TuraInfoDto;
import vlada.spring.turaresourceserver.service.TuraInfoService;


@SpringBootApplication
@EnableResourceServer
@EnableDiscoveryClient
public class TuraResourceServerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TuraResourceServerApplication.class, args);
    }


    @Autowired
    TuraInfoService turaInfoService;

    @Override
    public void run(String... args) throws Exception {
        turaInfoService.sacuvajInfoTure(new TuraInfoDto("Tura1","01-01-2020 18:45:00","15-01-2020 18:45:00","Srbija"));
        turaInfoService.sacuvajInfoTure(new TuraInfoDto("Tura2","01-03-2020 18:45:00","15-03-2020 18:45:00","Bosna"));
    }
}
