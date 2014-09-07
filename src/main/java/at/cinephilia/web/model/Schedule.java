package at.cinephilia.web.model;

import javax.persistence.*;

/**
 * Created by jens on 29.08.14.
 */
@Entity
@Table(name = "schedules")
public class Schedule {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "_ID", unique = true)
    private String _ID;

    @Column(name = "unixtime")
    private Integer unixtime;

    @Column(name = "dat")
    private String dat;

    @Column(name = "tim")
    private String tim;

    @Column(name = "theater_ID")
    private String theater_ID;

    @Column(name = "movie_ID")
    private String movie_ID;

    @Column(name = "typename")
    private String typename;

    @Column(name = "version_1")
    private String version_1;

    @Column(name = "version_2")
    private String version_2;

    @Column(name = "version_3")
    private String version_3;

    @Column(name = "datetime")
    private String datetime;

    public Schedule(){};

    public Schedule(String _ID, Integer unixtime, String dat, String tim, String theater_ID, String movie_ID, String typename, String version_1, String version_2, String version_3, String datetime) {
        this._ID = _ID;
        this.unixtime = unixtime;
        this.dat = dat;
        this.tim = tim;
        this.theater_ID = theater_ID;
        this.movie_ID = movie_ID;
        this.typename = typename;
        this.version_1 = version_1;
        this.version_2 = version_2;
        this.version_3 = version_3;
        this.datetime = datetime;
    }

    public Schedule(String _ID, String movie_ID, String theater_ID) {
        this._ID = _ID;
        this.movie_ID = movie_ID;
        this.theater_ID = theater_ID;
    }

    public String get_ID() {
        return _ID;
    }

    public String getTheater_ID() {
        return theater_ID;
    }

    public String getMovie_ID() {
        return movie_ID;
    }
}
