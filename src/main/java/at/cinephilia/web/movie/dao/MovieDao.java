package at.cinephilia.web.movie.dao;

import at.cinephilia.web.model.Movie;

import java.util.List;

/**
 * Created by jens on 19.08.14.
 */
public interface MovieDao {

    public List<Movie> getMovies();
    public void addMovie(Movie movie);

    /**
     * Loads a movie by its id. Returns null if no movie is found.
     *
     * @param movieId
     * @return
     */
    public Movie loadMovieById(Long movieId);

}
