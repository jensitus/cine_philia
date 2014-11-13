package at.cinephilia.web.movie.service;

import at.cinephilia.model.Genre;
import at.cinephilia.model.Movie;
import at.cinephilia.web.movie.dao.MovieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jens on 19.08.14.
 */

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDao movieDao;

    @Override
    public List<Movie> getMovies() {
        return movieDao.getMovies();
    }

    @Override
    public void addMovie(Movie movie) {
        movieDao.addMovie(movie);
    }

    @Override
    public List getMovieTheaterViaSchedule(String movie_id) {
        return movieDao.getMovieTheaterViaSchedule(movie_id);
    }

    @Override
    public Movie loadMovie(final Long movieId) {
        return movieDao.loadMovieById(movieId);
    }

    @Override
    public List<Movie> getMovieIDs() {
        return movieDao.getMovieIDs();
    }

    @Override
    public Movie loadMovieByMovie_Id(String movie_id) {
        return movieDao.loadMovieByMovie_id(movie_id);
    }

    @Override
    public List<Genre> loadGenreByMovie(Long id) {
        return movieDao.loadGenreByMovie(id);
    }

}
