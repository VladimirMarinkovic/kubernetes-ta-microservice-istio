package vlada.spring.vozaciresourceserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import vlada.spring.vozaciresourceserver.dto.VozacDto;
import vlada.spring.vozaciresourceserver.service.VozacService;

@SpringBootApplication
@EnableResourceServer
public class VozaciResourceServerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(VozaciResourceServerApplication.class, args);
    }

    @Autowired
    VozacService vozacService;

    @Override
    public void run(String... args) throws Exception {
        vozacService.sacuvajVozacaZaTuru(new VozacDto("VozacIme1","VozacPrezime1","065454658","1", "Trans1"),"1");
        vozacService.sacuvajVozacaZaTuru(new VozacDto("VozacIme2","VozacPrezime2","069878965","2", "Trans2"),"2");
    }
}
