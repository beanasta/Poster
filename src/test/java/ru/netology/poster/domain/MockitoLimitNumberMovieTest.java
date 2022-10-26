package ru.netology.poster.domain;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.doReturn;

public class MockitoLimitNumberMovieTest {

    PosterRepository repo = Mockito.mock(PosterRepository.class);
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


    @Test

    public void shouldFindAllOverLimitMovie() {

        Movie[] movies = {movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10, movie11};
        doReturn(movies).when(repo).findAll();

        Movie[] expected = {movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10, movie11};
        Movie[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldFindAllBeforeLimitMovie() {

        Movie[] movies = {movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9};
        doReturn(movies).when(repo).findAll();

        Movie[] expected = {movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9};
        Movie[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);


    }


}
