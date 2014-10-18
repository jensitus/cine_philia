package at.cinephilia.web.rest;

import at.cinephilia.web.model.Movie;
import at.cinephilia.web.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * User: fkleedorfer
 * Date: 07.09.14
 */

@RestController
@RequestMapping(value = "/rest/movies")
public class MovieRestController {

    @Autowired
    private MovieService movieService;

    @ResponseBody
    @RequestMapping(value = "/{movieId}", method = RequestMethod.GET)
    public ResponseEntity getMovie(@PathVariable String movieId) throws IOException {
        Long movieIdLong = Long.parseLong(movieId);
        Movie ret = this.movieService.loadMovie(movieIdLong);
        if (ret == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(ret, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/herrgott", method = RequestMethod.GET)
    public ResponseEntity showThatMist() {
        String title = "himmel und auch nicht";
        return new ResponseEntity(title, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/movielist", method = RequestMethod.GET)
    public ResponseEntity getMovies() {
        return new ResponseEntity(movieService.getMovies(), HttpStatus.OK);
    }

}
