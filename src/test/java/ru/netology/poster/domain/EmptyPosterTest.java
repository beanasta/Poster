package ru.netology.poster.domain;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class EmptyPosterTest {

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
