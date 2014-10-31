package at.cinephilia.web.rest;

import at.cinephilia.model.Movie;
import at.cinephilia.model.Schedule;
import at.cinephilia.model.Theater;
import at.cinephilia.web.movie.service.MovieService;
import at.cinephilia.web.theater.service.TheaterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

/**
 * User: fkleedorfer
 * Date: 07.09.14
 */

@RestController
@Transactional
@RequestMapping(value = "/rest/movies")
public class MovieRestController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MovieService movieService;

    @Autowired
    private TheaterService theaterService;

    @ResponseBody
    @RequestMapping(value = "/{movieId}", method = RequestMethod.GET)
    public ResponseEntity<Map> getMovie(@PathVariable String movieId) throws IOException {
        Long movieIdLong = Long.parseLong(movieId);
        Movie ret = this.movieService.loadMovie(movieIdLong);
        String movie_id = ret.get_id();
        List movieSchedulesTheaters = movieService.getMovieTheaterViaSchedule(movie_id);
        logger.debug("himmel: {}", movieSchedulesTheaters);

        Map<String, Map> singleMovieMap = new HashMap<>();
        Map<String, List> innerMap = new HashMap<>();

        String movieTitle = null;
        String datum = null;

        Map<String, List> timeMap = new HashMap<>();

        List list = new ArrayList();
        List tupel = new ArrayList();

        Map<String, List> schedulesByDate = new HashMap<String, List>();

        Iterator mtvs = movieSchedulesTheaters.iterator();
        while ( mtvs.hasNext()) {
            Object[] result = (Object[]) mtvs.next();
            Movie movie = (Movie) result[0];
            Schedule schedule = (Schedule) result[1];
            Theater theater = (Theater) result[2];
            datum = schedule.getDat();
            movieTitle = movie.getTitle();

            List schedules = schedulesByDate.get(datum);
            if (schedules == null) {
                schedules = new ArrayList<Schedule>();
            }
            schedules.add(schedule);
            schedules.add(theater);
            List blocScheduleTheater = new ArrayList();
            blocScheduleTheater.add(schedule);
            blocScheduleTheater.add(theater);
            schedulesByDate.put(datum, schedules);
            singleMovieMap.put(movieTitle, schedulesByDate);
/*
//            if (schedule.getDat() == datum) {
//                list.add(schedule);
//                list.add(schedule);
//                innerMap.put(datum, list);
//                outerMap.put(movieTitle, innerMap);
//            }
//            tupel.add(movie);
//            tupel.add(schedule);
//            tupel.add(theater);




            logger.debug("datum {} movietitle {}", datum, movieTitle);
        }
        //list.add(tupel);

        logger.debug("{}", "mapmapmapmapmapmapmapmapmapmapmapmapmapmapmap");
        logger.debug("innerMap: ", innerMap);
        logger.debug("outerMap: ", outerMap);

        for (Object outerList : movieSchedulesTheaters) {

            logger.debug("{}", "###########################");
            logger.debug("Object outerList: {}", outerList );

//            for (Object o : outerList) {
//                if (o.getClass() == Movie.class) {
//                    Movie m = (Movie) o;
//                    movieTitle = m.getTitle();
//                } else if (o.getClass() == Schedule.class) {
//                    Schedule s = (Schedule) o;
//                    datum = s.getDat();
//                }
               //}
               */
        }


        if (ret == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Map>(singleMovieMap, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/movielist", method = RequestMethod.GET)
    public ResponseEntity<List<Movie>> getMovies() {
        List<Movie> movies = new ArrayList<>();
        movies = movieService.getMovies();
        return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
    }

}
