import java.util.*;

public class Client {
    public static void main(String[] args) throws Exception {
        Scanner console = new Scanner(System.in);
        List<Task> challenge = new ArrayList<>();

        // challenge.add(new EnduranceTask("jump", 3, "A set of three hurdles."));
        // challenge.add(new EnduranceTask("swim", 1, "A small lake."));
        // challenge.add(new PrecisionTask(new ArrayList<>(Arrays.asList("crawl", "climb", "run")), "A low crawl net, then a wall with a rope, then a dash to the end."));
        // challenge.add(new PuzzleTask("4", new ArrayList<>(Arrays.asList("It's 4.", "No really, it's 4!")), "What is 2 + 2?"));
        challenge.add(new StrengthTask("bench", 4, 100, "Bench press 4 times."));

        attemptChallenge(challenge, console);
    }

    public static void attemptChallenge(List<Task> course, Scanner console) {
        List<String> prevActions = new ArrayList<>();

        while (!course.isEmpty()) {
            Task current = course.get(0);
            System.out.println("Current task: " + current.getDescription());
            System.out.println("Previous actions: " + prevActions);
            System.out.println("Possible actions: " + current.getActionOptions());
            System.out.print("Your action? ");
            String action = console.nextLine();

            try {
                boolean result = current.takeAction(action);
                if (result) {
                    System.out.println("  Action successful!");
                    prevActions.add(0, action); 
                    if (current.isComplete()) {
                        System.out.println("  Task completed!");
                        course.remove(0);
                        prevActions.clear();
                    }
                } else {
                    System.out.println("  Action not successful.");
                }
            } catch (IllegalArgumentException ex) {
                System.out.println("  " + ex.getMessage());
            }
            System.out.println();
        }
        System.out.println("Challenge complete. Congratulations!!!");
    }
}