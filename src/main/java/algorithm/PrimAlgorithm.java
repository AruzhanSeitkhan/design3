package algorithm;

import element.Edge;
import element.Graph;
import java.util.*;

public class PrimAlgorithm {
    public static class Result {
        public List<Edge> mstEdges;
        public int totalCost;
        public int operations;
        public long timeMs;
    }

    public static Result findMST(Graph graph) {
        long start = System.nanoTime();
        Result result = new Result();
        result.mstEdges = new ArrayList<>();
        result.totalCost = 0;
        result.operations = 0;

        Set<String> visited = new HashSet<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        String startNode = graph.nodes.get(0);
        visited.add(startNode);
        pq.addAll(graph.getEdges(startNode));
        result.operations += graph.getEdges(startNode).size();

        while (!pq.isEmpty() && result.mstEdges.size() < graph.nodes.size() - 1) {
            Edge edge = pq.poll();
            result.operations++;
            String next = null;

            if (!visited.contains(edge.to) && visited.contains(edge.from)) next = edge.to;
            else if (!visited.contains(edge.from) && visited.contains(edge.to)) next = edge.from;

            if (next != null) {
                visited.add(next);
                result.mstEdges.add(edge);
                result.totalCost += edge.weight;
                for (Edge e : graph.getEdges(next)) pq.add(e);
                result.operations += graph.getEdges(next).size();
            }
        }

        result.timeMs = (System.nanoTime() - start) / 1_000_000;
        return result;
    }
}

