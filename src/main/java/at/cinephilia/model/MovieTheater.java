package at.cinephilia.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by jens on 26.10.14.
 */

//@Entity
//@Table(name = "movie_theaters")
public class MovieTheater implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "movie_id")
    private String movie_id;

    @Column(name = "theater_id")
    private String theater_id;

    @Column(name = "movies_id")
    private long movies_id;

    @Column(name = "theaters_id")
    private int theaters_id;

    public MovieTheater() {
    }

    public MovieTheater(String movie_id, String theater_id, long movies_id, int theaters_id) {
        this.movie_id = movie_id;
        this.theater_id = theater_id;
        this.movies_id = movies_id;
        this.theaters_id = theaters_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(String movie_id) {
        this.movie_id = movie_id;
    }

    public String getTheater_id() {
        return theater_id;
    }

    public void setTheater_id(String theater_id) {
        this.theater_id = theater_id;
    }

    public long getMovies_id() {
        return movies_id;
    }

    public void setMovies_id(long movies_id) {
        this.movies_id = movies_id;
    }

    public int getTheaters_id() {
        return theaters_id;
    }

    public void setTheaters_id(int theaters_id) {
        this.theaters_id = theaters_id;
    }

}
