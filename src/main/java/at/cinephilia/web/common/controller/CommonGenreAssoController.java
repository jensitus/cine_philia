package at.cinephilia.web.common.controller;

import at.cinephilia.data.DataFromSpiderman;
import at.cinephilia.data.GetTheFuckingHash;
import at.cinephilia.web.common.service.CommonService;
import at.cinephilia.web.model.GenreAsso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/genreasso")
public class CommonGenreAssoController {

    @Autowired
    private CommonService commonService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ModelAndView getTheGAsso() throws IOException, NoSuchAlgorithmException {
        ModelAndView modelAndView = new ModelAndView("common");
        List<GenreAsso> genreAssoListId = commonService.genreAssoList();
        List<GenreAsso> genreAssos = getGenreAssoFromJson(genreAssoListId);
        modelAndView.addObject("genreassos", genreAssos);
        return modelAndView;
    }

    private List<GenreAsso> getGenreAssoFromJson(List<GenreAsso> genreAssoListId) throws IOException, NoSuchAlgorithmException {
        List<GenreAsso> genre_asso = new ArrayList<>();
        GenreAsso genreAsso;
        String _ID;
        String movie_ID;
        String genre_ID;
        for (JsonObject jsonObject : getParticipantJsonArray().getValuesAs(JsonObject.class)) {
            movie_ID = jsonObject.getString("movie_ID");
            genre_ID = jsonObject.getString("genre_ID");
            _ID = new GetTheFuckingHash().getAMd5Hash(movie_ID, genre_ID);
            if (genreAssoListId.contains(_ID)) {

            } else {
                genreAsso = new GenreAsso(_ID, movie_ID, genre_ID);
                commonService.addGenreAsso(genreAsso);
                genre_asso.add(genreAsso);
            }
        }
        return genre_asso;
    }

    private JsonArray getParticipantJsonArray() throws IOException {
        JsonArray jsonArray = new DataFromSpiderman().getJsonObject().getJsonArray("genreAsso");
        return jsonArray;
    }

}
