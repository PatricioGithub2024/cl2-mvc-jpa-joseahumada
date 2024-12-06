package pe.edu.i202224977.cl2_mvc_jpa_joseahumada.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmCategoryPk {

    @Column(name = "film_id")
    private Integer filmId;
    @Column(name = "category_id")
    private Integer categoryId;

}
