# Assignment 3 — Minimum Spanning Tree (MST)

### Objective

The purpose of this project is to implement and compare two algorithms that find the Minimum Spanning Tree (MST) of a weighted undirected graph:

Prim’s Algorithm

Kruskal’s Algorithm

The program reads graph data from a JSON file, finds MSTs using both algorithms, compares their performance, and writes the results into an output JSON file.

### File Descriptions

MSTMain.java — reads input, runs both algorithms, writes output results.

PrimAlgorithm.java — constructs MST using a greedy method with a priority queue.

KruskalAlgorithm.java — constructs MST by sorting edges and using Union-Find.

Graph.java — stores vertices and edges of a graph.

Edge.java — defines the connection between two nodes with a weight.

assign_3_input.json — contains graphs for testing.

assign_3_output.json — contains the MST results.

### How It Works

1. The program reads the input file assign_3_input.json.
2. For each graph, it loads nodes and edges.
3. It runs both Prim’s and Kruskal’s algorithms to find the MST.
4. For each algorithm, it records the following:
   
   4.1 MST edges

   4.2 Total MST cost

   4.3 Number of operations

   4.3 Execution time in milliseconds

   4.5 It writes all results into assign_3_output.json.

### Algorithm Descriptions

Prim’s Algorithm:

Starts with one vertex and repeatedly adds the smallest edge that connects a visited vertex to an unvisited vertex. Works well on dense graphs.

Kruskal’s Algorithm:

Sorts all edges by weight and adds them one by one, avoiding cycles using a Union-Find structure. Works well on sparse graphs.

### Conclusion

Kruskal’s algorithm is generally faster for sparse graphs (with fewer edges) because it sorts edges once and uses the Union-Find structure efficiently.

Prim’s algorithm performs better for dense graphs (with many edges) since it focuses on connecting vertices through the smallest edge at each step.

Overall, both algorithms demonstrate the principles of greedy optimization, but Kruskal’s algorithm is slightly more efficient in terms of operations and execution time in most test cases.
The project clearly illustrates how algorithm design choices affect performance and complexity.
