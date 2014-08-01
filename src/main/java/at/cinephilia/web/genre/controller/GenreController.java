package at.cinephilia.web.genre.controller;

import at.cinephilia.data.DataFromSpiderman;
import at.cinephilia.web.genre.model.Genre;
import at.cinephilia.web.genre.service.GenreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jens on 27.07.14.
 */

@Controller
@RequestMapping(value = "/genrecon")
public class GenreController {

    Logger logger = LoggerFactory.getLogger(GenreController.class);

    @Autowired
    private GenreService genreService;

    @RequestMapping(value = "/gen", method = RequestMethod.GET)
    public ModelAndView addGenre() throws IOException {
        ModelAndView modelAndView = new ModelAndView("main");
        List<Genre> genreList = getGenreNames();
        List<Genre> newGenresList = createGenre(genreList);
        modelAndView.addObject("genres", newGenresList);
        return modelAndView;
    }

    private List<Genre> getGenreNames() {
        List<Genre> genreNames;
        genreNames = genreService.genreNames();
        return genreNames;
    }

    private List<Genre> createGenre(List<Genre> genreList) throws IOException {
        String name;
        String _ID;
        Genre genre;
        List<Genre> genreList1 = genreList;
        List<Genre> genres = new ArrayList<>();

        for (JsonObject jsonObject : getJsonArray().getValuesAs(JsonObject.class)) {
            name = jsonObject.getString("name");
            _ID = jsonObject.getString("_ID");
            System.out.println("name:");
            System.out.println(name);
            if (genreList1.contains(name)) {
                logger.info("true");
            } else {
                genre = new Genre(name, _ID);
                genreService.addGenre(genre);
                genres.add(genre);
            }
        }
        return genres;
    }

    private JsonArray getJsonArray() throws IOException {
        JsonArray jsonArray = new DataFromSpiderman().getJsonObject().getJsonArray("genres");
        return jsonArray;
    }

}
