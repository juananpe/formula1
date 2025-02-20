package eus.ehu.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Pilot {
    @Id
    String name;
    String nationality;
    int points;

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

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        String teamName = (team != null) ? team.toString() : "No team";
        return String.format("%s (%s) - %d points [%s]", name, nationality, points, teamName);
    }
}
