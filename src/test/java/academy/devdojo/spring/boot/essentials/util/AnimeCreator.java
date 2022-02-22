package academy.devdojo.spring.boot.essentials.util;

import academy.devdojo.spring.boot.essentials.domain.Anime;

public class AnimeCreator {

    public static Anime createAnimeToBeSaved() {
        return Anime.builder()
                .name("Cavaleiros do Zoodiaco")
                .build();
    }

    public static Anime createValidAnime() {
        return Anime.builder()
                .id(1L)
                .name("Cavaleiros do Zoodiaco")
                .build();
    }

    public static Anime createValidUpdatedAnime() {
        return Anime.builder()
                .id(1L)
                .name("Mickey Mouse")
                .build();
    }
}
