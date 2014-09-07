package at.cinephilia.web.movie.service;

import at.cinephilia.web.model.Movie;

import java.util.List;

/**
 * Created by jens on 19.08.14.
 */
public interface MovieService {

    public List<Movie> getMovies();
    public void addMovie(Movie movie);

}
