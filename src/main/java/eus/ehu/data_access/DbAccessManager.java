package eus.ehu.data_access;

import eus.ehu.domain.Pilot;
import eus.ehu.domain.Team;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class DbAccessManager {

    protected EntityManager db;
    protected EntityManagerFactory emf;

    public DbAccessManager() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            emf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }

        db = emf.createEntityManager();
        System.out.println("DataBase opened");

    }

    public List<Pilot> getPilotsByNationality(String nat) {
        TypedQuery<Pilot> q2 = db.createQuery(
                "SELECT p FROM Pilot p WHERE p.nationality = \"" + nat + "\"",
                Pilot.class);
        List<Pilot> pilots = q2.getResultList();

        return pilots;
    }


    public void storePilot(String name, String nat, int pts) {
        db.getTransaction().begin();
        Pilot pilot = new Pilot(name, nat, pts);
        db.persist(pilot);
        db.getTransaction().commit();
        System.out.println(pilot + " has been saved");
    }

    public List<Pilot> getAllPilots() {
        TypedQuery<Pilot> q1 = db.createQuery(
                "SELECT p FROM Pilot p", Pilot.class);
        List<Pilot> pilots = q1.getResultList();
        return pilots;
    }

    public List<Pilot> getPilotsWithMoreThanPoints(int points) {
        TypedQuery<Pilot> q3 = db.createQuery(
                "SELECT p FROM Pilot p WHERE p.points > :points", Pilot.class);
        q3.setParameter("points", points);
        List<Pilot> pilots = q3.getResultList();
        return pilots;
    }

    public void deletePilotByName(String name) {
        db.getTransaction().begin();
        Query query = db.createQuery("DELETE FROM Pilot p WHERE p.name = :name");
        query.setParameter("name", name);
        int rowsDeleted = query.executeUpdate();
        db.getTransaction().commit();
        System.out.println(rowsDeleted + " pilot(s) deleted");
    }

    /**
     * Deletes a pilot from the database
     * @param p the pilot to delete
     */
    public void deletePilot(Pilot p) {
        db.getTransaction().begin();
        db.remove(p);
        db.getTransaction().commit();
        System.out.println(p + " has been deleted");
    }

    public void storeTeam(String name, String country) {
        db.getTransaction().begin();
        Team team = new Team(name, country);
        db.persist(team);
        db.getTransaction().commit();
        System.out.println("Team " + team + " has been saved");
    }

    public Team findTeamByName(String name) {
        return db.find(Team.class, name);
    }

    public void addPilotToTeam(Pilot pilot, Team team) {
        db.getTransaction().begin();
        team.addPilot(pilot);
        db.getTransaction().commit();
        System.out.println("Pilot " + pilot + " added to team " + team);
    }

    public void close() {
        db.close();
        System.out.println("DataBase closed");
    }

    public Pilot findPilotByName(String name) {
        return db.find(Pilot.class, name);
    }

}
