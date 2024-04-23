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

## Hash Tables

- Previously we have used trees to implement the `Set` and `Map` ADTs.
- The concept behind a hash table to is take avantage of $\Theta(1)$ indexing operations of arrays. If we can find a way to represent our keys as a number, storing and retrieving corresponding values will take constant time.
- The idea of projecting a key into a number is the process of generating a *hash code* and is called *hashing*.
- However we run into the problem of *collisions* where multiple keys share the same index. And by the *pigeonhole principle*, collisions are unavoidable as there are an infinite number of possible entries but a limited number of integers due to *integer overflow*.
  - **Integer Overflow**: When we run into the biggest number in Java, it wraps around to the smallest number.

### Separate Chaining

- To deal with collisions, we can use *separate chaining* where instead of adding keys to a single index position, we add them to a *bucket* like a linked list. Therefore, each index position can contain multiple items.
- Inserting and deleting with separate chaining takes $\Theta(Q)$ where $Q$ is the length of the longest list.
- Since we are no longer worried about collisions with separate chaining, we can greatly reduce the size of our backing array. We no longer need to have our hash code be the bucket index. Instead we can reduce our hash code with the modulus `%` function.

### Performance Analysis

- The runtime of `contains()` and `add()` operations are $\Theta (\frac{N}{M}) = \Theta(N)$ where $M$ is the number of buckets and $N$ is the number of items.
- To improve our runtime performace, we need to keep our *load factor* $\frac{N}{M}$ small, and we do this by increasing $M$, i.e. increasing the number of buckets.
- Therefore, as $M = \Theta(N)$, then $\Theta(\frac{N}{M}) = \Theta(1)$ and our hash table operations now take constant time.
- However, resizing will take $\Theta(N)$ time, but on average our operations will still take $\Theta(1)$ time.
- It's important to realize that an *even distribution* of items in hash tables are crucial for good performance.
