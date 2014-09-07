package at.cinephilia.web.common.dao;

import at.cinephilia.web.model.Contribute;
import at.cinephilia.web.model.GenreAsso;
import at.cinephilia.web.model.Participant;
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
}
