package ru.netology.poster.domain;

public class PosterManager {


    private Movie[] movies = new Movie[0];


    private int limitMovie;

    public Movie[] getMovies() {
        return movies;
    }

    public PosterManager() {
        this.limitMovie = 10;

    }

    public PosterManager(int limitMovie) {
        this.limitMovie = limitMovie;
    }

    public int getLimitMovie() {
        return limitMovie;
    }

    public void setLimitMovie(int limitMovie) {
        if (limitMovie <= 0) {
            return;
        }
        this.limitMovie = limitMovie;

    }

    public void save(Movie movie) {

        Movie[] tmp = new Movie[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }

        tmp[tmp.length - 1] = movie;
        movies = tmp;

    }


    public Movie[] findAll() {

        Movie[] all = getMovies();
        return all;

    }


    public Movie[] findLast() {

        int resultLength;

        Movie[] result = getMovies();

        if (limitMovie < result.length) {
            resultLength = limitMovie;
        } else {
            resultLength = result.length;
        }

        Movie[] last = new Movie[resultLength];
        for (int i = 0; i < last.length; i++) {
            last[i] = result[resultLength - 1 - i];
        }
        return last;


    }


}



