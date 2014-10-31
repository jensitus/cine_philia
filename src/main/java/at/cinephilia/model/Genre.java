package at.cinephilia.model;

import javax.persistence.*;

/**
 * Created by jens on 27.07.14.
 */

@Entity
@Table(name = "genres") //, uniqueConstraints = {@UniqueConstraint(columnNames = "id"), @UniqueConstraint(columnNames = "name"), @UniqueConstraint(columnNames = "_id")})
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private short id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "_id", unique = true)
    private String _id;

    @Column(name = "number")
    private String number;

    public Genre(){

    }

    public Genre(String name, String _id) {
        this.name = name;
        this._id = _id;
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

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
