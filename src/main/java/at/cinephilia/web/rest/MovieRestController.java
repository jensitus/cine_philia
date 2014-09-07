package at.cinephilia.web.rest;

import at.cinephilia.web.model.Movie;
import at.cinephilia.web.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * User: fkleedorfer
 * Date: 07.09.14
 */
@Controller
@RequestMapping(value = "/rest/movies")
public class MovieRestController
{
  @Autowired
  private MovieService movieService;



  @ResponseBody
 @RequestMapping(
   value = "/{movieId}",
   method = RequestMethod.GET
 )
 public ResponseEntity getMovies(@PathVariable String movieId) throws IOException {
  Long movieIdLong = Long.parseLong(movieId);
  Movie ret = this.movieService.loadMovie(movieIdLong);
  if (ret == null){
    return new ResponseEntity(HttpStatus.NOT_FOUND);
  }
  return new ResponseEntity(ret, HttpStatus.OK);
}

}
