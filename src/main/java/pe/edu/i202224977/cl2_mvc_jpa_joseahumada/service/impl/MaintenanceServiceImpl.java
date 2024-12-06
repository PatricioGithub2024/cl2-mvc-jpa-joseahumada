package pe.edu.i202224977.cl2_mvc_jpa_joseahumada.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.i202224977.cl2_mvc_jpa_joseahumada.dto.*;
import pe.edu.i202224977.cl2_mvc_jpa_joseahumada.repository.FilmRepository;
import pe.edu.i202224977.cl2_mvc_jpa_joseahumada.entity.Film;
import pe.edu.i202224977.cl2_mvc_jpa_joseahumada.entity.Language;
import pe.edu.i202224977.cl2_mvc_jpa_joseahumada.repository.LanguageRepository;
import pe.edu.i202224977.cl2_mvc_jpa_joseahumada.service.MaintenanceService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    LanguageRepository languageRepository;

    @Override
    public List<FilmListDto> getAllFilms() {

        List<FilmListDto> films = new ArrayList<FilmListDto>();
        Iterable<Film> iterable = filmRepository.findAll();

        iterable.forEach(film -> {

            //realizar la discriminacion
            FilmListDto filmListDto = new FilmListDto(film.getFilmId(),
                    film.getTitle(),
                    film.getDescription(),
                    film.getLanguage().getName(),
                    film.getRentalRate());

            films.add(filmListDto);
        });

        return films;
    }

    @Override
    public FilmDetailDto getFilmById(int id) {
        Optional<Film> optional = filmRepository.findById(id);

        return optional.map(
                film -> new FilmDetailDto(film.getFilmId(),
                        film.getTitle(),
                        film.getDescription(),
                        film.getReleaseYear(),
                        film.getLanguage().getLanguageId(),
                        film.getLanguage().getName(),
                        film.getOriginalLanguageId(),
                        film.getRentalDuration(),
                        film.getRentalRate(),
                        film.getLength(),
                        film.getReplacementCost(),
                        film.getRating(),
                        film.getSpecialFeatures(),
                        film.getLastUpdate())

        ).orElse(null);
    }

    @Override
    public FilmEditDto getFilmEditById(int id) {
        Optional<Film> optional = filmRepository.findById(id);

        return optional.map(
                film -> new FilmEditDto(
                        film.getFilmId(),
                        film.getTitle(),
                        film.getDescription(),
                        film.getReleaseYear(),
                        //film.getLanguage().getLanguageId(),
                        film.getRentalDuration(),
                        film.getRentalRate(),
                        film.getLength(),
                        film.getReplacementCost(),
                        film.getRating(),
                        film.getSpecialFeatures(),
                        film.getLastUpdate())

        ).orElse(null);

    }

    @Override
    public void postFilmEditById(int id, FilmEditDto filmEditDto) {

            // Buscar por Id
            Film film = filmRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Film not found"));
            //para language
//            Language language = languageRepository.findById(filmEditDto.languageId())
//                    .orElseThrow(() -> new EntityNotFoundException("Language with ID not found"));

            // Actualizar
            film.setTitle(filmEditDto.title());
            film.setDescription(filmEditDto.description());
            film.setReleaseYear(filmEditDto.releaseYear());
            //film.setLanguage(language);
            film.setRentalDuration(filmEditDto.rentalDuration());
            film.setRentalRate(filmEditDto.rentalRate());
            film.setLength(filmEditDto.length());
            film.setReplacementCost(filmEditDto.replacementCost());
            film.setRating(filmEditDto.rating());
            film.setSpecialFeatures(filmEditDto.specialFeatures());
            film.setLastUpdate(new Date());
            // Guardar en DB
            filmRepository.save(film);

    }

    @Override
    public FilmCreateDto getFilmCreate() {

        return new FilmCreateDto(0, "", "", null, 0, null, 0, 0.0, 0, 0.0, "", "", new Date());
    }

    @Override
    public void postFilmCreate(FilmCreateDto filmCreateDto) {

        Film film = new Film();
        //para language
        Language language = languageRepository.findById(filmCreateDto.languageId())
              .orElseThrow(() -> new EntityNotFoundException("ID de lenguaje no existente"));

        //film.setFilmId(0);
        film.setTitle(filmCreateDto.title());
        film.setDescription(filmCreateDto.description());
        film.setReleaseYear(filmCreateDto.releaseYear());
        film.setLanguage(language);
        film.setOriginalLanguageId(null);
        film.setRentalDuration(filmCreateDto.rentalDuration());
        film.setRentalRate(filmCreateDto.rentalRate());
        film.setLength(filmCreateDto.length());
        film.setReplacementCost(filmCreateDto.replacementCost());
        film.setRating(filmCreateDto.rating());
        film.setSpecialFeatures(filmCreateDto.specialFeatures());
        film.setLastUpdate(new Date());

        filmRepository.save(film);

    }

    @Override
    public FilmDeleteDto getFilmDeleteById(int id) {
        Optional<Film> optional = filmRepository.findById(id);

        return optional.map(
                film -> new FilmDeleteDto(
                        film.getFilmId(),
                        film.getTitle(),
                        film.getDescription(),
                        film.getReleaseYear(),
                        film.getLanguage().getLanguageId(),
                        film.getRentalDuration(),
                        film.getRentalRate(),
                        film.getLength(),
                        film.getReplacementCost(),
                        film.getRating(),
                        film.getSpecialFeatures())

        ).orElse(null);

    }

    @Override
    @Transactional
    public void postFilmDeleteById(int id, FilmDeleteDto filmDeleteDto) {

        Optional<Film> optional = filmRepository.findById(id);

        Film film = optional.orElseThrow(() -> new EntityNotFoundException("Film not found"));

        filmRepository.delete(film);
    }

}
