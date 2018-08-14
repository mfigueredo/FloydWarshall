# FloydWarshall


Implementation of the Floyd Warshall Algorithm for calculating the shortest path among all pairs of vertices in a graph based on the Cormem Book Algorithm.


The graph must be represented as an array ![M](http://latex.codecogs.com/gif.latex?M) where the weight of the edges ![i](http://latex.codecogs.com/gif.latex?i) and ![j](http://latex.codecogs.com/gif.latex?j) is given by the element ![mij](http://latex.codecogs.com/gif.latex?M_%7Bij%7D). When there was no link between the elements of a graph, the value adopted should be INF. The graph file must also contain the number of elements in the graph.


```
5
0 3 8 INF -4
INF 0 INF 1 7
INF 4 0 INF INF
2 INF -5 0 INF
INF INF INF 6 0
```

### Prerequisites

To run this project you should use  [JDK 1.8 or over](http://www.oracle.com/technetwork/java/javase/downloads/index.html).

### Running Tests

First, compile the Main java class running the following command:

```
$ javac Main.java
```

To generate a Red-Black Tree using a dictonary, just pass your dictonary as execution parameter and the way to show the result (1, 2 3).

```
$ java Main 1 grafo.txt
```

## Authors

* **Mickael Figueredo** - [mfigueredo](http://buscatextual.cnpq.br/buscatextual/visualizacv.do?id=K8741438E2)