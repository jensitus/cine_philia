package at.cinephilia.web.schedule.controller;

import at.cinephilia.data.DataFromSpiderman;
import at.cinephilia.model.Movie;
import at.cinephilia.model.Schedule;
import at.cinephilia.model.Theater;
import at.cinephilia.web.common.service.CommonService;
import at.cinephilia.web.movie.service.MovieService;
import at.cinephilia.web.schedule.service.ScheduleService;
import at.cinephilia.web.theater.service.TheaterService;
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
 * Created by jens on 29.08.14.
 */

@Controller
@RequestMapping(value = "/schedules")
public class GetScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private TheaterService theaterService;

    @Autowired
    private CommonService commonService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ModelAndView getSchedules() throws IOException {
        ModelAndView modelAndView = new ModelAndView("schedule");
        List<Schedule> schedulesId = getSchedulesId();
        List<Schedule> schedules = scheduleListFromJson(schedulesId);
        modelAndView.addObject("schedules", schedules);
        return modelAndView;
    }

    private List<Schedule> getSchedulesId() {
        List<Schedule> scheduleId;
        scheduleId = scheduleService.getSchedulesID();
        System.out.println(scheduleId);
        return scheduleId;
    }

    private List<Schedule> scheduleListFromJson(List<Schedule> schedulesId) throws IOException {
        List<Schedule> scheduleID = schedulesId;
        List<Schedule> schedules = new ArrayList<>();
        Schedule schedule;
        String _ID;
        String movie_ID;
        String theater_ID;
        String typename;
        String version_1;
        String version_2;
        String version_3;
        String datetime;
        Integer unixtime;
        String dat;
        String tim;

        for (JsonObject jsonObject : getJsonArray().getValuesAs(JsonObject.class)) {
            _ID = jsonObject.getString("_ID");
            movie_ID = jsonObject.getString("movie_ID");
            theater_ID = jsonObject.getString("theater_ID");
            typename = jsonObject.getString("typename");
            version_1 = jsonObject.getString("version_1");
            version_2 = jsonObject.getString("version_2");
            version_3 = jsonObject.getString("version_3");
            datetime = jsonObject.getString("datetime");
            unixtime = jsonObject.getInt("unixtime");
            dat = jsonObject.getString("dat");
            tim = jsonObject.getString("tim");

            System.out.println(movie_ID);
/*
            String theater_id = null;
            int theaters_id = 0;

            String movie_id = null;
            long movies_id = 0;

            Movie movie = getMovieByMovie_Id(movie_ID);
            Theater theater = getTheaterByTheater_Id(theater_ID);

            if (theater == null) {
                System.out.println("// do nothing");
            } else {
                System.out.println("++ theater: ***:");
                System.out.println(theater.getName());
                theater_id = theater.get_id();
                theaters_id = theater.getId();
            }

            System.out.println("movie:");
            if (movie != null) {
                System.out.println(movie);
                System.out.println(movie.get_id());
                System.out.println(movie.getId());
                movie_id = movie.get_id();
                movies_id = movie.getId();
            }
            System.out.println("--------------------");


            MovieTheater movieTheater = new MovieTheater(movie_id, theater_id, movies_id, theaters_id);
*/

            if (scheduleID.contains(_ID)) {

            } else {
                System.out.println(movie_ID);
                System.out.println(theater_ID);
                System.out.println(_ID);
                System.out.println("+++++++++++++++");
                schedule = new Schedule(_ID, unixtime, dat, tim, theater_ID, movie_ID, typename, version_1, version_2, version_3, datetime);
                scheduleService.addSchedule(schedule);
                schedules.add(schedule);
//                if (movieTheater.getMovie_id() != null) {
//                    commonService.addMovieTheater(movieTheater);
//                }
            }
        }
        return schedules;
    }

    private Movie getMovieByMovie_Id(String movie_id) {
        return movieService.loadMovieByMovie_Id(movie_id);
    }

    private Theater getTheaterByTheater_Id(String theater_id) {
        return theaterService.getTheaterByTheater_Id(theater_id);
    }

    private JsonArray getJsonArray() throws IOException {
        JsonArray jsonArray = new DataFromSpiderman().getJsonObject().getJsonArray("schedule");
        return jsonArray;
    }

}
