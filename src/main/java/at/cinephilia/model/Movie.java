package at.cinephilia.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jens on 18.08.14.
 */

@Entity
@Table(name = "movies", uniqueConstraints = {@UniqueConstraint(columnNames = "_id")})
public class Movie implements Serializable, Comparable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "_id", unique = true)
    private String _id;

    @Column(name = "runtime")
    private int runtime;

    @Column(name = "country")
    private String country;

    @Column(name = "year")
    private int year;

    @Column(name = "originaltitle")
    private String originaltitle;

    @Column(name = "typename")
    private String typename;

    @Column(name = "shortdescription", columnDefinition = "text", nullable = true)
    private String shortdescription;

    @Column(name = "imageurl")
    private String imageurl;

    @Column(name = "upcoming", columnDefinition = "boolean default true")
    private Boolean upcoming;

    @Column(name = "tmdb_id")
    private int tmdb_id;

    public Movie() {
    }

    public Movie(String title, String _id, int runtime, String country, int year, String originaltitle, String typename, String shortdescription, String imageurl, Boolean upcoming) {
        this.title = title;
        this._id = _id;
        this.runtime = runtime;
        this.country = country;
        this.year = year;
        this.originaltitle = originaltitle;
        this.typename = typename;
        this.shortdescription = shortdescription;
        this.imageurl = imageurl;
        this.upcoming = upcoming;
    }

    public Movie(long id, String title, String _id) {
        this.id = id;
        this.title = title;
        this._id = _id;
    }

    public Movie(String title, String _id) {
        this.title = title;
        this._id = _id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(short runtime) {
        this.runtime = runtime;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public String getOriginaltitle() {
        return originaltitle;
    }

    public void setOriginaltitle(String originaltitle) {
        this.originaltitle = originaltitle;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getShortdescription() {
        return shortdescription;
    }

    public void setShortdescription(String shortdescription) {
        this.shortdescription = shortdescription;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public Boolean getUpcoming() {
        return upcoming;
    }

    public void setUpcoming(Boolean upcoming) {
        this.upcoming = upcoming;
    }

    public int getTmdb_id() {
        return tmdb_id;
    }

    public void setTmdb_id(short tmdb_id) {
        this.tmdb_id = tmdb_id;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }



}
