package at.cinephilia.web.common.service;

import at.cinephilia.web.model.Contribute;
import at.cinephilia.web.model.GenreAsso;
import at.cinephilia.web.model.Participant;

import java.util.List;

/**
 * Created by jens on 31.08.14.
 */
public interface CommonService {

    public void addParticipant(Participant participant);
    public List<Participant> participantList();
    public void addContributes(Contribute contribute);
    public List<Contribute> contributeList();
    public void addGenreAsso(GenreAsso genreAsso);
    public List<GenreAsso> genreAssoList();

}
