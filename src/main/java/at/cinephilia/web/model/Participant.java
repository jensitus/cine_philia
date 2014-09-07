package at.cinephilia.web.model;

import javax.persistence.*;

@Entity
@Table(name = "participants")
public class Participant {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "_ID", unique = true)
    private String _ID;

    @Column(name = "diract")
    private String diract;

    public Participant() {
    }

    public Participant(String name, String _ID) {
        this.name = name;
        this._ID = _ID;
    }

    public String getName() {
        return name;
    }

    public String get_ID() {
        return _ID;
    }
}
