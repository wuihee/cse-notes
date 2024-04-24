// Wuihee 
// 10/17/2023
// CSE 123 
// C1: Survivor Challenge
// TA: Heon Jwa

import java.util.*;

/**
 * A task that tests intelligence or memory by requiring constants to solve a puzzle or riddle.
 */
public class PuzzleTask extends Task{
    
    // Fields
    private List<String> hints;
    private List<String> actionOptions;
    private String solution;
    private int currentHint;
    private boolean isSolved;

    /**
     * Constructor which instantiates a PuzzleTask.
     * 
     * @param solution The expected solution for this task.
     * @param hints An ordered list of hints to be provided which may be empty.
     * @param description A text description of the task which includes the most recent hint.
     */
    public PuzzleTask(String solution, List<String> hints, String description) {
        super(description);
        this.hints = hints;
        this.solution = solution;
        actionOptions = new ArrayList<>(Arrays.asList("hint", "solve <solution>"));
        currentHint = -1;
        isSolved = false;
    }

    /**
     * Returns a string representation of the task and the most recent hint if given.
     * 
     * @return A String containing the description and most recent hint if available.
     */
    @Override
    public String getDescription() {
        if (currentHint == -1) {
            return super.getDescription();
        }
        return super.getDescription() + "\n HINT: " + hints.get(currentHint);
    }

    /**
     * Returns a list of actions that may be attempted to complete this PuzzleTask.
     * Valid actions include hint, or solve.
     * 
     * @return the list of valid actions for the PuzzleTask.
     */
    public List<String> getActionOptions() {
        return actionOptions;
    }

    /**
     * Returns whether or not this PuzzleTask has been completed. The task has been completed
     * when the correct solution has been provided.
     * 
     * @return true if the task has been completed, false otherwise.
     */
    public boolean isComplete() {
        return isSolved;
    }

    /**
     * Attempts to take an action to work towards completing the PuzzleTask.
     * 
     * @param action the action to be attempted.
     * @return true if corrected solution is provided or a hint was requested. False if the
     *         solution was wrong or no hints remain.
     * @throws IllegalArgumentException if the action attempted is not a valid action for this task
     */
    public boolean takeAction(String action) {
        String[] parts = action.split(" ", 2);
        String actionType = parts[0];

        if (!actionType.equals("solve")) {
            if (!actionType.equals("hint")) {
                throw new IllegalArgumentException("**Invalid action: " + action + "**");
            }
            if (parts.length > 1) {
                throw new IllegalArgumentException("**Invalid action: " + action + "**");
            }
        }

        if (actionType.equals("hint")) {
            if (currentHint < hints.size() - 1) {
                currentHint++;
                return true;
            }
            return false;
        }

        if (parts.length == 1) {
            return false;
        }
        String userSolution = parts[1];
        if (userSolution.equals(solution)) {
            isSolved = true;
            return true;
        }
        return false;
    }
}
