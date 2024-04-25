# Section Notes

## Section 1 (28 Mar)

- Passing by Value: When we pass a variable into a function it creates a copy, so any changes that are made dissappear after the function is finished.
- Passing by Reference: When we pass an object (e.g. an array) as a parameter we pass a reference, so any changes that are made stay.
- Briefly analyzed queues, stacks, and implementations using arrays and linked lists.

## Section 2 (4 Apr)

- Asymptotic notation describes an algorithms runtime as a function of its input as its input goes to infinity.
- $O(N)$ describes the runtime, while the asymptotic variable $N$ represents the algorithms input as it goes to infinity.
- An abstract data type (ADT) is an interface which describes what methods a data type should have.
- A data structure is the specific implementation of the ADT.

## Section 3 (11 Apr)

- Trie vs TST

|            |  Trie  |    TST     |
| ---------- | ------ | ---------- |
| Max Height | $O(L)$ | $O(L + N)$ |
| Invariant | 3 Children | List of children |

## Section 4

- LLRB trees and 2-3 trees are isomorphic, i.e. structurally similar.
- LLRB Invariants
  - Left children less than current node.
  - Right children more than current node.
  - No node has 2 red links, including the parent link.
  - Red links all left leaning.
  - Every path from root to leaf node has same number of black links.
- When we "flip", we need to flip all connected nodes to properly simulate the popping up of nodes.
- When we rotate, we need rotate the top most node?
- When we want to query the top keys from a TST or trie, we can use a priority queue.

## Section 5

### Binary Heap

- **Methods**: `peek()`, `add()`, `remove()`.
- **Insertion**: Remember to sink to the side which the greatest/least value.
- **Invariant**: Heap Invariant, Binary Tree Invariant, Complete Tree Invariant

### Hash Tables

- When iterating over a hash table, the order of elements depend on the implementation and does not follow the insertion order.
