# Creative Project 1: Survivor Game

## Implementation Requirements

- Each type of task should be represented by a class that extends the Task class.

### EnduranceTask

- String type - the type of task, which is also the action required to complete the task. This must be one of the valid actions for this task type
- int duration - the number of times the action must be taken to complete the task
- String description - a text description of the task

### PrecisionTask

- List(String) requiredActions - the sequence of actions that are required to complete the task
  - Each action must be one of the valid actions for this task type
  - Actions need to be completed in order to complete the task
- String description - a text description of the task

### PuzzleTask

- String solution - the expected solution for this task
  - The solution will be provided with the "solve" action
- List(String) hints - an ordered list of hints to be provided to the client when taking the "hint" action
  - May be empty if there are no hints
  - If all hints have already been given (including if there are no hints), takeAction() should return false for the hint action.
- String description - a text description of the task
  - Includes the most recent hint given.
