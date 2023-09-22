package com.platzi.javatest.movies.services;

import com.platzi.javatest.movies.data.MovieRepository;
import com.platzi.javatest.movies.model.Genre;
import com.platzi.javatest.movies.model.Movie;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Buscar películas por nombre
 * Implementa la función findByName en MovieService,
 * añade un test para probar que funciona correctamente.
 * función encuentre películas que contengan una parte del nombre indicado (función contains.)
 * Si es necesario, añade más películas en el test, para que hayan películas que contengan las mismas palabras.
 * Trata de que la función devuelva las películas aunque busquemos “super” en minúsculas. (función toLowerCase.)
 */
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenre(Genre genre) {
        if (genre == null) {
            throw new IllegalArgumentException("El género no puede ser nulo.");
        }
        return movieRepository.findAll().
                stream().
                filter(movie -> movie.getGenre().equals(genre)).
                collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByLength(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("la duracion no puede ser 0.");
        }
        return movieRepository.findAll().
                stream().
                filter(movie -> movie.getMinutes() <= length).
                collect(Collectors.toList());
    }


    public Collection<Movie> findByName(String movieName) {
        if (movieName.trim().isEmpty()){
            throw new IllegalArgumentException("el nombre no puede ser vacio.");
        }
        return movieRepository.findAll().
                stream().
                filter(movie -> getNameMovie(movie).contains(movieName.toLowerCase())).
                collect(Collectors.toList());
    }

    public Collection<Movie> findByNameDirector(String nameDirector) {
        if (nameDirector.trim().isEmpty()){
            throw new IllegalArgumentException("el nombre no puede ser vacio.");
        }
        return movieRepository.findAll().
                stream().
                filter(movie -> getNameDirector(movie).contains(nameDirector.toLowerCase())).
                collect(Collectors.toList());
    }

    private static String getNameDirector(Movie movie) {
        return (movie != null && movie.getName() != null)? movie.getDirector().toLowerCase():"noNameDirector";
    }

    public Collection<Movie> findMoviesByTemplate(Movie template) {
        if(template == null){
            throw new IllegalArgumentException("no hay filtros.");
        }
        return movieRepository.findAll().stream().filter(Objects::nonNull)
                .filter(movie ->
                        getNameMovie(movie).contains(getNameMovie(template))||
                        movie.getMinutes() <= template.getMinutes()||
                        getNameDirector(movie).contains(getNameDirector(template))||
                        movie.getGenre().equals(template.getGenre())
                )
                .collect(Collectors.toList());
    }

    private static String getNameMovie(Movie movie) {
        return (movie != null && movie.getName() != null)? movie.getName().toLowerCase():"noNameMovie";
    }
}
