package at.cinephilia.data;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by jens on 27.07.14.
 */

public class DataFromSpiderman {

    public JsonObject getJsonObject() throws IOException {
        JsonObject jsonObject = getJsonReader().readObject();
        return jsonObject;
    }

    private JsonReader getJsonReader() throws IOException {
        JsonReader jsonReader = Json.createReader(getStream());
        return jsonReader;
    }

    private InputStream getStream() throws IOException {
        InputStream is = getUrl().openStream();
        return is;
    }

    private URL getUrl() throws MalformedURLException {
        URL url = new URL("http://spider-man-725.herokuapp.com/json/index.json");
        return url;
    }



}
