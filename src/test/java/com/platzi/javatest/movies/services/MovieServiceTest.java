package com.platzi.javatest.movies.services;

import com.platzi.javatest.movies.data.MovieRepository;
import com.platzi.javatest.movies.model.Genre;
import com.platzi.javatest.movies.model.Movie;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class MovieServiceTest {
    private MovieService movieService;

    @Before
    public void setUp() throws Exception {
        // Configura el entorno de prueba
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);
        movieService = new MovieService(movieRepository);

        // Configura el comportamiento del repositorio simulado
        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, Genre.ACTION,"director1"),
                        new Movie(2, "Memento", 113, Genre.THRILLER,"director1"),
                        new Movie(3, "There's Something About Marty", 119, Genre.COMEDY,"director1"),
                        new Movie(4, "Super 8", 112, Genre.THRILLER,"director1"),
                        new Movie(5, "Scream", 111, Genre.HORROR,"director2"),
                        new Movie(6, "Home Alone", 103, Genre.COMEDY,"director2"),
                        new Movie(7, "Matrix", 136, Genre.ACTION,"director2"),
                        new Movie(8, "Superman", 136, Genre.ACTION,"director2")
                )
        );
    }

    @Test
    public void shouldReturnMoviesByGenre() {
        // Ejecuta el método bajo prueba
        Collection<Movie> moviesByGenre = movieService.findMoviesByGenre(Genre.COMEDY);
        // Verifica que los IDs coincidan con las películas de comedia esperadas
        assertThat(getIds(moviesByGenre), is(Arrays.asList(3, 6)));
    }

    @Test
    public void should_return_movies_by_length() {
        // Ejecuta el método bajo prueba
        Collection<Movie> moviesByLength = movieService.findMoviesByLength(119);
        // Verifica que los IDs coincidan con las películas de comedia esperadas
        assertThat(getIds(moviesByLength), is(Arrays.asList(2, 3, 4, 5, 6)));
    }

    @Test
    public void should_return_movie_by_a_part_of_her_name() {
        Collection<Movie> moviesByName = movieService.findByName("SuPer");
        assertThat(getIds(moviesByName), is(Arrays.asList(4,8)));
    }

    @Test
    public void should_return_director_movie_by_a_part_of_her_name() {
        Collection<Movie> directorsMovie = movieService.findByNameDirector("direcTor1");
        assertThat(getIds(directorsMovie), is(Arrays.asList(1,2,3,4)));
    }

    @Test
    public void should_return_filters_if_movie_not_null() {
        Collection<Movie> directorsMovie =  movieService.findMoviesByTemplate(
                new Movie(
                        null,
                        150,
                        null,
                        null
                ));
        assertThat(getIds(directorsMovie), is(Arrays.asList(2,3,4,5,6,7,8)));
    }

    private static List<Integer> getIds(Collection<Movie> moviesByLength) {
        return moviesByLength.stream()
                .map(Movie::getId)
                .collect(Collectors.toList());
    }

}
