# Graph Data Type

## Runtime of Printing Edges

- The runtime of printing all edges in an adjacency list is $\Theta(|V| + |E|)$.

```java
for (Point p : neighbors.keySet()) {
    for (Edge<Point> e : neighbors.get(p)) {
        System.out.println(e.from + "→" + e.to);
    }
}
```

## Number of Edges

- If an *undirected* graph has $|V|$ vertices, the number of edges it has is:

    $(|V| - 1) + (|V| - 2) + ... + 2 + 1 \approx \frac{|V|(|V| - 1)}{2}$

- If a *directed graph* has $|V|$ vertices, the number of edges it has is:

    $|V|(|V| - 1)$

- To print all edges in a graph would take $\Theta(|V|^2)$ time.
