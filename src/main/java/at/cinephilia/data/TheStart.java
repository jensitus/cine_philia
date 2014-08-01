package at.cinephilia.data;

import at.cinephilia.config.app.AppConf;
import at.cinephilia.web.genre.model.Genre;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.io.IOException;

/**
 * Created by jens on 27.07.14.
 */
public class TheStart {

    public static void main(String[] args) throws IOException {


        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConf.class);
        ctx.refresh();

//        GetGenres getGenres = ctx.getBean(GetGenres.class);
//        getGenres.saveGenre();


        DataFromSpiderman fromSpiderman = new DataFromSpiderman();
        JsonArray jsonArray = fromSpiderman.getJsonObject().getJsonArray("genres");

        for (JsonObject jsonObject : jsonArray.getValuesAs(JsonObject.class)) {
            System.out.println(jsonObject.getString("name"));
            System.out.println(jsonObject.getString("_ID"));
            String name = jsonObject.getString("name");
            String _ID = jsonObject.getString("_ID");
            Genre genre = new Genre(name, _ID);

        }


    }

}
