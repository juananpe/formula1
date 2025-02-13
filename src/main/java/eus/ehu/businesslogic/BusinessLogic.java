package eus.ehu.businesslogic;

import eus.ehu.data_access.DbAccessManager;
import eus.ehu.domain.Pilot;

import java.util.List;

public class BusinessLogic implements BlInterface {

    DbAccessManager db = new DbAccessManager();

    @Override
    public List<Pilot> getPilots() {
        return db.getAllPilots();
    }

    @Override
    public List<Pilot> getPilotsByNationality(String nat) {
        return null;
    }

    @Override
    public void storePilot(String name, String nat, int pts) {
        db.storePilot(name, nat, pts);
    }

    @Override
    public void deletePilotByName(String name) {

    }

    @Override
    public void deletePilot(Pilot p) {
        db.deletePilot(p);
    }
}
