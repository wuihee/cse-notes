// Wuihee 
// 10/17/2023
// CSE 123 
// C1: Survivor Challenge
// TA: Heon Jwa

import java.util.*;

/**
 * A task that tests precision by requiring contestants to repeat a sequence of specified
 * actions.
 */
public class PrecisionTask extends Task{
    
    // Fields
    private List<String> requiredActions;
    private List<String> actionOptions;
    private int currentAction;

    /**
     * Constructor which instantiates a PrecisionTask
     * 
     * @param requiredActions The sequence of actions required to complete the task.
     * @param description A text description of the task.
     */
    public PrecisionTask(List<String> requiredActions, String description) {
        super(description);
        this.requiredActions = requiredActions;
        currentAction = 0;
        actionOptions = new ArrayList<>(Arrays.asList("jump", "run", "swim", "crawl", "climb"));
    }

    /**
     * Returns a list of actions that may be attempted to complete this PrecisionTask.
     * Valid actions include jump, run, swim, crawl, climb.
     * 
     * @return the list of valid actions for the PrecisionTask.
     */
    public List<String> getActionOptions() {
        return actionOptions;
    }

    /**
     * Returns whether or not this PrecisionTask has been completed. The task has been completed
     * when all the required actions have been performed.
     * 
     * @return true if the task has been completed, false otherwise.
     */
    public boolean isComplete() {
        return currentAction >= requiredActions.size();
    }

    /**
     * Attempts to take an action to work towards completing the PrecisionTask.
     * 
     * @param action the action to be attempted.
     * @return true if the action was successful at completing the current action in the sequence
     *         and false otherwise.
     * @throws IllegalArgumentException if the action attempted is not a valid action for this task
     *         (as specified by getActionOptions())
     */
    public boolean takeAction(String action) {
        if (actionOptions.indexOf(action) == -1) {
            throw new IllegalArgumentException("**Invalid action: " + action + "**");
        }
        
        if (!action.equals(requiredActions.get(currentAction))) {
            return false;
        }
        currentAction++;
        return true;
    }
}
