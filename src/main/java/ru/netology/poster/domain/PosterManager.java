package ru.netology.poster.domain;

public class PosterManager {


    private Movie[] movies = new Movie[0];

    private int resultLength;


    public void save(Movie movie) {

        Movie[] tmp = new Movie[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }

        tmp[tmp.length - 1] = movie;
        movies = tmp;

    }


    public Movie[] findAll() {

        return movies;

    }


    public Movie[] findLast() {

        Movie[] result = movies;
        if (result.length < 10) {
            resultLength = result.length;
        }
        if (result.length >= 10) {
            resultLength = 10;
        }

        Movie[] last = new Movie[resultLength];
        for (int i = 0; i < last.length; i++) {
            last[i] = result[resultLength - 1 - i];
        }
        return last;


    }


}



