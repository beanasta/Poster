package ru.netology.movies.poster.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OneMoviePosterManagerTest {

    PosterManager poster = new PosterManager();
    Movie movie1 = new Movie(100, "Бладшот", 2020, "Боевик");

    @BeforeEach
    public void setup() {
        poster.save(movie1);

    }

    @Test

    public void shouldSaveOneMovie() {
        Movie[] expected = {movie1};
        Movie[] actual = poster.findAll();

        Assertions.assertArrayEquals(expected, actual);


    }


    @Test

    public void shouldReversMovies() {

        Movie[] expected = {movie1};
        Movie[] actual = poster.findLast();

        Assertions.assertArrayEquals(expected, actual);


    }


}
