# FloydWarshall


Implementation of the Floyd Warshall Algorithm for calculating the shortest path among all pairs of vertices in a graph.


The graph must be represented as an array M where the weight of the edges i and j is given by the element ![mij](http://latex.codecogs.com/gif.latex?M_%7Bij%7D). When there was no link between the elements of a graph, the value adopted should be INF. The graph file must also contain the number of elements in the graph.


```
5
0 3 8 INF -4
INF 0 INF 1 7
INF 4 0 INF INF
2 INF -5 0 INF
INF INF INF 6 0

```
