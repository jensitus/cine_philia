package at.cinephilia.web.schedule.dao;

import at.cinephilia.model.Schedule;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jens on 29.08.14.
 */

@Repository
public class ScheduleDaoImpl implements ScheduleDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addSchedule(Schedule schedule) {
        getSession().persist(schedule);
    }

    @Override
    public List<Schedule> getSchedulesID() {
        return getSession().createQuery("select _id from Schedule").list();
    }
}
