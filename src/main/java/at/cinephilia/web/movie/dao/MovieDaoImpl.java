package at.cinephilia.web.movie.dao;

import at.cinephilia.model.Movie;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieDaoImpl implements MovieDao {

    private final Logger logger = LoggerFactory.getLogger(getClass());

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
    public List<Movie> getMovieIDs() {
        return getCurrentSession().createQuery("select _id from Movie").list();
    }

    @Override
    public Movie loadMovieById(final Long movieId) {
        return (Movie) getCurrentSession().get(Movie.class, movieId);
    }

    @Override
    public List getMovieTheaterViaSchedule(String movie_id) {
        //String hql = "select m.title, s.dat, s.tim, t.name from Movie m, Schedule s, Theater t where m._id = :movie_id and m._id = s.movie_id and s.theater_id = t._id group by s.dat, m.title, t.name, s.unixtime, s.tim order by s.unixtime";
        //String hql = "from Movie m where m._id = :movie_id";
        String hql = "from Movie m, Schedule s, Theater t where m._id = :movie_id and m._id = s.movie_id and s.theater_id = t._id order by s.unixtime";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("movie_id", movie_id);
        List movie_theaters_via_schedules = query.list();
//        Iterator mtvs = movie_theaters_via_schedules.listIterator();
//        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
//        System.out.println();
//        System.out.println();
//        logger.debug("mein movie: {}", movie_theaters_via_schedules);
//        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
//        System.out.println();
//        System.out.println();
//        for (Object platzhalter : movie_theaters_via_schedules) {
//            logger.debug("for: {}", platzhalter);
//            System.out.println(platzhalter);
//        }
//        while ( mtvs.hasNext() ) {
//            Object[] result = (Object[]) mtvs.next();
//            Movie movie = (Movie) result[0];
//            Schedule schedule = (Schedule) result[1];
//            Theater theater = (Theater) result[2];
//            System.out.println("theater: " + theater.getName());
//            System.out.println("movie: " + movie.getTitle());
//            System.out.println("Uhrzeit: " + schedule.getDatetime());
//        }



//        while ( mtvs.hasNext() ) {
//
//            System.out.println(mtvs.getClass());
//            System.out.println(mtvs.next().getClass());
//
//            Object variable = mtvs.next();
//            System.out.println("while +++++++ : " + variable.getClass());
//
//            //System.out.println(movie_theaters_via_schedules.next().getClass());
//        }
        System.out.println();
        System.out.println();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
        return movie_theaters_via_schedules;
    }

    @Override
    public Movie loadMovieByMovie_id(String movie_id) {
        String sql = "from Movie where _ID = :movie_id";
        Query query = getCurrentSession().createQuery(sql);
        query.setParameter("movie_id", movie_id);
        List<Movie> movies = query.list();
        Movie m = null;
        for (Movie movie : movies) {
            if (movie != null) {
                m = movie;
            }
        }
        if (m == null) {
            System.out.println("++ ++ ++");
            System.out.println(m);
            System.out.println("null");
            System.out.println("++ ++ ++");
            return null;
        } else {
            System.out.println("++ ++ ++");
            System.out.println(m);
            System.out.println(m.getTitle());
            System.out.println("++ ++ ++");
            return m;
        }

    }


//    public Movie loadMovieByMovie_id(String movie_id){
//        return (Movie) getCurrentSession().get(Movie.class, movie_id);
//    }

}
