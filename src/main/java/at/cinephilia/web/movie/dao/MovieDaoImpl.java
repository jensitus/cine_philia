package at.cinephilia.web.movie.dao;

import at.cinephilia.web.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieDaoImpl implements MovieDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Movie> getMovies() {
        return getCurrentSession().createQuery("from Movie").list();
    }

    @Override
    public void addMovie(Movie movie) {
        getCurrentSession().persist(movie);
    }

    @Override
    public Movie loadMovieById(final Long movieId) {
        return (Movie) getCurrentSession().get(Movie.class, movieId);
    }
}
