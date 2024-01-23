package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Optional<Movie> findByImdbId(String imdbId) {
        return movieRepository.findByImdbId(imdbId);
    }

    public Movie create(Movie movie) {
        return movieRepository.save(movie);
    }

    public Optional<Movie> update(String imdbId, Movie movie) {
        Optional<Movie> movieOptional = movieRepository.findByImdbId(imdbId);
        if (movieOptional.isEmpty()) {
            return Optional.empty();
        }
        movie.setId(movieOptional.get().getId());
        return Optional.of(movieRepository.save(movie));
    }

    public Optional<Movie> delete(String imdbId) {
        Optional<Movie> movieOptional = movieRepository.findByImdbId(imdbId);
        if (movieOptional.isEmpty()) {
            return Optional.empty();
        }
        movieRepository.delete(movieOptional.get());
        return movieOptional;
    }
}
