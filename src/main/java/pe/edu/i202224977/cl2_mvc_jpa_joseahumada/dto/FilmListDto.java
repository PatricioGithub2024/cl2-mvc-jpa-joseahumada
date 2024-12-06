package pe.edu.i202224977.cl2_mvc_jpa_joseahumada.dto;

public record FilmListDto(Integer filmId,
                          String title,
                          String description,
                          String language,
                          Double rentalRate) {
}
