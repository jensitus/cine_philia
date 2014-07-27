package at.cinephilia.web.genre.controller;

import at.cinephilia.data.GetGenres;
import at.cinephilia.web.genre.model.Genre;
import at.cinephilia.web.genre.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * Created by jens on 27.07.14.
 */

@Controller
@RequestMapping(value = "/genrecon")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @RequestMapping(value = "/gen", method = RequestMethod.GET)
    public ModelAndView addGenre(Genre genre) throws IOException {
        ModelAndView modelAndView = new ModelAndView("main");
        GetGenres getGenres = new GetGenres();
        getGenres.saveGenre();
        return modelAndView;
    }

}
