package at.cinephilia.web.genre.model;

import javax.persistence.*;

/**
 * Created by jens on 27.07.14.
 */

@Entity
@Table(name = "genres") //, uniqueConstraints = {@UniqueConstraint(columnNames = "id"), @UniqueConstraint(columnNames = "name"), @UniqueConstraint(columnNames = "_ID")})
public class Genre {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private short id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "_ID", unique = true)
    private String _ID;

    public Genre(){

    }

    public Genre(String name, String _ID) {
        this.name = name;
        this._ID = _ID;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String get_ID() {
        return _ID;
    }

    public void set_ID(String _ID) {
        this._ID = _ID;
    }
}
