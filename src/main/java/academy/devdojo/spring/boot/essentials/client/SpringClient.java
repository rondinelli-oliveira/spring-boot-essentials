package academy.devdojo.spring.boot.essentials.client;

import academy.devdojo.spring.boot.essentials.domain.Anime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class SpringClient {

    private static final Logger log = LoggerFactory.getLogger(SpringClient.class);

    public static void main(String[] args) {
        ResponseEntity<Anime> entity = new RestTemplate().getForEntity("http://localhost:8080/animes/{id}", Anime.class,2);
        log.info(String.valueOf(entity));

        Anime objectGet = new RestTemplate().getForObject("http://localhost:8080/animes/{id}", Anime.class,2);

        log.info(String.valueOf(objectGet));

        Anime[] animes = new RestTemplate().getForObject("http://localhost:8080/animes/all", Anime[].class);

        log.info(Arrays.toString(animes));

        ResponseEntity<List<Anime>> animesList = new RestTemplate().exchange("http://localhost:8080/animes/all", HttpMethod.GET, null,
                new ParameterizedTypeReference<>() {});

        log.info(String.valueOf(animesList.getBody()));

//        Anime objectPost = Anime.builder().name("Snoopy").build();
//        Anime objectPostSaved = new RestTemplate().postForObject("http://localhost:8080/animes", objectPost, Anime.class);
//        log.info("Saved anime {}", objectPostSaved);

        Anime objectPost = Anime.builder().name("Bragon Ball Z").build();
        ResponseEntity<Anime> objectPostSaved = new RestTemplate().exchange("http://localhost:8080/animes", HttpMethod.POST,
                new HttpEntity<>(objectPost, createJsonHeader()), Anime.class);
        log.info("Saved anime {}", objectPostSaved);
    }

    private static HttpHeaders createJsonHeader() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }
}