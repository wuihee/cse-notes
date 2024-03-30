# CSE 373

## Readings Notes

### Arrays and Nodes

#### Dynamic Arrays

- **Collection**: A container which stores objects called *elements*. Arrays, sets, maps are all examples of a collection in Java.
- A better implementation of an `ArrayList` would be to keep the size of the underlying array larger, so we don't have to continuously resize it.

#### Linked Nodes

- Removing an element in an `ArrayList` is slow because we have to reposition all following elements.
- To resolve this, we can use linked nodes `Node`, where each node contains a reference to the next node.

## Lecture Notes

### 25 Mar

- Syllabus Review
- [Course Site](https://courses.cs.washington.edu/courses/cse373/24sp/)

### 27 Mar

- IntelliJ & GitLabs setup guide.
- LinkedList and ArrayList worksheet where we discussed the pros and cons of using either data structure.

### 29 Mar

- IntelliJ debugger review.
- Implementing 

## Section Notes

### 28 Mar

- Passing by Value: When we pass a variable into a function it creates a copy, so any changes that are made dissappear after the function is finished.
- Passing by Reference: When we pass an object (e.g. an array) as a parameter we pass a reference, so any changes that are made stay.
- Briefly analyzed queues, stacks, and implementations using arrays and linked lists.
