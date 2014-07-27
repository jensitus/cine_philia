package at.cinephilia.web.genre.dao;

import at.cinephilia.web.genre.model.Genre;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by jens on 27.07.14.
 */

@Repository
public class GenreDaoImpl implements GenreDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addGenre(Genre genre) {
        getCurrentSession().save(genre);
    }

}
