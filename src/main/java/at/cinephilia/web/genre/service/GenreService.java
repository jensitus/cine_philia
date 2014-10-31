package at.cinephilia.web.genre.service;

import at.cinephilia.model.Genre;

import java.util.List;

/**
 * Created by jens on 27.07.14.
 */

public interface GenreService {

    public void addGenre(Genre genre);
    public List<Genre> genreNames();

}
