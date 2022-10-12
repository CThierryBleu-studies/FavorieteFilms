package be.ucll.favorietefilms;

import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/films")
public class FavorieteFilmsController {
//        public static void main(String[] args) {
//        SpringApplication.run(FavorieteFilmsController.class, args);}}
    private final FilmService filmService = new FilmService();

    @GetMapping(value="")
    public List<String> getFilms(){
        return filmService.getAllFilms();
    }

    @GetMapping("/{title}")
    public ResponseEntity<List<String>> get(@PathVariable String title){
        try {
            List<String> film = filmService.getFilmByTitle(title);
            return new ResponseEntity<>(film, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/", consumes = {"application/xml","application/json"})
    public ResponseEntity<String> add(@RequestBody Film film) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        filmService.addFilm(film);
        return new ResponseEntity<String>(httpHeaders, HttpStatus.OK);
    }

    @PutMapping("/{title}")
    public ResponseEntity<String> edit(@PathVariable(name = "title", required = true) String title, @RequestBody Film film) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        filmService.editFilm(film);
        return new ResponseEntity<String>(httpHeaders, HttpStatus.OK);
    }
}
