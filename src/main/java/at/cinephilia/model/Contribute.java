package at.cinephilia.model;

import javax.persistence.*;

/**
 * Created by jens on 31.08.14.
 */

@Entity
@Table(name = "contributes")
public class Contribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "_id", unique = true)
    private String _id;

    @Column(name = "participant_id")
    private String participant_id;

    @Column(name = "movie_id")
    private String movie_id;

    @Column(name = "diractor")
    private String diractor;

    @Override
    public int hashCode() {
        int result = participant_id != null ? participant_id.hashCode() : 0;
        result = 31 * result + (movie_id != null ? movie_id.hashCode() : 0);
        result = 31 * result + (diractor != null ? diractor.hashCode() : 0);
        return result;
    }

    public Contribute() {
    }



    public Contribute(String _id, String participant_id, String movie_id, String diractor) {
        this._id = _id;
        this.participant_id = participant_id;
        this.movie_id = movie_id;
        this.diractor = diractor;
    }

    public String get_id() {
        return _id;
    }

    public String getParticipant_id() {
        return participant_id;
    }

    public String getMovie_id() {
        return movie_id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setParticipant_id(String participant_id) {
        this.participant_id = participant_id;
    }

    public void setMovie_id(String movie_id) {
        this.movie_id = movie_id;
    }

    public void setDiractor(String diractor) {
        this.diractor = diractor;
    }
}
