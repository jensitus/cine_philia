package at.cinephilia.web.theater.service;

import at.cinephilia.web.model.Theater;

import java.util.List;

/**
 * Created by jens on 30.08.14.
 */


public interface TheaterService {

    public void addTheater(Theater theater);
    public List<Theater> theater_id_list();

}
