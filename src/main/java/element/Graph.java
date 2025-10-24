package element;

import java.util.*;

public class Graph {
    public List<String> nodes;
    public List<Edge> edges;

    public Graph(List<String> nodes, List<Edge> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    public List<Edge> getEdges(String node) {
        List<Edge> result = new ArrayList<>();
        for (Edge e : edges) {
            if (e.from.equals(node) || e.to.equals(node)) result.add(e);
        }
        return result;
    }
}
