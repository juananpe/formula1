package eus.ehu.businesslogic;

import eus.ehu.domain.Pilot;

import java.util.List;

public interface BlInterface {
    List<Pilot> getPilots();
    List<Pilot> getPilotsByNationality(String nat);
    void storePilot(String name, String nat, int pts);
    void deletePilotByName(String name);
    void deletePilot(Pilot selectedPilot);

}
