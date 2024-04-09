# Search Trees

## Binary Search Trees (BST)

- Node-based data structure where children nodes on the left have values less than the current node and those on the right have values greater than the current node.
- Commonly used to implement *sets* or *maps*.
- We can search for an element in a BST using *binary search* - moving down left or right depending on whether the current element is greater or equal to the target element.
- The runtime of binary tree methods dpeend on the height of the tree. Therefore, it is important to balance the tree.
  - Best Case: $\Theta(\lg N)$
  - Worst Case: $\Theta(N)$

## Tries

### Ternary Search Trees

### Memory Hierarchy

- **Cache** (L1 to L3): CPU is able to access data here the fastest.
- **RAM** (Random Access Memory): Temporary data is stored here like the states of our programs. CPU can access data here moderately fast.
- **Disk**: This is where permanent data is stored. Data here takes the longest to acess.

#### How Memory Affects Algorithms

- We can think of RAM as a giant array where our programs store data.
- When we create an array, we are carving out one continguous block of memory. This is why array indexing is so fast.
- However, for linked lists, the nodes in memory aren't contiguous. We store the node value, and the address of the next node.
- In addition, when we access an array index, the CPU will store the nearby data in the cache, making array operations much faster given that data in an array is stored continguously.
- **Spatial Locality**: The tendency for programs to access memory stored near each other.
- **Temporal Locality**: The tendency for programs to access recently accessed data.
