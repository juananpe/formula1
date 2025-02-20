package eus.ehu.domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @Id
    private String name;
    private String country;
    
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Pilot> pilots = new ArrayList<>();

    public Team() {
    }

    public Team(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public void addPilot(Pilot pilot) {
        pilots.add(pilot);
        pilot.setTeam(this);
    }

    public void removePilot(Pilot pilot) {
        pilots.remove(pilot);
        pilot.setTeam(null);
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", name, country);
    }
} 