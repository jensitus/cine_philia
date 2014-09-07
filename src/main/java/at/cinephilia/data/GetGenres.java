package at.cinephilia.data;

import at.cinephilia.web.model.Genre;
import at.cinephilia.web.genre.service.GenreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.io.IOException;

/**
 * Created by jens on 27.07.14.
 */

@Component
public class GetGenres {

    Logger logger = LoggerFactory.getLogger(GetGenres.class);

    @Autowired
    private GenreService genreService;

    public void saveGenre() throws IOException {
        createGenre();

    }

    public Genre createGenre() throws IOException {
        String name;
        String _ID;
        Genre genre = null;
        for (JsonObject jsonObject : getJsonArray().getValuesAs(JsonObject.class)) {
            name = jsonObject.getString("name");
            _ID = jsonObject.getString("_ID");
            genre = new Genre(name, _ID);
            logger.info("This is a pity");
            logger.debug("genre", genre);
        }
        return genre;
    }

    private JsonArray getJsonArray() throws IOException {
        JsonArray jsonArray = new DataFromSpiderman().getJsonObject().getJsonArray("genres");
        return jsonArray;
    }

}
