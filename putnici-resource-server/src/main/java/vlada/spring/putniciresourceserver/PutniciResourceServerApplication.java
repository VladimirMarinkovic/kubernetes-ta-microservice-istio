package vlada.spring.putniciresourceserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import vlada.spring.putniciresourceserver.dto.PutnikDto;
import vlada.spring.putniciresourceserver.service.PutnikService;

@SpringBootApplication
@EnableResourceServer
public class PutniciResourceServerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PutniciResourceServerApplication.class, args);
    }

    @Autowired
    PutnikService putnikService;
    @Override
    public void run(String... args) throws Exception {
        putnikService.sacuvajPutnika(new PutnikDto("Zika","Zikic","FG4552","1"), "1");
        putnikService.sacuvajPutnika(new PutnikDto("Mika","Mikic","KJ4444","2"), "2");
    }
}
