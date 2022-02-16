package academy.devdojo.spring.boot.essentials.repository;

import academy.devdojo.spring.boot.essentials.domain.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime, Long> {

}
