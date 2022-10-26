package ru.netology.poster.domain;

public class PosterManager {

    private PosterRepository repo;

    private int resultLength;


    public PosterManager(PosterRepository repo) {
        this.repo = repo;
    }

    public void add(Movie movie) {
        repo.save(movie);
    }


    public Movie[] findLast() {

        Movie[] result = repo.getMovies();
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



