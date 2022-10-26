package ru.netology.poster.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MinNumberMovieTest {

    PosterRepository repo = new PosterRepository();
    PosterManager poster = new PosterManager(repo);
    Movie movie1 = new Movie(100, "Бладшот", 2020, "Боевик");

    @BeforeEach
    public void setup() {
        repo.save(movie1);

    }

    @Test

    public void shouldSaveOneMovie() {
        Movie[] expected = {movie1};
        Movie[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);


    }


    @Test

    public void shouldFindLastMovie() {

        Movie[] expected = {movie1};
        Movie[] actual = poster.findLast();

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test

    public void shouldRemoveById() {

        repo.removeById(movie1.getId());

        Movie[] expected = {};
        Movie[] actual = repo.getMovies();

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test

    public void shouldRemoveAll() {

        repo.removeAll();

        Movie[] expected = {};
        Movie[] actual = repo.getMovies();

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test

    public void shouldFindByIdMovie() {

        repo.findById(movie1.getId());

        Movie[] expected = {movie1};
        Movie[] actual = repo.getMovies();

        Assertions.assertArrayEquals(expected, actual);


    }


}
