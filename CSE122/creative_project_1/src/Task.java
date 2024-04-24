import java.util.*;

/**
 *   A Task to be completed through a series of specific actions.
 */
public abstract class Task {
    private String description;

    /**
     *   Constructs a new Task with the given description.
     */
    public Task(String description) {
        this.description = description;
    }

    /**
     * Returns a string representation of the task. Generally does not update 
     *  as parts of the task have been attempted or completed, but may change 
     *  due to other changes in task state.
     * 
     * @return the string representation of the task
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns a list of actions that may be attempted to complete this task.
     * 
     * @return the list of valid actions for the task
     */
    public abstract List<String> getActionOptions();

    /**
     * Returns whether or not this task has been completed.
     * 
     * @return true if the task has been completed, false otherwise
     */
    public abstract boolean isComplete();

    /**
     * Attempts to take an action to work towards completing the task. Tasks may require any
     *  number of actions to complete, and multiple required actions may be ordered or not.
     *  If the attempted action is successful, the task state is updated to reflect the completed
     *  action, which may or may not complete the task. Valid actions to attempt are those in the
     *  list returned by getActionOptions().
     * 
     * @param action the action to be attempted
     * @return true if the action was successful at completing part or all of the task, 
     *          false otherwise
     * @throws IllegalArgumentException if the action attempted is not a valid action for this task
     *              (as specified by getActionOptions())
     * @see getActionOptions
     */
    public abstract boolean takeAction(String action);
}