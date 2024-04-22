# Heaps & Hashing

## Binary Heaps

- **Complete Tree**: A tree where every level is fully filled, and all leaf nodes are pushed to the left.
- **Binary Heap**: A tree data structure that is a *complete tree* and a *binary tree*, but not a *search tree*.

### Priority Queue

- **Priority Queue**: An ADT which elements are ordered by a specified priority.
- A min-oriented priority queue, `MinPQ` has the following methods (and vice-versa for `MaxPQ`):
  - `void add(E element, double priority)`: Adds a given element with specified priority.
  - `E peekMin()`: Returns the element with the minimum priority.
  - `E removeMin()`: Removes the element with the minimum priority.
- Priority queues defer from sets in that:
  - Duplicate elements are allowed.
  - Multiple values can have the same priority.

### Heap Invariant

- **Min-Heap Invariant**: The priority value of a given node must be less or equal to all its children.
- **Max-Heap Invariant**: The priority value of a given node must be greater or equal to all its children.
- Therefore, `removeMin()` simply requires removing the top node from the heap.
- However, to maintain the heap invariant, we need to:
  - Fill the missing root with the right most leaf to maintain the complete tree invariant.
  - *Sink* the node into its appropriate place to maintain the heap invariant.
- To `add()`, we add an item to the left most available leaf position and *swim* to restore the heap invariant.

#### Array Representation

- Heaps are visualized as trees, but represented using arrays.
- Let your given node be at index $i$.
  - Parent: $\frac{i - 1}{2}$
  - Left child: $2i + 1$
  - Right child: $2i + 2$
