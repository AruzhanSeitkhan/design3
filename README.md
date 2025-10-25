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


### Algorithm Implementations

#### Prim’s Algorithm

Builds MST starting from one node.

Uses a priority queue to pick the smallest edge leading to an unvisited vertex.

Tracks operations and execution time.

#### Kruskal’s Algorithm

Sorts all edges by weight.

Uses a Union-Find (Disjoint Set) structure to avoid cycles.

Selects edges connecting different components until MST has V - 1 edges.

#### Both algorithms record:

mst_edges

total_cost

operations_count

execution_time_ms

### Input Dataset Example (assign_3_input.json)

{

  "graphs": [
  
    {
    
      "id": 1,
      
      "nodes": ["A", "B", "C", "D", "E"],
      
      "edges": [
      
        {"from": "A", "to": "B", "weight": 3},
        
        {"from": "A", "to": "C", "weight": 5},
        
        {"from": "B", "to": "C", "weight": 2},
        
        {"from": "B", "to": "D", "weight": 6},
        
        {"from": "C", "to": "E", "weight": 4},
        
        {"from": "D", "to": "E", "weight": 7}
        
      ]
      
    },
    
    {
      "id": 2,
      
      "nodes": ["P", "Q", "R", "S", "T"],
      
      "edges": [
      
        {"from": "P", "to": "Q", "weight": 1},
        
        {"from": "P", "to": "R", "weight": 5},
        
        {"from": "Q", "to": "R", "weight": 2},
        
        {"from": "Q", "to": "S", "weight": 3},
        
        {"from": "R", "to": "T", "weight": 4},
        
        {"from": "S", "to": "T", "weight": 6}
        
      ]
      
    }
    
  ]
  
}

### Output Example (assign_3_output.json)

{
  "results": [
  
    {
      "graph_id": 1,
      
      "input_stats": {"vertices": 5, "edges": 6},
      
      "prim": {
      
        "total_cost": 15,
        
        "operations_count": 21,
        
        "execution_time_ms": 3
        
      },
      
      "kruskal": {
      
        "total_cost": 15,
        
        "operations_count": 11,
        
        "execution_time_ms": 42
        
      }
      
    },
    
    {
      "graph_id": 2,
      
      "input_stats": {"vertices": 5, "edges": 6},
      
      "prim": {
      
        "total_cost": 10,
        
        "operations_count": 19,
        
        "execution_time_ms": 0
        
      },
      
      "kruskal": {
      
        "total_cost": 10,
        
        "operations_count": 10,
        
        "execution_time_ms": 0
        
      }
      
    }
    
  ]
  
}

### Result Analysis

For Graph 1 , both algorithms produced the same Minimum Spanning Tree (MST) cost of 15.

Prim’s algorithm performed 21 operations and completed in 3 milliseconds.

Kruskal’s algorithm also achieved an MST cost of 15, but it required only 11 operations and took 42 milliseconds to execute.

For Graph 2, both algorithms again produced identical MST costs of 10.

Prim’s algorithm needed 19 operations and executed almost instantly (0 milliseconds).

Kruskal’s algorithm reached the same cost with 10 operations and also executed in 0 milliseconds.

### Testing Summary

Verified MST correctness (total_cost, V−1 edges, acyclic, connected).

Checked operation counts and timing for reproducibility.

Input/output fully automated with JSON.

Both algorithms passed all correctness tests.

### Conclusion

Both Prim’s and Kruskal’s algorithms produced identical MST costs, confirming their correctness. While the tree structure may differ, the total cost remains the same.

Prim’s algorithm works better for dense graphs, as it efficiently handles many connected edges using a priority queue.
Kruskal’s algorithm performs faster on sparse graphs, thanks to its simple edge-sorting and Union-Find approach.

For large real-world networks, especially those with fewer connections, Kruskal’s is typically more practical, whereas Prim’s is better suited for dense or adjacency-based graphs. Both algorithms are reliable and efficient, with performance depending on the graph’s structure.
