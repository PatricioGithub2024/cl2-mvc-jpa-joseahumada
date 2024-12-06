package pe.edu.i202224977.cl2_mvc_jpa_joseahumada.service;

import pe.edu.i202224977.cl2_mvc_jpa_joseahumada.dto.*;

import java.util.List;

public interface MaintenanceService {

    // Para Listar
    List<FilmListDto> getAllFilms();

    // Para Detalle
    FilmDetailDto getFilmById(int id);

    // Para Editar / Atualizar
    FilmEditDto getFilmEditById(int id);

    public void postFilmEditById(int id, FilmEditDto filmEditDto);

    // Para Crear / Insertar
    FilmCreateDto getFilmCreate();

    public void postFilmCreate(FilmCreateDto filmCreateDto);

    //Para Eliminar
    FilmDeleteDto getFilmDeleteById(int id);

    public void postFilmDeleteById(int id, FilmDeleteDto filmDeleteDto);

}
