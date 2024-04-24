# Creative Project 3: BrettFeed Quiz

## Objective

- Create a quiz where users will be asked repeatedly to choose which of two options they prefer until they are presented with a final result.

## Implementation

- We will represent a quiz using a binary tree, where leaf nodes represent possible results, and non-leaf nodes (branches) represent choices the user will make.
- When a user takes a quiz, they will be presented with the choice from the root node of the tree. Based on their response, the system will traverse to either the left or right child of the root. If the node found is a leaf, the user will be shown their result. Otherwise, the process will repeat from the new node until a leaf is reached.

### Required Code

#### `QuizTree` Class

- `public QuizTree(Scanner inputFile)`
  - Constructs a new quiz based on the provided input.
- `public void takeQuiz(Scanner console)`
  - Allows the user to take the current quiz using the provided Scanner. This method should prompt the user to choose between the options at each node and traverse the tree until a leaf node is reached. When a leaf is reached, the user's result should be printed.

#### `QuizTreeNode` Class

- **Public static inner class** used to represent the nodes of the tree.
- The fields of the `QuizTreeNode` class must be public.
- The `QuizTreeNode` class must not contain any constructors or methods that are not used by the `QuizTree` class.
- The `QuizTreeNode` class must not contain any logic necessary to take a quiz - it should purely represent a node in the tree.
- You must have a single `QuizTreeNode` class that can represent both choices and results - you should not create separate classes for the different types of nodes.
