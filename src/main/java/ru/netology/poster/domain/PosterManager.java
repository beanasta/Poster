package ru.netology.poster.domain;

public class PosterManager {

    private PosterRepository repo;

    private int limitMovie;

    private int resultLength;


    public PosterManager(PosterRepository repo) {
        this.repo = repo;
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


    public void add(Movie movie) {
        repo.save(movie);
    }


    public Movie[] findLast() {


        Movie[] result = repo.getMovies();


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



