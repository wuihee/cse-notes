/**
* The Location class represents a geographical location with a name, population, and cost.
* It provides methods to retrieve the population and cost of the location,
* as well as a method to generate a string representation of the object.
* Two static methods are provided to calculate the total population and cost
* of a Collection of Locations.
*/
import java.util.*;
public class Allocation {

    private Set<Location> locations;

    private Allocation(Set<Location> locations) {
        this.locations = new HashSet<Location>(locations);
    }

    public Allocation() {
        this(new HashSet<Location>());
    }

    public Set<Location> getLocations() {
        return new HashSet<Location>(locations);
    }

    public Allocation withLoc(Location loc) {
        if (locations.contains(loc)) {
            throw new IllegalArgumentException("Allocation already contains location " + loc);
        }
        Set<Location> newLocations = new HashSet<Location>(locations);
        newLocations.add(loc);
        return new Allocation(newLocations);
    }

    public Allocation withoutLoc(Location loc) {
        if (!locations.contains(loc)) {
            throw new IllegalArgumentException("Allocation does not contain location " + loc);
        }
        Set<Location> newLocations = new HashSet<Location>(locations);
        newLocations.remove(loc);
        return new Allocation(newLocations);
    }

    /**
    * Calculates the combined population in the given Collection
    * of Location objects
    * @param sites the Collection of Location objects
    * @return the combined population of the Location objects
    */
    public int totalPeople() {
        int total = 0;
        for (Location loc : locations) {
            total += loc.getPopulation();
        }
        return total;
    }

    /**
    * Calculates the combined cost in the given Collection
    * of Location objects
    * @param sites the Collection of Location objects
    * @return the combined cost of the Location objects
    */
    public double totalCost() {
        double total = 0;
        for (Location loc : locations) {
            total += loc.getCost();
        }
        return total;
    }

    public String toString() {
        return locations.toString();
    }
    
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Allocation)) {
            return false;
        }
        Allocation otherAlloc = (Allocation)other;

        return this.locations.equals(otherAlloc);
    }

    public int hashCode() {
        return locations.hashCode();
    } 
}
