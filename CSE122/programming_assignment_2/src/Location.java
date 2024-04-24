public class Location {
    private String name;
    private int population;
    private double cost;

    /**
    * Creates a new Location object with the given name, population, and cost.
    * @param name the name of the location
    * @param pop the population of the location
    * @param cost the cost of the location
    */
    public Location(String name, int pop, double cost) {
        this.name = name;
        this.population = pop;
        this.cost = cost;
    }

    /**
    * Returns the population of the location
    * @return the population of the location
    */
    public int getPopulation() { return this.population; }

    /**
    * Returns the cost of the location
    * @return the cost of the location
    */
    public double getCost() { return this.cost; }


    /**
    * Returns a String representation of a Location object in the format:
    * "<name>: pop. <population>, cost: $<cost>"
    * @return the String representation of a Location object
    */
    public String toString() {
        return name + ": pop. " + population + ", cost: $" + cost;
    }

    // static helper methods for totaling populations or costs

    // Overrides of equals and hashCode to make sure Locations work with Sets

    /**
    * Compares the specified object with this location for equality. Returns true if the specified
    *  object is also a location and the two locations have the same name, population, and cost.
    * @param o objec to be compared for equality with this location
    * @return true if the specified object is equal to this location
    */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Location)) {
            return false;
        }
        Location otherLoc = (Location)other;

        return this.name.equals(otherLoc.name) &&
            this.population == otherLoc.population &&
            this.cost == otherLoc.cost;
    }

    /**
    * Returns the hash code value for this location
    * @return the hash code value for this location
    */
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + Integer.hashCode(population);
        result = 31 * result + Double.hashCode(cost);
        return result;
    }   
}
