# Isomorphism

## Left-Leaning Red-Black Trees

- In the real-world 2-3 trees are rarely used because of their difficulty to implement and the runtime cost of constantly splitting nodes.
- **Red-Black Tree**: Self-balancing binary search tree that is identical to the 2-3 tree but is implemented without needing to split/merge nodes.
- **Red-Black Tree Invariants**
  - Red edges must lean left.
  - No node can have 2 red edges.
  - There must be an equal number of black edges from the current node to a leaf.

### Rotation

- We can change a binary tree's configuration by rotating it.
- For $N$ items, there are $2N - 6$ possible rotations.
- Rotating a node to the left involves making it's right child take it's place, and swapping some subtrees to maintain the binary tree invariant.

### One-to-One Correspondence and Isomorphism

- Instead of directly implementing a 2-3 tree, we using a *left-leaning red-black tree* which achieves the same effect.
- Red edges represent when two nodes are merged.
- Whenever we have a right-leaning red edge, we rotate left the node so it becomes left-leaning.
- When we have two consecutive left-leaning red edges, we rotate right.
- When a node has 2 red nodes, this means that we have a 3-node in our 2-3 tree and we need to split. We indicate splitting by flipping the colors of our red-black tree edges.
