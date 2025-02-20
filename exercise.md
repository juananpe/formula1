# Lab Exercise: Adding Teams to Formula 1 Database

In this lab, you will extend the Formula 1 database application to support Teams. Each F1 pilot belongs to exactly one team, and each team can have multiple pilots (a Many-to-One relationship).

## Part 1: Creating the Team Entity

1. Create a new class `Team` in the `domain` package with the following requirements:
   - It should be a JPA entity
   - It should have a name (which will be the ID) and a country
   - It should maintain a list of pilots that belong to the team
   - Include appropriate constructors and a toString() method

2. Add the Team-Pilot relationship:
   - In the `Team` class, add a `@OneToMany` relationship to its pilots
   - In the `Pilot` class, add a `@ManyToOne` relationship to its team
   - Add helper methods to manage the relationship (addPilot, setTeam)
   - Update the Pilot's toString() method to show team information

3. Update `hibernate.cfg.xml` to include the new Team entity

## Part 2: Database Access Layer

Add the following methods to `DbAccessManager`:

1. `storeTeam(String name, String country)`
   - Creates and persists a new team

2. `findTeamByName(String name)`
   - Retrieves a team from the database by its name

3. `findPilotByName(String name)`
   - Retrieves a pilot from the database by their name

4. `addPilotToTeam(Pilot pilot, Team team)`
   - Associates a pilot with a team
   - Remember to handle the transaction properly

## Part 3: Testing

Create a test in `Main.java` that:

1. Creates the Mercedes F1 team
2. Creates two pilots: Lewis Hamilton and George Russell
3. Associates both pilots with the Mercedes team
4. Retrieves and prints all pilots to verify the relationships

Expected output should look similar to:
```
Team Mercedes (Germany) has been saved
Lewis Hamilton (British) - 380 points has been saved
George Russell (British) - 280 points has been saved
Pilot Lewis Hamilton (British) - 380 points [Mercedes (Germany)] added to team Mercedes (Germany)
Pilot George Russell (British) - 280 points [Mercedes (Germany)] added to team Mercedes (Germany)

Database content:
Lewis Hamilton (British) - 380 points [Mercedes (Germany)]
George Russell (British) - 280 points [Mercedes (Germany)]
```

## Hints

1. For the Team-Pilot relationship:
   - Use `mappedBy` in the `@OneToMany` annotation to specify the bidirectional relationship
   - Remember to handle both sides of the relationship when adding a pilot to a team

2. For database operations:
   - Always wrap modifications in transactions
   - Remember to close the database connection when finished

3. Common pitfalls:
   - Forgetting to update both sides of the relationship
   - Not handling transactions properly
   - Forgetting to register the Team entity in hibernate.cfg.xml

