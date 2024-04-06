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
