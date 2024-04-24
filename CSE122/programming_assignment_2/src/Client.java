// Wuihee 
// 11/15/2023
// CSE 123 
// P2: Disaster Relief
// TA: Heon Jwa

import java.util.*;

public class Client {
    private static Random rand = new Random();

    public static void main(String[] args) throws Exception {
        // List<Location> scenario = createRandomScenario(10, 10, 100, 1000, 100000);
        List<Location> scenario = createSimpleScenario();
        System.out.println(scenario);
        
        double budget = 2000;
        Allocation allocation = allocateRelief(budget, scenario);
        printResult(allocation, budget);
    }

    /**
     * Find best allocation of resources for a list of sites to help.
     * 
     * @param budget The budget given.
     * @param sites The list of sites that need relief.
     * @return An optimal allocation of sites that help the most people.
     */
    public static Allocation allocateRelief(double budget, List<Location> sites) {
        return allocateRelief(budget, sites, sites.size() - 1);
    }

    /**
     * Helper method to recursively find best allocation of resources for a list of sites to help.
     * 
     * @param budget The budget given.
     * @param sites The list of sites that need relief.
     * @param i The current site.
     * @return An optimal allocation of sites that help the most people.
     */
    private static Allocation allocateRelief(double budget, List<Location> sites, int i) {
        if (i < 0) {
            return new Allocation();
        }
        Allocation allocation = new Allocation();
        Location site = sites.get(i);
        if (budget >= site.getCost()) {
            allocation = allocateRelief(budget - site.getCost(), sites, i - 1).withLoc(site);
        }
        return chooseAllocation(
            allocation,
            allocateRelief(budget, sites, i - 1)
        );
    }

    /**
     * Given 2 allocations, choose the more optimal one based on first the number of people saved,
     * then the least budget used, otherwise pick either.
     * 
     * @param allocation1 The first allocation.
     * @param allocation2 The second allocation.
     * @return The more optimal allocation.
     */
    private static Allocation chooseAllocation(Allocation allocation1, Allocation allocation2) {
        if (allocation1.totalPeople() > allocation2.totalPeople()) {
            return allocation1;
        } else if (allocation1.totalPeople() < allocation2.totalPeople()) {
            return allocation2;
        } else if (allocation1.totalCost() < allocation2.totalCost()) {
            return allocation1;
        } else {
            return allocation2;
        }
    }

    // PROVIDED HELPER METHODS - **DO NOT MODIFY ANYTHING BELOW THIS LINE!**

    public static void printResult(Allocation alloc, double budget) {
        System.out.println("Result: ");
        System.out.println("  " + alloc);
        System.out.println("  People helped: " + alloc.totalPeople());
        System.out.printf("  Cost: $%.2f\n", alloc.totalCost());
        System.out.printf("  Unused budget: $%.2f\n", (budget - alloc.totalCost()));
    }

    public static List<Location> createRandomScenario(int numLocs, int minPop, int maxPop, double minCostPer, double maxCostPer) {
        List<Location> result = new ArrayList<>();

        for (int i = 0; i < numLocs; i++) {
            int pop = rand.nextInt(minPop, maxPop + 1);
            double cost = rand.nextDouble(minCostPer, maxCostPer) * pop;
            result.add(new Location("Location #" + i, pop, round2(cost)));
        }

        return result;
    }

    public static List<Location> createSimpleScenario() {
        List<Location> result = new ArrayList<>();

        result.add(new Location("Location #1", 50, 500));
        result.add(new Location("Location #2", 100, 700));
        result.add(new Location("Location #3", 60, 1000));
        result.add(new Location("Location #4", 20, 1000));
        result.add(new Location("Location #5", 200, 900));

        return result;
    }    

    private static double round2(double num) {
        return Math.round(num * 100) / 100.0;
    }
}
