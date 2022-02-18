package academy.devdojo.spring.boot.essentials.service;

import academy.devdojo.spring.boot.essentials.domain.Anime;
import academy.devdojo.spring.boot.essentials.exception.BadRequestException;
import academy.devdojo.spring.boot.essentials.mapper.AnimeMapper;
import academy.devdojo.spring.boot.essentials.repository.AnimeRepository;
import academy.devdojo.spring.boot.essentials.requests.AnimePostRequestBody;
import academy.devdojo.spring.boot.essentials.requests.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;

    public Page<Anime> listAll(Pageable pageable) {
        return animeRepository.findAll(pageable);
    }

    public List<Anime> findByName(String name) {
        return animeRepository.findByName(name);
    }

    public Anime findByIdOrThrowBadRequestException(long id) {
        return animeRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Anime not Found"));
    }

    @Transactional
    public Anime save(AnimePostRequestBody animePostRequestBody) {
        return animeRepository.save(AnimeMapper.INSTANCE.toAnime(animePostRequestBody));
    }

    public void delete(long id) {
        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody) {
        Anime anime = AnimeMapper.INSTANCE.toAnime(animePutRequestBody);
        animeRepository.save(anime);
    }
}