package at.cinephilia.data;

import at.cinephilia.config.app.AppConf;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * Created by jens on 27.07.14.
 */
public class TheStart {

    public static void main(String[] args) throws IOException {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConf.class);
        ctx.refresh();


        GetGenres getGenres = ctx.getBean(GetGenres.class);
        getGenres.saveGenre();

        /*
        DataFromSpiderman fromSpiderman = new DataFromSpiderman();

        for (JsonObject jsonObject : fromSpiderman.getJsonArray().getValuesAs(JsonObject.class)) {
            System.out.println(jsonObject.getString("name"));
            System.out.println(jsonObject.getString("_ID"));
        }

        System.out.println(fromSpiderman.getJsonArray());
        */
    }

}
