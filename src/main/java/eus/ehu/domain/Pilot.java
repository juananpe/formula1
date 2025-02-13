package eus.ehu.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pilot {
    @Id
    String name;
    String nationality;
    int points;

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
        return String.format("%s (%s) - %d points", name, nationality, points);
    }
}
