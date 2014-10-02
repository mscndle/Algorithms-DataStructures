package com.mcondle.Graph;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

/**
 *  Represents an undirected acyclic graph
 */
public class Graph {

    private Map<String, List<String>> edges;

    public Graph() {
        this.edges = new HashMap<String, List<String>>();
    }

    public void addEdge(String src, String dst) {
        List<String> srcNeighbors = this.edges.get(src);
        if (srcNeighbors == null) {
            this.edges.put(src,
                    srcNeighbors = new ArrayList<String>());
        }

        srcNeighbors.add(dst);
    }

    public List<String> getNeighbors(String src) {
        List<String> neighbors = this.edges.get(src);

        if (this.edges.containsKey(src)) {
            return Collections.unmodifiableList(neighbors);
        }
        return Collections.emptyList();
    }

    public Set<String> getVertices() {
        return this.edges.keySet();
    }

    public boolean isVertexInGraph(String ver) {
        return this.edges.containsKey(ver);
    }


}
