package com.platzi.javatest.movies.data;

import com.platzi.javatest.movies.model.Genre;
import com.platzi.javatest.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.util.Collection;

public class MovieRepositoryJdbc implements MovieRepository {
   private final JdbcTemplate jdbcTemplate;

    public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(Long id) {
        Object[] args = {id};

       return jdbcTemplate.queryForObject("select * from movies where id = ?",
               args,
               movieMapper
       );
    }

    @Override
    public Collection<Movie> findAll() {
        return jdbcTemplate.query("select * from movies", movieMapper);
    }


    @Override
    public void saveOrUpdate(Movie movie) {
        jdbcTemplate.update("insert INTO movies (name,minutes,genre,director) values (?,?,?,?)",
                movie.getName(),
                movie.getMinutes(),
                movie.getGenre().toString(),
                movie.getDirector()
        );
    }

    private static final RowMapper<Movie> movieMapper = (rs, rowNum) ->
            new Movie(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("minutes"),
                    Genre.valueOf(rs.getString("genre")),
                    rs.getString("director"));
}
