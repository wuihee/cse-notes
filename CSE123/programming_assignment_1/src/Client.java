import java.util.*;

// A program to work with Mini-Git. Manages the state of repositories and allows for all
// operations defined in Mini-Git.

public class Client {
    private static List<String> ops = new ArrayList<>();

    public static void main(String[] args) {
        Collections.addAll(ops, "create", "head", "history", "commit", "drop",
                           "synchronize", "quit");
        Scanner console = new Scanner(System.in);
        Map<String, Repository> repos = new HashMap<>();
        String op = "";
        String name = "";

        intro();

        while (!op.equalsIgnoreCase("quit")) {
            System.out.println("Available repositories: ");
            for (Repository repo : repos.values()) {
                System.out.println("\t" + repo);
            }
            System.out.println("Operations: " + ops);
            System.out.print("Enter operation and repository: ");
            String[] input = console.nextLine().split("\\s+");
            op = input[0];
            name = input.length > 1 ? input[1] : "";
            while (!ops.contains(op) || (!op.equalsIgnoreCase("create") &&
                    !op.equalsIgnoreCase("quit") &&
                    !repos.containsKey(name))) {
                System.out.println("  **ERROR**: Operation or repository not recognized.");
                System.out.print("Enter operation and repository: ");
                input = console.nextLine().split("\\s+");
                op = input[0];
                name = input.length > 1 ? input[1] : "";
            }

            Repository currRepo = repos.get(name);
            op = op.toLowerCase();
            if (op.equalsIgnoreCase("create")) {
                if (currRepo != null) {
                    System.out.println("  **ERROR**: Repository with that name already exists.");
                } else {
                    Repository newRepo = new Repository(name);
                    repos.put(name, newRepo);
                    System.out.println("  New repository created: " + newRepo);
                }
            } else if (op.equalsIgnoreCase("head")) {
                System.out.println(currRepo.getRepoHead());
            } else if (op.equalsIgnoreCase("history")) {
                System.out.print("How many commits back? ");
                int nHist = console.nextInt();
                console.nextLine();
                System.out.println(currRepo.getHistory(nHist));
            } else if (op.equalsIgnoreCase("commit")) {
                System.out.print("Enter commit message: ");
                String message = console.nextLine();
                System.out.println("  New commit: " + currRepo.commit(message));
            } else if (op.equalsIgnoreCase("drop")) {
                System.out.print("Enter ID to drop: ");
                String idDrop = console.nextLine();
                if (currRepo.drop(idDrop)) {
                    System.out.println("  Successfully dropped " + idDrop);
                } else {
                    System.out.println("  No commit dropped!");
                }
            } else if (op.equalsIgnoreCase("synchronize")) {
                System.out.print("Which repository would you like to " +
                        "synchronize into the given one? ");
                String repo = console.nextLine();
                if (repo.equals(name)) {
                    System.out.println("Cannot synchronize the same repositories!");
                } else if (!repos.containsKey(repo)) {
                    System.out.println("Repository does not exist!");
                } else {
                    currRepo.synchronize(repos.get(repo));
                }
            }
            System.out.println();
        }
    }

    // Prints out an introduction to the Mini-Git test client.
    public static void intro() {
        System.out.println("Welcome to the Mini-Git test client!");
        System.out.println("Use this program to test your Mini-Git repository implemenation.");
        System.out.println("Make sure to test all operations in all cases --");
        System.out.println("some cases are particularly tricky.");
        System.out.println();
    }
}

