package ru.netology.poster.domain;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LimitNumberMovieTest {

    PosterRepository repo = new PosterRepository();
    PosterManager poster = new PosterManager(repo);

    Movie movie1 = new Movie(100, "Бладшот", 2020, "Боевик");
    Movie movie2 = new Movie(101, "Вперед", 2020, "Приключения");
    Movie movie3 = new Movie(102, "Отель \"Белград\"", 2020, "Романтическая комедия");
    Movie movie4 = new Movie(103, "Джентельмены", 2019, "Боевик");
    Movie movie5 = new Movie(104, "Удача", 2022, "Мультфильм");
    Movie movie6 = new Movie(105, "Время", 2021, "Ужасы");
    Movie movie7 = new Movie(106, "Виновный", 2021, "Триллер");
    Movie movie8 = new Movie(107, "Дюна", 2021, "Приключения");
    Movie movie9 = new Movie(108, "Веном", 2021, "Боевик");

    Movie movie10 = new Movie(109, "Довод", 2020, "Боевик");

    Movie movie11 = new Movie(110, "Гнев", 2021, "Боевик");


    @BeforeEach

    public void setup() {
        repo.save(movie1);
        repo.save(movie2);
        repo.save(movie3);
        repo.save(movie4);
        repo.save(movie5);
        repo.save(movie6);
        repo.save(movie7);
        repo.save(movie8);
        repo.save(movie9);

    }


    @Test

    public void shouldFindAllBeforeLimitMovie() {

        Movie[] expected = {movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9};
        Movie[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);


    }


    @Test

    public void shouldFindLastBeforeLimitMovie() {

        Movie[] expected = {movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2, movie1};
        Movie[] actual = poster.findLast();

        Assertions.assertArrayEquals(expected, actual);


    }


    @Test

    public void shouldFindAllOverLimitMovie() {

        repo.save(movie10);
        repo.save(movie11);

        Movie[] expected = {movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10, movie11};
        Movie[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);


    }


    @Test

    public void shouldFindLastOverLimitMovie() {

        repo.save(movie10);
        repo.save(movie11);

        Movie[] expected = {movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2, movie1};
        Movie[] actual = poster.findLast();

        Assertions.assertArrayEquals(expected, actual);


    }


    @Test

    public void shouldRemoveById() {

        repo.removeById(movie1.getId());

        Movie[] expected = {movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9};
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

        repo.findById(movie5.getId());

        Movie[] expected = {movie5};
        Movie[] actual = repo.getMovies();

        Assertions.assertArrayEquals(expected, actual);


    }


}