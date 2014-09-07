package at.cinephilia.web.model;

import javax.persistence.*;

@Entity
@Table(name = "genre_assos")
public class GenreAsso {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "_ID", unique = true)
    private String _ID;

    @Column(name = "genre_ID")
    private String genre_ID;

    @Column(name = "movie_ID")
    private String movie_ID;

    public GenreAsso() {

    }

    public GenreAsso(String _ID, String movie_ID, String genre_ID) {
        this._ID = _ID;
        this.movie_ID = movie_ID;
        this.genre_ID = genre_ID;
    }

    public String get_ID() {
        return _ID;
    }

    public void set_ID(String _ID) {
        this._ID = _ID;
    }

    public String getGenre_ID() {
        return genre_ID;
    }

    public void setGenre_ID(String genre_ID) {
        this.genre_ID = genre_ID;
    }

    public String getMovie_ID() {
        return movie_ID;
    }

    public void setMovie_ID(String movie_ID) {
        this.movie_ID = movie_ID;
    }
}
