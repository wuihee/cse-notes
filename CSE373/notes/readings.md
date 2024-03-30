# Reading Notes

## Arrays and Nodes

### Dynamic Arrays

- **Collection**: A container which stores objects called *elements*. Arrays, sets, maps are all examples of a collection in Java.
- A better implementation of an `ArrayList` would be to keep the size of the underlying array larger, so we don't have to continuously resize it.

### Linked Nodes

- Removing an element in an `ArrayList` is slow because we have to reposition all following elements.
- To resolve this, we can use linked nodes `Node`, where each node contains a reference to the next node.
