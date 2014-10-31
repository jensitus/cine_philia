package at.cinephilia.web.theater.controller;

import at.cinephilia.data.DataFromSpiderman;
import at.cinephilia.model.Theater;
import at.cinephilia.web.theater.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jens on 30.08.14.
 */

@Controller
@RequestMapping(value = "/theaters")
public class GetTheaterController {

    @Autowired
    private TheaterService theaterService;

    @RequestMapping(value = "/get")
    public ModelAndView getTheaters() throws IOException {
        ModelAndView modelAndView = new ModelAndView("theater");
        List<Theater> theater_ids = theater_id_list();
        List<Theater> theaters = getTheatersFromJson(theater_ids);
        modelAndView.addObject("theaters", theaters);
        return modelAndView;
    }

    private List<Theater> theater_id_list() {
        List<Theater> theater_ids = theaterService.theater_id_list();
        return theater_ids;
    }

    private List<Theater> getTheatersFromJson(List<Theater> theater_ids) throws IOException {
        List<Theater> theaters_ids = theater_ids;
        List<Theater> theaters = new ArrayList<>();
        Theater theater;
        String name;
        String _ID;
        for (JsonObject jsonObject : getJsonArray().getValuesAs(JsonObject.class)) {
            name = jsonObject.getString("name");
            _ID = jsonObject.getString("_ID");
            if (theater_ids.contains(_ID)) {

            } else {
                System.out.println(name);
                theater = new Theater(_ID, name);
                theaterService.addTheater(theater);
                theaters.add(theater);
            }
        }
        return theaters;
    }

    private JsonArray getJsonArray() throws IOException {
        JsonArray jsonArray = new DataFromSpiderman().getJsonObject().getJsonArray("theaters");
        return jsonArray;
    }

}
