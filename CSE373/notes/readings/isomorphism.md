# Isomorphism

## Left-Leaning Red-Black Trees

- In the real-world 2-3 trees are rarely used because of their difficulty to implement and the runtime cost of constantly splitting nodes.
- **Red-Black Tree**: Self-balancing binary search tree.

### Rotation

- We can change a binary tree's configuration by rotating it.
- For $N$ items, there are $2N - 6$ possible rotations.
- Rotating a node to the left involves making it's right child take it's place, and swapping some subtrees to maintain the binary tree invariant.

### One-to-One Correspondence and Isomorphism
