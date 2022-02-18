package academy.devdojo.spring.boot.essentials.client;

import academy.devdojo.spring.boot.essentials.domain.Anime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class SpringClient1 {

    private static final Logger log = LoggerFactory.getLogger(SpringClient1.class);

    public static void main(String[] args) {
        ResponseEntity<Anime> entity = new RestTemplate().getForEntity("http://localhost:8080/animes/{id}", Anime.class,2);
        log.info(String.valueOf(entity));

        Anime object = new RestTemplate().getForObject("http://localhost:8080/animes/{id}", Anime.class,2);

        log.info(String.valueOf(object));
    }
}

//package academy.devdojo.springboot2.client;
//
//        import academy.devdojo.springboot2.domain.Anime;
//        import lombok.extern.log4j.Log4j2;
//        import org.springframework.http.ResponseEntity;
//        import org.springframework.web.client.RestTemplate;
//
//@Log4j2
//public class SpringClient {
//    public static void main(String[] args) {
//        ResponseEntity<Anime> entity = new RestTemplate().getForEntity("http://localhost:8080/animes/{id}", Anime.class,2);
//        log.info(entity);
//
//        Anime object = new RestTemplate().getForObject("http://localhost:8080/animes/{id}", Anime.class,2);
//
//        log.info(object);
//    }
//}
