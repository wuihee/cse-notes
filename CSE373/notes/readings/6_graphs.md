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
