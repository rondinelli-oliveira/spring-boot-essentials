package academy.devdojo.spring.boot.essentials.service;

import academy.devdojo.spring.boot.essentials.domain.Anime;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService {

    public List<Anime> listAll() {
        return List.of(new Anime(1L, "Cavaleiros do Zoodiaco"), new Anime(2L, "Caverna do Dragão"), new Anime(3L, "Corrida Maluca"));
    }
}
