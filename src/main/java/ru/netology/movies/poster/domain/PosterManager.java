package ru.netology.movies.poster.domain;

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

        Movie[] findLast = movies;
        if (findLast.length < 10) {
            resultLength = findLast.length;
        } else {
            resultLength = 10;
        }

        Movie[] result = new Movie[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = findLast[resultLength - 1 - i];
        }
        return result;


    }


}



