package at.cinephilia.web.theater.dao;

import at.cinephilia.model.Theater;

import java.util.List;

/**
 * Created by jens on 30.08.14.
 */
public interface TheaterDao {

    public void addTheater(Theater theater);
    public List<Theater> theater_id_list();

    List loadTheaterById(int id);

    List<Theater> get_theaters();

    List<Theater> getTheaterViaSchedule(String movie_id);

    Theater getTheaterByTheater_Id(String theater_id);


}
