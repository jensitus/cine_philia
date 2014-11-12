package at.cinephilia.web.theater.service;

import at.cinephilia.model.Theater;
import at.cinephilia.web.theater.dao.TheaterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by jens on 30.08.14.
 */

@Service
@Transactional
public class TheaterServiceImpl implements TheaterService {

    @Autowired
    private TheaterDao theaterDao;

    @Override
    public void addTheater(Theater theater) {
        theaterDao.addTheater(theater);
    }

    @Override
    public List<Theater> theater_id_list() {
        return theaterDao.theater_id_list();
    }

    @Override
    public Theater getTheaterByTheater_Id(String theater_id) {
        return theaterDao.getTheaterByTheater_Id(theater_id);
    }

    @Override
    public List<Theater> getTheaterViaSchedule(String movie_id) {
        return theaterDao.getTheaterViaSchedule(movie_id);
    }

    @Override
    public List loadTheaterById(int id) {
        return theaterDao.loadTheaterById(id);
    }

    @Override
    public List<Theater> get_theaters() {
        return theaterDao.get_theaters();
    }
}
