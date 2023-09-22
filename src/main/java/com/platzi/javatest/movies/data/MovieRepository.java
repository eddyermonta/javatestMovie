package com.platzi.javatest.movies.data;

import com.platzi.javatest.movies.model.Movie;

import java.util.Collection;

public interface MovieRepository {
    Movie findById(Long id);
    Collection<Movie> findAll();
    void saveOrUpdate(Movie movie);
}
