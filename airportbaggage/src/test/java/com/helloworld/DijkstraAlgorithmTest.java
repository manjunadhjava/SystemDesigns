package com.helloworld;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.helloworld.airportbaggage.DijkstraAlgorithm;
import com.helloworld.airportbaggage.model.Edge;
import com.helloworld.airportbaggage.model.Graph;
import com.helloworld.airportbaggage.model.Vertex;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class DijkstraAlgorithmTest {

    private Map<String, Vertex> nodeMap;
    private List<Edge> edges;

    @Test
    public void testExcute() {
    	nodeMap = new HashMap<>();
        edges = new ArrayList<>();
        String[] nodeList = {"Concourse_A_Ticketing"
        		, "A5"
        		, "BaggageClaim"
        		, "A10"
        		, "A1"
        		, "A2"
        		, "A3"
        		, "A4"
        		, "A6"
        		, "A7"
        		, "A8"
        		, "A9"};
        for (String node : nodeList) {
            Vertex vertex = new Vertex(node);
            nodeMap.put(node, vertex);
        }

        addLane("Edge_0", "Concourse_A_Ticketing", "A5", 5);
        addLane("Edge_1", "A5", "BaggageClaim", 5);
        addLane("Edge_2", "A5", "A10", 4);
        addLane("Edge_3", "A5", "A1", 6);
        addLane("Edge_4", "A1", "A2", 1);
        addLane("Edge_5", "A2", "A3", 1);
        addLane("Edge_6", "A3", "A4", 1);
        addLane("Edge_7", "A10", "A9", 1);
        addLane("Edge_8", "A9", "A8", 1);
        addLane("Edge_9", "A8", "A7", 1);
        addLane("Edge_10", "A7", "A6", 1);

        // Lets check from location Loc_1 to Loc_10
        Graph graph = new Graph(nodeMap, edges);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(nodeMap.get("Concourse_A_Ticketing"));
        List<Vertex> path = dijkstra.getPath(nodeMap.get("A1"));

        assertNotNull(path);
        assertTrue(path.size() > 0);

        for (Vertex vertex : path) {
            System.out.print(vertex + " ");
        }

    }

    private void addLane(String laneId, String sourceLoc, String destLoc,
            int duration) {
        Edge lane = new Edge(laneId,nodeMap.get(sourceLoc), nodeMap.get(destLoc), duration );
        edges.add(lane);
    }
}