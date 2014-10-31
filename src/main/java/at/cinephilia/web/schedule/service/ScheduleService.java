package at.cinephilia.web.schedule.service;

import at.cinephilia.model.Schedule;

import java.util.List;

/**
 * Created by jens on 29.08.14.
 */
public interface ScheduleService {

    public void addSchedule(Schedule schedule);
    public List<Schedule> getSchedulesID();

}
