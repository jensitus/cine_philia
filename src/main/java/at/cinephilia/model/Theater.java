package at.cinephilia.model;

import javax.persistence.*;

/**
 * Created by jens on 29.08.14.
 */

@Entity
@Table(name = "theaters", uniqueConstraints = {@UniqueConstraint(columnNames = "_id")})
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "_id", unique = true)
    private String _id;

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

//    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "theaters")
//    private Set<Movie> movies = new HashSet<>();
//
//    public Set<Movie> getMovies() {
//        return movies;
//    }
//
//    public void setMovies(Set<Movie> movies) {
//        this.movies = movies;
//    }

    public Theater() {
    }

    public Theater(String _id, String name, String typename, String address, String telephone, String url) {
        this._id = _id;
        this.name = name;
        this.typename = typename;
        this.address = address;
        this.telephone = telephone;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Theater(String _id, String name) {
        this._id = _id;
        this.name = name;
    }

    public String get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
