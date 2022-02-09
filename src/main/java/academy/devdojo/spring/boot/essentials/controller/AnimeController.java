package academy.devdojo.spring.boot.essentials.controller;

import academy.devdojo.spring.boot.essentials.domain.Anime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("anime")
public class AnimeController {
    //localhost:8080/anime/list
    @GetMapping(path = "list")
    public List<Anime> list() {
        return List.of(new Anime("Cavaleiros do Zoodiaco"), new Anime("Caverna do Dragão"));
    }
}
