package at.cinephilia.web.model;

import javax.persistence.*;

/**
 * Created by jens on 29.08.14.
 */

@Entity
@Table(name = "theaters")
public class Theater {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "_ID", unique = true)
    private String _ID;

    @Column(name = "name")
    private String name;

    @Column(name = "typename")
    private String typename;

    @Column(name = "address")
    private String address;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "url")
    private String url;

    public Theater() {
    }

    public Theater(String _ID, String name, String typename, String address, String telephone, String url) {
        this._ID = _ID;
        this.name = name;
        this.typename = typename;
        this.address = address;
        this.telephone = telephone;
        this.url = url;
    }


    public Theater(String _ID, String name) {
        this._ID = _ID;
        this.name = name;
    }

    public String get_ID() {
        return _ID;
    }

    public String getName() {
        return name;
    }
}
