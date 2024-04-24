// Wuihee 
// 10/17/2023
// CSE 123 
// C1: Survivor Challenge
// TA: Heon Jwa

import java.util.*;

/**
 * A task that tests endurance by requiring contestants to lift a huge amount of weight.
 */
public class StrengthTask extends EnduranceTask {
    
    // Fields
    private List<String> actionOptions;
    private int requiredStrength;
    private int remainingStrength;

    /**
     * Constructor which instantiates a StrengthTask.
     * 
     * @param weightRemaining The amount of weight needed to be lifted to complete the task.
     * @param strengthRemaining The amount of strength remaining measured in kg.
     * @param description A text description of the task.
     */
    public StrengthTask(String type, int duration, int requiredStrength, String description) {
        super(type, duration, description);
        this.requiredStrength = requiredStrength;
        remainingStrength = 50;
        actionOptions = new ArrayList<>(Arrays.asList(
            "bench", "deadlift", "squat", "rest"
            )
        );
    }

    /**
     * Returns a string representation of the task and remaining weight and strength.
     * 
     * @return A String containing the description and the remaining weight and strength.
     */
    @Override
    public String getDescription() {
        return ("""
                %s
                Required Strength: %d
                Remaining Strength: %d
                """).formatted(super.getDescription(), requiredStrength, remainingStrength);
    }

    /**
     * Returns a list of actions that may be atempted to complete this StrengthTask.
     * Valid actions include bench, deadlift, squat, rest.
     * 
     * @return The list of valid actions for the StrengthTask.
     */
    @Override
    public List<String> getActionOptions() {
        return actionOptions;
    }

    /**
     * Attempts to take an action to work towards completing the StrengthTask.
     * 
     * @param action the action to be attempted.
     * @return true if the action is the same type of action required to complete part of the
     *         StrengthTask, false otherwise.
     * @throws IllegalArgumentException if the action attempted is not a valid action for this
     *         task (as specified by getActionOptions())
     */
    public boolean takeAction(String action) {
        if (actionOptions.indexOf(action) == -1) {
            throw new IllegalArgumentException("**Invalid action: " + action + "**");
        } 
        
        if (action.equals(getType())) {
            if (remainingStrength < requiredStrength) {
                return false;
            }
            remainingStrength -= requiredStrength;
            increaseSuccessfulActions();
            return true;
        } else if (action.equals("rest")) {
            remainingStrength += 50;
            return true;
        }
        return false;
    }
}
