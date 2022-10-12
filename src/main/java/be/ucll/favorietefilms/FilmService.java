package be.ucll.favorietefilms;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmService {
//    List<Film> films = new ArrayList<>();
//    {
//        Film film1 = new Film();
//        film1.setTitle("Shrek");
//        film1.setYear(2001);
//        film1.setScore(10);
//        film1.setReview("Shrek is love, Shrek is life.");
//        films.add(film1);
//
//        Film film2 = new Film();
//        film2.setTitle("Shrek2");
//        film2.setYear(2004);
//        film2.setScore(9);
//        film2.setReview("Shrek is love, Shrek is life.");
//        films.add(film2);
//        this.addFilm(film1);
//        this.addFilm(film2);
//    }

    private FilmRepository filmRepository = new FilmRepository();

    public void addFilm(Film pFilm) {
        filmRepository.insert(pFilm.getTitle(), pFilm.getYear(), pFilm.getScore(), pFilm.getReview());
    }

    public void editFilm(Film pFilm) {
        filmRepository.update(pFilm.getTitle(), pFilm.getYear(), pFilm.getScore(), pFilm.getReview());
    }

    public List<String> getAllFilms() {
        return filmRepository.getAllFilms();
    }

    public List<String> getFilmByTitle(String pFilmTitle) {
        return filmRepository.getByTitle(pFilmTitle);
    }
}
