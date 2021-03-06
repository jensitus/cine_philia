package at.cinephilia.web.rest;

import at.cinephilia.model.Genre;
import at.cinephilia.model.Movie;
import at.cinephilia.model.Schedule;
import at.cinephilia.model.Theater;
import at.cinephilia.web.movie.service.MovieService;
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

    @ResponseBody
    @RequestMapping(value = "/{movieId}", method = RequestMethod.GET)
    public ResponseEntity<List> getMovie(@PathVariable String movieId) throws IOException {
        Long movieIdLong = Long.parseLong(movieId);
        System.out.println("??????????????????????????????");
        System.out.println();
        logger.debug("movieIdLong: {} ", movieIdLong);
        Movie ret = this.movieService.loadMovie(movieIdLong);
        String movie_id = ret.get_id();
        List movieSchedulesTheaters = movieService.getMovieTheaterViaSchedule(movie_id);

        List<Genre> genreList = new ArrayList<>();

        List<Genre> genres = movieService.loadGenreByMovie(movieIdLong);
        for (Genre genre : genres) {
            String name = genre.getName();
            System.out.println("++++++++++++++++++++++++++++++++");
            System.out.println();
            System.out.println(genre.getName());
            System.out.println(genre.get_id());
            System.out.println();
            System.out.println("++++++++++++++++++++++++++++++++");
            genreList.add(genre);
        }
        System.out.println();
        System.out.println("++++++++++++++++++++++++++++++++");
        logger.debug("genreList: {} ", genreList);
        System.out.println();
        System.out.println("++++++++++++++++++++++++++++++++");

        Map<String, Map<String, Map<String, List<Object>>>> singleMovieMap = new HashMap<String, Map<String, Map<String, List<Object>>>>();
        Map<String, Map<String, List<Object>>> datumMap = new HashMap<String, Map<String, List<Object>>>();
        Map<String, List<Object>> theaterMap = new HashMap<String, List<Object>>();
        Map<String, Map> movieObjectMap;
        List<Object> scheduleList = new ArrayList<Object>();
        String movieTitle = null;
        String datum = null;
        String theater_name = null;
        Movie movie = null;
        List<Movie> mov = new ArrayList<>();

        Iterator mtvs = movieSchedulesTheaters.iterator();
        while ( mtvs.hasNext()) {
            Object[] result = (Object[]) mtvs.next();
            movie = (Movie) result[0];
            Schedule schedule = (Schedule) result[1];
            Theater theater = (Theater) result[2];
            datum = schedule.getDat();
            movieTitle = movie.getTitle();
            theater_name = theater.getName();



            theaterMap = datumMap.get(datum);
            if (theaterMap == null) {
                theaterMap = new HashMap<String, List<Object>>();
            }
            scheduleList = theaterMap.get(theater_name);
            if (scheduleList == null) {
                scheduleList = new ArrayList<Object>();
            }

            scheduleList.add(schedule);

            theaterMap.put(theater_name, scheduleList);
            datumMap.put(datum, theaterMap);

        }

        Map<String, Movie> movMap = new HashMap<>();
        movMap.put("theMovie", movie);

        singleMovieMap.put(movieTitle, datumMap);
        ResponseEntity entity;
        List lastList = new ArrayList();
        lastList.add(movie);
        lastList.add(genreList);
        lastList.add(singleMovieMap);

        System.out.println("#################################");
        System.out.println();
        System.out.println();
        logger.debug("singleMovieMap: {} ", singleMovieMap);
        logger.debug("lastList : {} ", lastList);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("#################################");

        return new ResponseEntity(lastList, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/movielist", method = RequestMethod.GET)
    public ResponseEntity<List<Movie>> getMovies() {
        List<Movie> movies = new ArrayList<>();
        movies = movieService.getMovies();
        return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
    }

}
