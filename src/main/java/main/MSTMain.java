package main;

import algorithm.KruskalAlgorithm;
import algorithm.PrimAlgorithm;
import element.Edge;
import element.Graph;
import com.google.gson.*;
import java.io.*;
import java.util.*;

public class MSTMain {
    public static void main(String[] args) throws Exception {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonObject input = JsonParser.parseReader(new FileReader("assign_3_input.json")).getAsJsonObject();
        JsonArray graphs = input.getAsJsonArray("graphs");
        JsonArray results = new JsonArray();

        for (JsonElement graphElem : graphs) {
            JsonObject gObj = graphElem.getAsJsonObject();
            int id = gObj.get("id").getAsInt();

            List<String> nodes = new ArrayList<>();
            for (JsonElement n : gObj.getAsJsonArray("nodes"))
                nodes.add(n.getAsString());

            List<Edge> edges = new ArrayList<>();
            for (JsonElement e : gObj.getAsJsonArray("edges")) {
                JsonObject eo = e.getAsJsonObject();
                edges.add(new Edge(eo.get("from").getAsString(), eo.get("to").getAsString(), eo.get("weight").getAsInt()));
            }

            Graph graph = new Graph(nodes, edges);

            var prim = PrimAlgorithm.findMST(graph);
            var kruskal = KruskalAlgorithm.findMST(graph);

            JsonObject out = new JsonObject();
            out.addProperty("graph_id", id);

            JsonObject stats = new JsonObject();
            stats.addProperty("vertices", nodes.size());
            stats.addProperty("edges", edges.size());
            out.add("input_stats", stats);

            out.add("prim", makeAlgoResult(prim, gson));
            out.add("kruskal", makeAlgoResult(kruskal, gson));

            results.add(out);
        }

        JsonObject output = new JsonObject();
        output.add("results", results);

        try (FileWriter fw = new FileWriter("assign_3_output.json")) {
            gson.toJson(output, fw);
        }

        System.out.println("✅ Results saved to assign_3_output.json");
    }

    private static JsonObject makeAlgoResult(Object resObj, Gson gson) {
        JsonObject o = new JsonObject();
        if (resObj instanceof PrimAlgorithm.Result r) {
            o.add("mst_edges", gson.toJsonTree(r.mstEdges));
            o.addProperty("total_cost", r.totalCost);
            o.addProperty("operations_count", r.operations);
            o.addProperty("execution_time_ms", r.timeMs);
        } else if (resObj instanceof KruskalAlgorithm.Result r) {
            o.add("mst_edges", gson.toJsonTree(r.mstEdges));
            o.addProperty("total_cost", r.totalCost);
            o.addProperty("operations_count", r.operations);
            o.addProperty("execution_time_ms", r.timeMs);
        }
        return o;
    }
}
