package at.cinephilia.web.theater.dao;

import at.cinephilia.model.Theater;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jens on 30.08.14.
 */

@Repository
public class TheaterDaoImpl implements TheaterDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addTheater(Theater theater) {
        getCurrentSession().persist(theater);
    }

    @Override
    public List<Theater> theater_id_list() {
        return getCurrentSession().createQuery("select _id from Theater").list();
    }

    @Override
    public List loadTheaterById(int id) {
        String hql = "from Theater t, Schedule s, Movie m where t.id = :id and t._id = s.theater_id and s.movie_id = m._id";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("id", id);
        return query.list();
    }

    @Override
    public List<Theater> get_theaters() {
        return getCurrentSession().createQuery("from Theater").list();
    }

    @Override
    public List<Theater> getTheaterViaSchedule(String movie_id) {
        String hql = "from Movie m, Schedule s, Theater t where m._id = s.movie_id and s.theater_id = t._id and m._id = :movie_id";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("movie_id", movie_id);
        List<Theater> theatersForThatMovie = query.list();
        return theatersForThatMovie;
    }

    @Override
    public Theater getTheaterByTheater_Id(String theater_id) {
        String hql = "from Theater where _ID = :theater_id";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("theater_id", theater_id);
        List<Theater> theaters = query.list();
        Theater t = null;
        for (Theater theater : theaters) {
            if (theater != null) {
                t = theater;
            }
        }
        if (t == null) {
            System.out.println("++ if ( t == null) **:");
            System.out.println(t);
            System.out.println("++ t **!");
            return null;
        } else {
            System.out.println("++ if ( t != null) **");
            System.out.println(t);
            System.out.println(t.getName());
            System.out.println("*************");
            return t;
        }
    }
}
