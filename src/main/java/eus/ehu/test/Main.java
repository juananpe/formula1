package eus.ehu.test;

import eus.ehu.data_access.DbAccessManager;
import eus.ehu.domain.Pilot;
import eus.ehu.domain.Team;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DbAccessManager dataManager = new DbAccessManager();

        /*
         * dataManager.storePilot("Lewis Hamilton", "British", 380);
         * // Include here additional instructions for another 6 pilots. You can
         * // get info at https://www.formula1.com/en/drivers.html
         * dataManager.storePilot("Valtteri Bottas", "Finnish", 223);
         * dataManager.storePilot("Max Verstappen", "Dutch", 226);
         * dataManager.storePilot("Sergio Perez", "Mexican", 125);
         * dataManager.storePilot("Lando Norris", "British", 132);
         * dataManager.storePilot("Charles Leclerc", "Monaco", 98);
         * dataManager.storePilot("Daniel Ricciardo", "Australian", 115);
         */

        /*
         * 
         * /*List<Pilot> britishPilots = dataManager.getPilotsByNationality("British");
         * System.out.println("British Pilots:");
         * for (Pilot p : britishPilots)
         * System.out.println(p);
         * System.out.println();
         */
        /*
         * Scanner scanner = new Scanner(System.in);
         * System.out.print("Enter the name of the pilot to delete: ");
         * String pilotName = scanner.nextLine();
         * dataManager.deletePilotByName(pilotName);
         * 
         * scanner.close();
         */

        // Create Mercedes team
        dataManager.storeTeam("Mercedes", "Germany");
        Team mercedes = dataManager.findTeamByName("Mercedes");

        // Create pilots
        dataManager.storePilot("Lewis Hamilton", "British", 380);
        dataManager.storePilot("George Russell", "British", 280);
        
        // Get pilots from database
        Pilot hamilton = dataManager.findPilotByName("Lewis Hamilton");
        Pilot russell = dataManager.findPilotByName("George Russell");

        // Add pilots to team
        dataManager.addPilotToTeam(hamilton, mercedes);
        dataManager.addPilotToTeam(russell, mercedes);

        // Print all pilots to verify the relationships
        System.out.println("\nDatabase content:");
        for (Pilot p : dataManager.getAllPilots()) {
            System.out.println(p);
        }

        dataManager.close();
    }
}
