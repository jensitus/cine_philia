package at.cinephilia.web.schedule.controller;

import at.cinephilia.data.DataFromSpiderman;
import at.cinephilia.web.model.Schedule;
import at.cinephilia.web.schedule.service.ScheduleService;
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
            if (scheduleID.contains(_ID)) {

            } else {
                System.out.println(movie_ID);
                System.out.println(theater_ID);
                System.out.println(_ID);
                System.out.println("+++++++++++++++");
                schedule = new Schedule(_ID, unixtime, dat, tim, theater_ID, movie_ID, typename, version_1, version_2, version_3, datetime);
                scheduleService.addSchedule(schedule);
                schedules.add(schedule);
            }
        }
        return schedules;
    }

    private JsonArray getJsonArray() throws IOException {
        JsonArray jsonArray = new DataFromSpiderman().getJsonObject().getJsonArray("schedule");
        return jsonArray;
    }

}
