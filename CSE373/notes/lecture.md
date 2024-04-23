# Lecture Notes

## Lecture 1 (25 Mar)

- Syllabus Review
- [Course Site](https://courses.cs.washington.edu/courses/cse373/24sp/)

## Lecture 2 (29 Mar)

- IntelliJ debugger review.

### Queue ADT with Array

- Keep track of front and rear pointers to improve `add()` and `remove` to `O(1)`.
- Resize at certain capactiy.

### Array Deque

- A cool trick is to wrap around the array when we run out of space - we just need to keep track of the front and rear pointers.

### Deque with `ArrayList`

- `ArrayList` Invariant: `array[i]` must always correspond to the ith element.
- To maintain this invariant, we need to constantly reposition elements when performing `add()` or `remove()` operations on the deque from the front/back.

## Lecture 3 (1 Apr)

- Rundown of Project 1 Deques.
- Asymptotic analysis review.

## Lecture 4 (3 Apr)

- **Selection Sort**: *Select* smallest element from unsorted, right-half of the array and swap it with the current index.
- **Insertion Sort**: *Insert* the current element in its correct position on the left side of the sorted array.

## Lecture 5 (5 Apr)

- When coming up with a reccurence relation, create it on how the problem reduces, *not* how the code is structure.

```java
static void g(int goal, int step) {
    if (step > goal) {
        return;
    }
    for (int i = 0; i < goal; i += step) {
        System.out.println(i + " ");
    }
    System.out.println();
    g(goal, step * 2);
    g(goal, step * 2);
}
```

- Initially, I thought the reccurence was $T(N) = 2T(N) + \frac{N}{2}$. However, when you unroll the recurrence, it is an infinite loop.
- While it is true that in the code $N$ is passed as a parameter, the work passed down at each level is halved, so the recurrence should be: $T(N) = T(\frac{N}{2}) + N$.

### Common Partial Sums

- $1 + 2 + 3 + 6 + ... + N = \frac{N^2 + N}{2} \rArr \Theta(N^2)$
- $1 + 2 + 4 + 8 + ... + N = 2N - 1 \rArr \Theta(N)$
- $1 + \frac{1}{2} + \frac{1}{4} + \frac{1}{8} + \frac{1}{N} \approx 2$

## Lecture 6 (4 Apr)

- We can convert an array into a BST by taking the middle element as the middle node.
- We can delete a node from a BST by swapping nodes from the bottom up.

## Lecture 7 (10 Apr)

### Trie

- Data structure used to store words.
- Each node contains a character and a mapping to all other next nodes. We can use an array to store the next nodes and reference them using the ordinal values of the characters.
- We can also use an attribute like `isTerm` to signify that a node marks the end of a word.

### Ternary Search Tree

- **Middle**: Middle node has character that we want.
- **Left**: Character we want is less than middle node.
- **Right**: Character we want is greater than middle node.

## Lecture 8 (12 Apr)

- Inserting into 2-3 trees maintains balance by splitting off from leaves.

## Lecuture 9

- 2-3 trees are *isomorphic* to red-black trees.

## Lecture 10

- Quicksort is isomorphic to BSTs.
- Runtime Analysis
  - **Best Case**: $\Theta(N\ln N)$; Random array.
  - **Worst Case**: $\Theta(N^2)$; Sorted array.
- If we always pick the leftmost element as our pivot $p$, we can make quicksort stable by ensuring that elements to the left are less than $p$, and elements to the right are greater or equal to $p$.

## Lecture 12

- **Binary Heap**: Binary tree data structure where for each node is greater/less or equal than the current node's value depending on whether our heap is a min-heap or max-heap. A binary heap is also a *complete search tree*.
- Removing from a priority queue requires swapping the root node with the right most leaf, removing the leaf, and "sinking" the node down to its correct position.
- Inserting into a priority queue involves first placing the node at the right most empty leaf position, then "swimming" up to where it belongs.
- A heap is represented using an array starting at index 1:
  - Left Child: $i * 2$
  - Right Child: $i * 2 + 1$
  - Parent: $\frac{i}{2}$
