package at.cinephilia.web.common.service;

import at.cinephilia.model.MovieTheater;
import at.cinephilia.web.common.dao.CommonDao;
import at.cinephilia.model.Contribute;
import at.cinephilia.model.GenreAsso;
import at.cinephilia.model.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommonServiceImpl implements CommonService {

    @Autowired
    private CommonDao commonDao;

    @Override
    public void addParticipant(Participant participant) {
        commonDao.addParticipant(participant);
    }

    @Override
    public List<Participant> participantList() {
        return commonDao.participantList();
    }

    @Override
    public void addContributes(Contribute contribute) {
        commonDao.addContributes(contribute);
    }

    @Override
    public List<Contribute> contributeList() {
        return commonDao.contributeList();
    }

    @Override
    public void addGenreAsso(GenreAsso genreAsso) {
        commonDao.addGenreAsso(genreAsso);
    }

    @Override
    public List<GenreAsso> genreAssoList() {
        return commonDao.genreAssoList();
    }

    @Override
    public void addMovieTheater(MovieTheater movieTheater) {
        commonDao.addMovieTheater(movieTheater);
    }

    @Override
    public List<MovieTheater> getMovie_ID() {
        return commonDao.getMovie_ID();
    }

    @Override
    public List<MovieTheater> getTheater_ID() {
        return commonDao.getTheater_ID();
    }
}
