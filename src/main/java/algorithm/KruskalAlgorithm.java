package algorithm;

import element.Edge;
import element.Graph;

import java.util.*;

public class KruskalAlgorithm {
    public static class Result {
        public List<Edge> mstEdges;
        public int totalCost;
        public int operations;
        public long timeMs;
    }

    private static class UnionFind {
        private final Map<String, String> parent = new HashMap<>();

        public String find(String v) {
            if (!parent.get(v).equals(v))
                parent.put(v, find(parent.get(v)));
            return parent.get(v);
        }

        public void union(String a, String b) {
            String rootA = find(a);
            String rootB = find(b);
            if (!rootA.equals(rootB))
                parent.put(rootB, rootA);
        }

        public void makeSet(Collection<String> nodes) {
            for (String v : nodes)
                parent.put(v, v);
        }
    }

    public static Result findMST(Graph graph) {
        long start = System.nanoTime();
        Result result = new Result();
        result.mstEdges = new ArrayList<>();
        result.totalCost = 0;
        result.operations = 0;

        UnionFind uf = new UnionFind();
        uf.makeSet(graph.nodes);

        List<Edge> edges = new ArrayList<>(graph.edges);
        Collections.sort(edges);
        result.operations += edges.size();

        for (Edge e : edges) {
            result.operations++;
            String rootA = uf.find(e.from);
            String rootB = uf.find(e.to);
            if (!rootA.equals(rootB)) {
                uf.union(e.from, e.to);
                result.mstEdges.add(e);
                result.totalCost += e.weight;
            }
            if (result.mstEdges.size() == graph.nodes.size() - 1) break;
        }

        result.timeMs = (System.nanoTime() - start) / 1_000_000;
        return result;
    }
}
