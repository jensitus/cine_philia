package at.cinephilia.web.genre.dao;

import at.cinephilia.web.model.Genre;

import java.util.List;

/**
 * Created by jens on 27.07.14.
 */
public interface GenreDao {

    public void addGenre(Genre genre);
    public List<Genre> genreNames();

}
