package eus.ehu.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Pilot {
    @Id
    private String name;
    private String nationality;
    private int points;

    @ManyToOne
    private Team team;


    public Pilot(String name, String nat, int pts) {
        this.name = name;
        this.nationality = nat;
        this.points = pts;
    }

    // overloaded constructor
    public Pilot(String name, String nat) {
        this.name = name;
        this.nationality = nat;
        this.points = 0;
    }

    public Pilot(String name) {
        this.name = name;
        this.nationality = "unknown";
        this.points = 0;
    }

    public Pilot() {

    }

    public void addPoints(int morePoints) {
        this.points += morePoints;
    }

    @Override
    public String toString() {

        return String.format("%s (%s) - %d points . Team : %s", name, nationality, points, team);
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
