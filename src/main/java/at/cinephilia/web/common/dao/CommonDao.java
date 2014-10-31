package at.cinephilia.web.common.dao;

import at.cinephilia.model.Contribute;
import at.cinephilia.model.GenreAsso;
import at.cinephilia.model.MovieTheater;
import at.cinephilia.model.Participant;

import java.util.List;

/**
 * Created by jens on 31.08.14.
 */
public interface CommonDao {

    public void addParticipant(Participant participant);
    public List<Participant> participantList();
    public void addContributes(Contribute contribute);
    public List<Contribute> contributeList();
    public void addGenreAsso(GenreAsso genreAsso);
    public List<GenreAsso> genreAssoList();
    public void addMovieTheater(MovieTheater movieTheater);
    public List<MovieTheater> getMovie_ID();
    public List<MovieTheater> getTheater_ID();

}
