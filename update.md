# Adding Teams to Formula 1 Project - Understanding ManyToOne Relationships

## What Changed?

We added a new feature to our Formula 1 project: Teams! Now each pilot belongs to a team (like in real F1), and a team can have multiple pilots.

## The New Files and Changes

### 1. New Team Entity
We created a new `Team` class [here](https://gist.github.com/juananpe/a421e242f6b42a05854a6c22f583818d)
 with:
 
- A name (which is the ID)
- A country
- A list of pilots that belong to the team

### 2. Updated Pilot Entity
We modified the `Pilot` class to:
- Add a reference to their team
- Show team information in the toString() method

## Understanding the Relationship

Think of it like this: In Formula 1...
- A pilot can only drive for ONE team at a time
- A team can have MANY pilots

This is called a "Many-to-One" relationship because:
- MANY pilots → ONE team
- Like how many Mercedes drivers (Hamilton, Russell) belong to one Mercedes team

### How It Works

1. In the `Pilot` class, we added:

```java
@ManyToOne
private Team team;
```
This tells the database that "each pilot has one team".

2. In the `Team` class, we added:

```java
@OneToMany(mappedBy = "team")
private List<Pilot> pilots = new ArrayList<>();
```
This tells the database that "each team has many pilots".

## Helper Methods

We added methods to make managing teams and pilots easier:

1. In the `Team` class, we added:

```java
public void addPilot(Pilot pilot) {
    pilots.add(pilot);
    pilot.setTeam(this);    
}
```
This method adds a pilot to the team and also sets the pilot's team reference to this team.
    
2. In the `Pilot` class, we added:

```java
public void setTeam(Team team) {
    this.team = team;
}
```
This method sets the pilot's team reference to the given team.

## Example Usage
```java
// Create a team
Team mercedes = new Team("Mercedes", "Germany");
// Create pilots
Pilot hamilton = new Pilot("Lewis Hamilton", "British", 0);
Pilot russell = new Pilot("George Russell", "British", 0);
// Add pilots to team
mercedes.addPilot(hamilton);
mercedes.addPilot(russell);
```
Now when you print a pilot, it will show their team:

Lewis Hamilton (British) - 0 points [Mercedes (Germany)]


## Database Changes
We also updated `hibernate.cfg.xml` to tell the database about our new Team entity by adding: 

```xml
<class name="eus.ehu.domain.Team" />
```

This ensures the database knows how to store teams and their relationship with pilots.