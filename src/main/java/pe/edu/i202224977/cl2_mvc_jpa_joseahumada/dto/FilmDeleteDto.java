package pe.edu.i202224977.cl2_mvc_jpa_joseahumada.dto;

import java.util.Date;

public record FilmDeleteDto(Integer filmId,
                            String title,
                            String description,
                            Integer releaseYear,
                            Integer languageId,
                            Integer rentalDuration,
                            Double rentalRate,
                            Integer length,
                            Double replacementCost,
                            String rating,
                            String specialFeatures) {
}
