package pe.edu.i202224977.cl2_mvc_jpa_joseahumada.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.i202224977.cl2_mvc_jpa_joseahumada.entity.Film;

public interface FilmRepository extends CrudRepository<Film, Integer> {
}
