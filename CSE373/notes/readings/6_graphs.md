# Graphs

## Graph Data Types

- Graphs help to represent relationships between data.
- Trees are a special type of graph, with additional constraints.
- $V$ is the set of all vertices in the graph.
- $E$ is the set of all edges in the graph.
- $|V|$ or $n$ is the number of vertices.
- $|E|$ or $m$ is the number of edges.

### Vertex

- A *vertex* is a node in a graph.

### Edge

- A direct connection between two vertices $v$ to $w$, which can optionally have a *weight*.
- For any vertex and its neighboring / adjacent verticies, we will assume:
  - No self-loops.
  - No parallel / duplicate edges.
- **Undirected Edge**: Represents a connection between two vertices going both ways.
- **Directed Edge**: Represents a single connection from vertex $v$ to $w$ going one way.

### Undirected Graph

- The *undirected graph* ADT is a graph containing $N$ vertices and $N - 1$ *undirected* edges.
- A *path* represents a sequence of connected vertices with no repeated edges.
- A *cycle* represents a *path* whose first and last vertices are the same.
- The *degree* of a vertex refers to the number of edges connected to it.

```java
public interface UndirectedGraph<V> {

    // Add an undirected edge between vertices (v, w).
    public void addEdge(V v, V w);

    // Returns a list of edges adjacent to the given vertex.
    public List<Edge<V>> neighbors(V v);
}
```

### Directed Graph

- The *directed graph* ADT is a graph containing $N$ vertices and $N - 1$ directed edges.
- A *directed cycle* is path whose first and last vertices are the same in a directed graph.
- The *outdegree* is the number of edges pointing out from a given vertex.
- The *indegree* is the number of edges point towards a give vertex.

```java
public interface DirectedGraph<V> {

    // Add an directed edge between vertices (v, w).
    public void addEdge(V v, V w);

    // Returns a list of edges adjacent to the given vertex.
    public List<Edge<V>> neighbors(V v);
}
```

### Data Structures Used to Represent Graphs

- The *adjacency list* is a data structure for implementing undirected / directed graphs. Each vertex is associated with a list of adjacent vertices it's connected to.
- An *adjacency matrix* or *edge set* are two other common data structures that can be used to represent graphs.

## Graph Traversals

### Connectivity Problem

- How do we check if any two nodes are connected?

### Depth First Search (DFS)

- Recursively search all elements in the graph.
- Keep track of visited nodes to prevent infinite loops.

```java
public boolean connected(Vertex s, Vertex t) {
    if (s == t) {
        return true;
    } else {
        visited.add(s);
        for (Vertex n : s.neighbors()) {
            if (!visited.contains(n) && connected(n, t)) {
                return true;
            }
        }
    }
    return false;
}
```

## Shortest Path Trees

### Unweighted Shortest Paths Problem

1. **Single-Pair Shortest Paths**: Shortest path from source vertex $s$ to target $t$.
2. **Single-Source Shortest Paths**: Shortest path from source vertex $s$ to all other vertices.
3. **Multiple-Source Shortest Paths**: The shortest path from any source in a given set of vertices $S$ to all other vertices.

### Weighted Shortest Paths Problem

- Same idea as the unweighted shortest paths problem except our edges now have weights and we want to find the shortest path in terms of minimizing our cost.

### Dijkstra's Algorithm

- Keep track of an array `distances` where `distances[i]` is the cost from `source` to node `i`. We initialize `distances[source] = 0` and set all other values to infinity.
- We also instantiate a set `unvisited` containing all unvisited nodes.
- Starting at our source, we add the neighbors to a priority queue, ordered by `distances[neighbor]`.
- We then perform *relaxation* on each neighbors and update the `distances` array.
- We keep doing this until we have visited all nodes.
