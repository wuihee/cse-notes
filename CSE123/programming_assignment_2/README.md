# Programming Assignment 2: Disaster Relief

## Objective

- Implement a recursive backtracking function to help as many people as possible given a budget.

### Algorithm

- Return the allocation of money that will result in the most people being helped.
- If there is a tie in the number of people being helped, return the one with the lower cost.
- Otherwise return any.

### Required Methods

- **`public static Allocation allocateRelief(double budget, List<Location> sites)`**:
  - `budget`: Amount of money you have.
  - `Location`: Each location object consists of a population and cost that you need to spend to help the population.
  - `Allocation`: Return an `Allocation` which represents a group of locations that will receive aid.
