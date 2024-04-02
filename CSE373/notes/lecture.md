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
