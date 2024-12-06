package pe.edu.i202224977.cl2_mvc_jpa_joseahumada.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmActorPk {

    @Column(name = "actor_id")
    private Integer actorId;
    @Column(name = "film_id")
    private Integer filmId;

}
