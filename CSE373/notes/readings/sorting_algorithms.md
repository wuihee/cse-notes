# Sorting Algorithms

## Asymptotic Analysis

- **Experimental Runtime Analysis**: How long the program takes.
- **Asymptotic Runtime Analysis**: Big-O.
- **Asymptotic Variable**: The choice for the "large input". I.e. the choice for `n` in `O(n)`.
- **Case Analysis**: Analyze the runtime based on the best/worst case inputs and how they vary.
- **Order of Growth**: Given a polynomial function representing the runtime of an algorithm, its order of growth denotes how the time of the algorithm increases as its input increases. It is the term with the highest order.

### Big-Theta $\Theta$

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
- **Stability**: Given 2 elements $R$ and $S$ with equal values, if a sorting algorithm is stable, $R$ and $S$ will appear in the same order in which they were originally in.

### Selection Sort

- **Iterative Improvement Invariant**: Keep the left half of the array sorted, and at each iteration we increase the number of sorted elements by one until the entire array is sorted.
- **Algorithm**: Starting from the 0-index position, find the smallest element in the array and put it in the front. Keep doing this until the array is sorted.
- **Time Complexity**: $\Theta(n^2)$.
- **Best Case Runtime**: $\Theta(n^2)$.
- **In-Practice Runtime**: $\Theta(n^2)$.
- **Stable?**: No
- **In-Place?**: Yes

### Insertion Sort

- Maintains *Iterative improvemenet invariant*.
- **Algorithm**: Starting from index-0, insert current element in it's correct sorted position in the left-half of the array, and keep doing this until the array is sorted.
- **Time Complexity**: $\Theta(n^2)$.
- **Best Case Runtime**: $\Theta(n)$.
- **In-Practice Runtime**: $\Theta(n^2)$.
- **Stable?**: Yes
- **In-Place?**: Yes

### Selection vs Insertion Sort

- Insertion sort is preferred because it is stable and has a better best-case runtime.
- This is because selection sort, regardless of the state of the array, needs to always loop through the remaining right-half of the array to find the next smallest element.
- In contrast, insertion sort works on inserting the *current* element, which in some cases is already in its correct position.
- Also, selection sort isn't stable because it relies on swapping the current element with the next smallest element which could mess up the relative order of elements.

## Merge Sort

### Binary Search

- **Recurrence Relation**: $T(N) = T(N/2)+1$
- **Runtime**: $\Theta(\log N)$

### Recursive Merge Sort

- **Algorithm**:
  - **Base Case**: If size of array $n=1$, return single element.
  - Recursively sort left and right halves.
  - Merge the two halves.
- **Recurrence Relation**: $T(N) = 2T(N/2)+N$
- **Time Complexity**: $O(n\log n)$ (linearithmic)
