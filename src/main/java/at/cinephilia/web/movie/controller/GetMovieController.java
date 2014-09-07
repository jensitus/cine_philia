package at.cinephilia.web.movie.controller;

import at.cinephilia.data.DataFromSpiderman;
import at.cinephilia.web.model.Movie;
import at.cinephilia.web.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/movies")
public class GetMovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ModelAndView getMovies() throws IOException {
        ModelAndView modelAndView = new ModelAndView("movie");
        List<Movie> movie_id_list = getMovieId();
        List<Movie> movies = movieListFromJson(movie_id_list); // movieService.getMovies();
        modelAndView.addObject("movies", movies);
        return modelAndView;
    }

    private List<Movie> getMovieId() {
        List<Movie> movie_id_list;
        movie_id_list = movieService.getMovies();
        return movie_id_list;
    }

    private List<Movie> movieListFromJson(List<Movie> movie_id_list) throws IOException {
        List<Movie> movie_ids = movie_id_list;
        List<Movie> movies = new ArrayList<>();
        Movie movie;
        String title;
        String _ID;
        for (JsonObject jsonObject : getJsonArray().getValuesAs(JsonObject.class)) {
            title = jsonObject.getString("title");
            _ID = jsonObject.getString("_ID");
            if (movie_ids.contains(_ID)) {

            } else {
                System.out.println(title);
                movie = new Movie(title, _ID);
                System.out.println(movie);
                movieService.addMovie(movie);
                movies.add(movie);
            }
        }
        return movies;
    }

    private JsonArray getJsonArray() throws IOException {
        JsonArray jsonArray = new DataFromSpiderman().getJsonObject().getJsonArray("movies");
        return jsonArray;
    }

}
