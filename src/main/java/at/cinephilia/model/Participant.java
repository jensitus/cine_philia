package at.cinephilia.model;

import javax.persistence.*;

@Entity
@Table(name = "participants")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "_id", unique = true)
    private String _id;

    @Column(name = "diract")
    private String diract;

    public Participant() {
    }

    public Participant(String name, String _id) {
        this.name = name;
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public String get_id() {
        return _id;
    }
}
