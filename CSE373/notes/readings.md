# Reading Notes

## Arrays and Nodes

### Dynamic Arrays

- **Collection**: A container which stores objects called *elements*. Arrays, sets, maps are all examples of a collection in Java.
- A better implementation of an `ArrayList` would be to keep the size of the underlying array larger, so we don't have to continuously resize it.

### Linked Nodes

- Removing an element in an `ArrayList` is slow because we have to reposition all following elements.
- To resolve this, we can use linked nodes `Node`, where each node contains a reference to the next node.

## Sorting Algorithms

### Asymptotic Analysis

- **Experimental Runtime Analysis**: How long the program takes.
- **Asymptotic Runtime Analysis**: Big-O.
- **Asymptotic Variable**: The choice for the "large input". I.e. the choice for `n` in `O(n)`.
- **Case Analysis**: Analyze the runtime based on the best/worst case inputs and how they vary.
- **Order of Growth**: Given a polynomial function representing the runtime of an algorithm, its order of growth denotes how the time of the algorithm increases as its input increases. It is the term with the highest order.

#### Big-Theta $\Theta$

- We use $\Theta$-notation for *asymptotically tight bounds*.
- For a given function $g(n)$, we define $\Theta(g(n))$ as the set of functions:

$\Theta(g(n))=\{f(n):$ there exists  constants $c_1,c_2,n_0$ such that $0\le c_1g(n)\le f(n)\le c_2g(n)$ for all $n\ge n_0\}$

- In other words, $f(n)$ lies between functions $c_1g(n)$ and $c_2g(n)$ within constant factors $c_1$ and $c_2$.
- Essentially, used to say that an algorithm grows approximately at a rate of $g(n)$.

## Iterative Sorts

- **Ordering Relation**: Given a list of elements, how do we define that element $a\ge b$ and vice-vera?
  - **Law of Trichotomy**: Only one of the following should be true: $a<b$, $a>b$, or $a=b$.
  - **Law of Transivity**: If $a<b$ and $b<c$, then $a<c$.
- A **sort**, therefore is an arrangement of elements that follow the *ordering relation*.
- More practically, we define the *ordering relation* using the `compareTo` method in Java.
- **Stability**: If sorting is stable, it always maintains the same order of elements. This can be tricky to ensure when we are sorting complicated objects.

## Merge Sort
