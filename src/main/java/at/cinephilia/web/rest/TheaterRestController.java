package at.cinephilia.web.rest;

import at.cinephilia.model.Movie;
import at.cinephilia.model.Schedule;
import at.cinephilia.model.Theater;
import at.cinephilia.web.theater.service.TheaterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@Transactional
@RequestMapping(value = "/rest/theaters/")
public class TheaterRestController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TheaterService theaterService;

    @ResponseBody
    @RequestMapping(value = "/{theaterId}", method = RequestMethod.GET)
    public ResponseEntity getTheaterMovies(@PathVariable String theaterId) {
        int id = Integer.parseInt(theaterId);
        List theaterMoviesList = theaterService.loadTheaterById(id);

        Map<String, Map> singleTheaterMap = new HashMap();
        Map<String, Map> datumMap = new HashMap();
        Map<String, List> movieMap = new HashMap<>();
        List scheduleList;
        String theater_name = null;
        String movie_title = null;
        String datum;

        Iterator tml = theaterMoviesList.iterator();
        while (tml.hasNext()) {
            Object[] result = (Object[]) tml.next();
            Theater theater = (Theater) result[0];
            Schedule schedule = (Schedule) result[1];
            Movie movie = (Movie) result[2];
            theater_name = theater.getName();
            movie_title = movie.getTitle();
            datum = schedule.getDat();

            movieMap = datumMap.get(datum);
            if (movieMap == null) {
                movieMap = new HashMap<>();
            }
            scheduleList = movieMap.get(movie_title);
            if (scheduleList == null) {
                scheduleList = new ArrayList();
            }
            scheduleList.add(schedule);
            movieMap.put(movie_title, scheduleList);
            datumMap.put(datum, movieMap);
        }
        singleTheaterMap.put(theater_name, datumMap);

        return new ResponseEntity(singleTheaterMap, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/theater_list", method = RequestMethod.GET)
    public ResponseEntity get_theater_list() {
        return new ResponseEntity(theaterService.get_theaters(), HttpStatus.OK);
    }


}
