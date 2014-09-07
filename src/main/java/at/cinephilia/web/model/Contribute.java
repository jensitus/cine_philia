package at.cinephilia.web.model;

import javax.persistence.*;

/**
 * Created by jens on 31.08.14.
 */

@Entity
@Table(name = "contributes")
public class Contribute {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "_ID", unique = true)
    private String _ID;

    @Column(name = "participant_ID")
    private String participant_ID;

    @Column(name = "movie_ID")
    private String movie_ID;

    @Column(name = "diractor")
    private String diractor;

    @Override
    public int hashCode() {
        int result = participant_ID != null ? participant_ID.hashCode() : 0;
        result = 31 * result + (movie_ID != null ? movie_ID.hashCode() : 0);
        result = 31 * result + (diractor != null ? diractor.hashCode() : 0);
        return result;
    }

    public Contribute() {
    }



    public Contribute(String _ID, String participant_ID, String movie_ID, String diractor) {
        this._ID = _ID;
        this.participant_ID = participant_ID;
        this.movie_ID = movie_ID;
        this.diractor = diractor;
    }

    public String get_ID() {
        return _ID;
    }

    public String getParticipant_ID() {
        return participant_ID;
    }

    public String getMovie_ID() {
        return movie_ID;
    }

    public void set_ID(String _ID) {
        this._ID = _ID;
    }

    public void setParticipant_ID(String participant_ID) {
        this.participant_ID = participant_ID;
    }

    public void setMovie_ID(String movie_ID) {
        this.movie_ID = movie_ID;
    }

    public void setDiractor(String diractor) {
        this.diractor = diractor;
    }
}
