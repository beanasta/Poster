package ru.netology.poster.domain;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LimitNumberMovieTest {

    PosterManager poster = new PosterManager();

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
    Movie movie12 = new Movie(111, "1917", 2019, "Драма");


    @BeforeEach
    public void setup() {
        poster.save(movie1);
        poster.save(movie2);
        poster.save(movie3);
        poster.save(movie4);
        poster.save(movie5);
        poster.save(movie6);
        poster.save(movie7);
        poster.save(movie8);
        poster.save(movie9);

    }


    @Test

    public void shouldFindAllBeforeLimitMovie() {

        Movie[] expected = {movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9};
        Movie[] actual = poster.findAll();

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

        poster.save(movie10);
        poster.save(movie11);
        poster.save(movie12);

        Movie[] expected = {movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10, movie11, movie12};
        Movie[] actual = poster.findAll();

        Assertions.assertArrayEquals(expected, actual);


    }


    @Test

    public void shouldFindLastOverLimitMovie() {

        poster.save(movie10);
        poster.save(movie11);

        Movie[] expected = {movie10, movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2, movie1};
        Movie[] actual = poster.findLast();

        Assertions.assertArrayEquals(expected, actual);


    }


    @Test

    public void shouldFindLastNewLimit() {

        poster.save(movie10);
        poster.save(movie11);

        poster.setLimitMovie(5);

        Movie[] expected = {movie5, movie4, movie3, movie2, movie1};
        Movie[] actual = poster.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void shouldSetNewLimit() {

        poster.setLimitMovie(9);

        int expected = 9;
        int actual = poster.getLimitMovie();

        Assertions.assertEquals(expected, actual);

    }


    @Test

    public void shouldSetBeforeMinLimit() {

        poster.setLimitMovie(0);

        int expected = 10;
        int actual = poster.getLimitMovie();

        Assertions.assertEquals(expected, actual);

    }


    @Test

    public void shouldSetMinLimit() {

        poster.setLimitMovie(1);

        int expected = 1;
        int actual = poster.getLimitMovie();

        Assertions.assertEquals(expected, actual);

    }


    @Test

    public void shouldSetNegativeLimit() {

        poster.setLimitMovie(-25);

        int expected = 10;
        int actual = poster.getLimitMovie();

        Assertions.assertEquals(expected, actual);

    }


    @Test

    public void shouldSetLimitOverMovie() {

        poster.setLimitMovie(15);

        Movie[] expected = {movie9, movie8, movie7, movie6, movie5, movie4, movie3, movie2, movie1};
        Movie[] actual = poster.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }


}
