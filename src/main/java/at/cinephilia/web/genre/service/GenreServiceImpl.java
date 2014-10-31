package at.cinephilia.web.genre.service;

import at.cinephilia.web.genre.dao.GenreDao;
import at.cinephilia.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jens on 27.07.14.
 */

@Service
@Transactional
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreDao genreDao;

    @Override
    public void addGenre(Genre genre) {
        genreDao.addGenre(genre);
    }

    @Override
    public List<Genre> genreNames() {
        return genreDao.genreNames();
    }


}
