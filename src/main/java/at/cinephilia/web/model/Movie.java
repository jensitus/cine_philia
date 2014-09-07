package at.cinephilia.web.model;

import javax.persistence.*;

/**
 * Created by jens on 18.08.14.
 */

@Entity
@Table(name = "movies", uniqueConstraints = {@UniqueConstraint(columnNames = "_ID")})
public class Movie {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "_ID", unique = true)
    private String _ID;

    @Column(name = "runtime")
    private short runtime;

    @Column(name = "country")
    private String country;

    @Column(name = "year")
    private short year;

    @Column(name = "originaltitle")
    private String originaltitle;

    @Column(name = "typename")
    private String typename;

    @Column(name = "shortdescription")
    private String shortdescription;

    @Column(name = "imageurl")
    private String imageurl;

    @Column(name = "upcoming", columnDefinition = "boolean default true")
    private Boolean upcoming;

    @Column(name = "tmdb_id")
    private short tmdb_id;

    @Column(name = "genres")
    private String[] genres;

    @Column(name = "director")
    private String[] director;

    @Column(name = "actors")
    private String[] actors;

  public Movie() {
  }

  public Movie(String title, String _ID) {
        this.title = title;
        this._ID = _ID;
    }

    public String getTitle() {
        return title;
    }
}
