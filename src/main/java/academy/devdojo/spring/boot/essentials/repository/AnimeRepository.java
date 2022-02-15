package academy.devdojo.spring.boot.essentials.repository;

import academy.devdojo.spring.boot.essentials.domain.Anime;

import java.util.List;

public interface AnimeRepository {

    List<Anime> listAll();

    List<Anime> findById();
}
