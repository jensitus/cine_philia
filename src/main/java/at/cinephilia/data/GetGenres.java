package at.cinephilia.data;

import at.cinephilia.web.genre.model.Genre;
import at.cinephilia.web.genre.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.io.IOException;

/**
 * Created by jens on 27.07.14.
 */
public class GetGenres {

    @Autowired
    private GenreService genreService;

    public void saveGenre() throws IOException {
        createGenre();

    }

    private void createGenre() throws IOException {
        String name;
        String _ID;
        for (JsonObject jsonObject : getJsonArray().getValuesAs(JsonObject.class)) {
            name = jsonObject.getString("name");
            _ID = jsonObject.getString("_ID");
            Genre genre = new Genre(name, _ID);
            System.out.println(genre + " : " + name + " : " + _ID);
            genreService.addGenre(genre);
        }

    }

    private JsonArray getJsonArray() throws IOException {
        JsonArray jsonArray = new DataFromSpiderman().getJsonObject().getJsonArray("genres");
        return jsonArray;
    }

}
