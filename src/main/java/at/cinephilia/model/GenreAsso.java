package at.cinephilia.model;

import javax.persistence.*;

@Entity
@Table(name = "genre_assos")
public class GenreAsso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "_id", unique = true)
    private String _id;

    @Column(name = "genre_id")
    private String genre_id;

    @Column(name = "movie_id")
    private String movie_id;

    public GenreAsso() {

    }

    public GenreAsso(String _id, String movie_id, String genre_id) {
        this._id = _id;
        this.movie_id = movie_id;
        this.genre_id = genre_id;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(String genre_id) {
        this.genre_id = genre_id;
    }

    public String getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(String movie_id) {
        this.movie_id = movie_id;
    }
}
