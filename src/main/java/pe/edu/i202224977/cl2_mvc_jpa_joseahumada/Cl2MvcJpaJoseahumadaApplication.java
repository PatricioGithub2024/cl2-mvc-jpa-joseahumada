package pe.edu.i202224977.cl2_mvc_jpa_joseahumada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.i202224977.cl2_mvc_jpa_joseahumada.entity.Film;
import pe.edu.i202224977.cl2_mvc_jpa_joseahumada.repository.FilmRepository;

import java.util.Optional;

@SpringBootApplication
public class Cl2MvcJpaJoseahumadaApplication implements CommandLineRunner {

	@Autowired
	FilmRepository filmRepository;


	public static void main(String[] args) {
		SpringApplication.run(Cl2MvcJpaJoseahumadaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		/**
		 * finAll - Caching -1era
		 */

		System.out.println("-----------------------------------------------");
		System.out.println("finAll() - 1era llamada MySQL");
		System.out.println("-----------------------------------------------");
		Iterable<Film> iterable = filmRepository.findAll();
		iterable.forEach((film) -> {
			String message = String.format("%s:%s", film.getFilmId(), film.getTitle());
			//si le quito el ln a "println" no hace salto de linea
			System.out.print(message);

		});

		/**
		 * finAll - Caching -2da
		 */
		System.out.println(" ");
		System.out.println("-----------------------------------------------");
		System.out.println("finAll() - 2da llamada Cache");
		System.out.println("-----------------------------------------------");
		Iterable<Film> iterable2 = filmRepository.findAll();
		iterable2.forEach((film) -> {
			String message = String.format("%s:%s", film.getFilmId(), film.getTitle());
			//si le quito el ln a "println" no hace salto de linea
			System.out.print(message);

		});

		/**
		 * finAll - Caching -3era
		 */
		System.out.println(" ");
		System.out.println("-----------------------------------------------");
		System.out.println("save() - film");
		System.out.println("-----------------------------------------------");
		Optional<Film> optional = filmRepository.findById(1);
		//presenta 2 lamda - correcto- no existente
		optional.ifPresentOrElse(
				(film) -> {
					film.setTitle("BATMAN RETURN 7");
					filmRepository.save(film);
				},
				() -> {
					System.out.println("film not found");
				}
		);

		/**
		 * finAll - Caching -4ta
		 */
		System.out.println(" ");
		System.out.println("-----------------------------------------------");
		System.out.println("finAll() - 4ta llamada Cache");
		System.out.println("-----------------------------------------------");
		Iterable<Film> iterable3 = filmRepository.findAll();
		iterable3.forEach((film) -> {
			String message = String.format("%s:%s", film.getFilmId(), film.getTitle());
			//si le quito el ln a "println" no hace salto de linea
			System.out.print(message);

		});


	}
}
