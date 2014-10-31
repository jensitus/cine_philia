package at.cinephilia.web.genre.dao;

import at.cinephilia.model.Genre;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        getCurrentSession().persist(genre);
    }

    @Override
    public List<Genre> genreNames() {
        return (List<Genre>) getCurrentSession().createQuery("select name from Genre").list();
    }


}
