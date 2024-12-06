package pe.edu.i202224977.cl2_mvc_jpa_joseahumada.dto;

import java.util.Date;

public record FilmEditDto(Integer filmId,
                          String title,
                          String description,
                          Integer releaseYear,
                          //Integer languageId,
                          //Integer original_language_id,
                          Integer rentalDuration,
                          Double rentalRate,
                          Integer length,
                          Double replacementCost,
                          String rating,
                          String specialFeatures,
                          //@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
                          Date lastUpdate) {
}
