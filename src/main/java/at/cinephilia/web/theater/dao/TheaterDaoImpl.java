package at.cinephilia.web.theater.dao;

import at.cinephilia.web.model.Theater;
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
        return getCurrentSession().createQuery("select _ID from Theater").list();
    }
}
