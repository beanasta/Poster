package ru.netology.poster.domain;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class EmptyPosterTest {

    PosterRepository repo = new PosterRepository();


    Movie movie1 = new Movie(100, "Бладшот", 2020, "Боевик");

    @Test

    public void shouldSaveFirstMovie() {

        repo.save(movie1);

        Movie[] expected = {movie1};
        Movie[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);


    }


    @Test

    public void shouldFindByIdMovie() {

        repo.save(movie1);
        repo.findById(movie1.getId());

        Movie[] expected = {movie1};
        Movie[] actual = repo.getMovies();

        Assertions.assertArrayEquals(expected, actual);


    }


    @Test

    public void shouldRemoveAll() {

        repo.save(movie1);
        repo.removeAll();

        Movie[] expected = {};
        Movie[] actual = repo.getMovies();

        Assertions.assertArrayEquals(expected, actual);


    }


    @Test

    public void shouldRemoveById() {

        repo.save(movie1);
        repo.removeById(movie1.getId());

        Movie[] expected = {};
        Movie[] actual = repo.getMovies();

        Assertions.assertArrayEquals(expected, actual);
    }


}
