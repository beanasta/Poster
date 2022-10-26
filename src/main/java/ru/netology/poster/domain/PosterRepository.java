package ru.netology.poster.domain;

public class PosterRepository {

    private Movie[] movies = new Movie[0];


    public Movie[] getMovies() {
        return movies;
    }


    public void save(Movie movie) {

        Movie[] tmp = new Movie[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }

        tmp[tmp.length - 1] = movie;
        movies = tmp;

    }


    public void removeById(int id) {

        Movie[] tmp = new Movie[movies.length - 1];
        int copyToIndex = 0;
        for (Movie movie : movies) {
            if (movie.getId() != id) {
                tmp[copyToIndex] = movie;
                copyToIndex++;
            }
        }
        movies = tmp;
    }

    public void removeAll() {

        Movie[] tmp = new Movie[0];

        movies = tmp;
    }


    public Movie[] findAll() {

        return movies;
    }


    public Movie[] findById(int id) {

        Movie[] tmp = new Movie[1];
        int copiedObject = 0;
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                tmp[copiedObject] = movie;
                copiedObject++;


            }
            movies = tmp;
        }
        return getMovies();


    }


}
