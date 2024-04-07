# Search Trees

## Binary Search Trees (BST)

- Node-based data structure where children nodes on the left have values less than the current node and those on the right have values greater than the current node.
- Commonly used to implement *sets* or *maps*.
- We can search for an element in a BST using *binary search* - moving down left or right depending on whether the current element is greater or equal to the target element.
- The runtime of binary tree methods dpeend on the height of the tree. Therefore, it is important to balance the tree.
  - Best Case: $\Theta(\lg N)$
  - Worst Case: $\Theta(N)$
