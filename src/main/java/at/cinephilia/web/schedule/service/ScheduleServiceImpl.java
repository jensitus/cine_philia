package at.cinephilia.web.schedule.service;

import at.cinephilia.model.Schedule;
import at.cinephilia.web.schedule.dao.ScheduleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jens on 29.08.14.
 */
@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleDao scheduleDao;

    @Override
    public void addSchedule(Schedule schedule) {
        scheduleDao.addSchedule(schedule);
    }

    @Override
    public List<Schedule> getSchedulesID() {
        return scheduleDao.getSchedulesID();
    }
}
