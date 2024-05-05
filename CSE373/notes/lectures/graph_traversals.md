# Graph Traversals

## Topological Sort

- The *topological ordering* of a directed, acyclic graph, is such that for every vertex from $u$ to $v$, $u$ comes before $v$.
- BFS cannot be used to produce a topological sorted order because of how it traverses the graph level by level, which does not account for dependency directions and simply follows the shortest path.
