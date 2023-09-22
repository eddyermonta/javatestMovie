package com.platzi.javatest.movies.data;

import com.platzi.javatest.movies.model.Genre;
import com.platzi.javatest.movies.model.Movie;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;



public class MovieRepositoryIntegrationTest {
    MovieRepositoryJdbc movieRepositoryJdbc;
    DataSource dataSource;

    @Before
    public void setUp() throws Exception {
        dataSource = new DriverManagerDataSource(
                "jdbc:h2:mem:test;MODE=MYSQL",
                "sa",
                "sa");

        ScriptUtils.executeSqlScript(dataSource.getConnection(),
                new ClassPathResource("sql-scripts/test-data.sql"));

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        movieRepositoryJdbc = new MovieRepositoryJdbc(jdbcTemplate);
    }

    @Test
    public void find_all_movies() throws SQLException {
    Collection<Movie> allMovies = movieRepositoryJdbc.findAll();

        assertThat(allMovies, is( Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION,"director1"),
                new Movie(2, "Memento", 113, Genre.THRILLER,"director2"),
                new Movie(3, "Matrix", 136, Genre.ACTION,"director1")
        )));
    }

    @Test
    public void load_movies_by_id(){
        Movie movie = movieRepositoryJdbc.findById(2L);
        assertThat(movie, is(new Movie(2, "Memento", 113, Genre.THRILLER,"director2")));
    }

    @Test
    public void insert_movie() {
        Movie movie = new Movie(4,"Super 8", 112, Genre.THRILLER,"director2");
        movieRepositoryJdbc.saveOrUpdate(movie);
        Movie movieFromDB = movieRepositoryJdbc.findById(4L);
        assertThat(movieFromDB,is(movie));
    }

    @After
    public void tearDown() throws Exception {
        // Remove H2 files -- https://stackoverflow.com/a/51809831/1121497
        try (Statement s = dataSource.getConnection().createStatement()) {
            s.execute("drop all objects delete files"); // "shutdown" is also enough for mem db
        }
    }
}