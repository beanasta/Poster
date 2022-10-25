package ru.netology.movies.poster.domain;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class EmptyPosterManagerTest {

    PosterManager poster = new PosterManager();

    Movie movie1 = new Movie(100, "Бладшот", 2020, "Боевик");

    @Test

    public void shouldSaveFirstMovie() {

        poster.save(movie1);
        Movie[] expected = {movie1};
        Movie[] actual = poster.findAll();

        Assertions.assertArrayEquals(expected, actual);


    }


}
