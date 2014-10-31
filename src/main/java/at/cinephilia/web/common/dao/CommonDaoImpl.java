package at.cinephilia.web.common.dao;

import at.cinephilia.model.Contribute;
import at.cinephilia.model.GenreAsso;
import at.cinephilia.model.MovieTheater;
import at.cinephilia.model.Participant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommonDaoImpl implements CommonDao{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addParticipant(Participant participant) {
        getSession().persist(participant);
    }

    @Override
    public List<Participant> participantList() {
        return getSession().createQuery("select _ID from Participant").list();
    }

    @Override
    public void addContributes(Contribute contribute) {
        getSession().persist(contribute);
    }

    @Override
    public List<Contribute> contributeList() {
        return getSession().createQuery("select _ID from Contribute").list();
    }

    @Override
    public void addGenreAsso(GenreAsso genreAsso) {
        getSession().persist(genreAsso);
    }

    @Override
    public List<GenreAsso> genreAssoList() {
        return getSession().createQuery("select _ID from GenreAsso").list();
    }

    @Override
    public void addMovieTheater(MovieTheater movieTheater) {
        getSession().persist(movieTheater);
    }

    @Override
    public List<MovieTheater> getMovie_ID() {
        return getSession().createQuery("select movie_id from MovieTheater").list();
    }

    @Override
    public List<MovieTheater> getTheater_ID() {
        return getSession().createQuery("select theater_id from MovieTheater").list();
    }
}
