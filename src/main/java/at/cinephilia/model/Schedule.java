package at.cinephilia.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jens on 29.08.14.
 */
@Entity
@Table(name = "schedules", uniqueConstraints = {@UniqueConstraint(columnNames = "_id")})
public class Schedule implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "_id", unique = true)
    private String _id;

    @Column(name = "unixtime")
    private Integer unixtime;

    @Column(name = "dat")
    private String dat;

    @Column(name = "tim")
    private String tim;

    @Column(name = "theater_id")
    private String theater_id;

    @Column(name = "movie_id")
    private String movie_id;

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

    public Schedule(String _id, Integer unixtime, String dat, String tim, String theater_id, String movie_id, String typename, String version_1, String version_2, String version_3, String datetime) {
        this._id = _id;
        this.unixtime = unixtime;
        this.dat = dat;
        this.tim = tim;
        this.theater_id = theater_id;
        this.movie_id = movie_id;
        this.typename = typename;
        this.version_1 = version_1;
        this.version_2 = version_2;
        this.version_3 = version_3;
        this.datetime = datetime;
    }

    public Schedule(String _id, String movie_id, String theater_id) {
        this._id = _id;
        this.movie_id = movie_id;
        this.theater_id = theater_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String get_id() {
        return _id;
    }

    public String getTheater_id() {
        return theater_id;
    }

    public String getMovie_id() {
        return movie_id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Integer getUnixtime() {
        return unixtime;
    }

    public void setUnixtime(Integer unixtime) {
        this.unixtime = unixtime;
    }

    public String getDat() {
        return dat;
    }

    public void setDat(String dat) {
        this.dat = dat;
    }

    public String getTim() {
        return tim;
    }

    public void setTim(String tim) {
        this.tim = tim;
    }

    public void setTheater_id(String theater_id) {
        this.theater_id = theater_id;
    }

    public void setMovie_id(String movie_id) {
        this.movie_id = movie_id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getVersion_1() {
        return version_1;
    }

    public void setVersion_1(String version_1) {
        this.version_1 = version_1;
    }

    public String getVersion_2() {
        return version_2;
    }

    public void setVersion_2(String version_2) {
        this.version_2 = version_2;
    }

    public String getVersion_3() {
        return version_3;
    }

    public void setVersion_3(String version_3) {
        this.version_3 = version_3;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
