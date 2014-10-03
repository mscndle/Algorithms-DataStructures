package com.mcondle.Graph;

import java.util.*;

public class BFSIterator implements Iterator<String> {

    private Set<String> visited;
    private Queue<String> queue;
    private Graph G;
//    private List<String> bfsNodes;

    public BFSIterator(Graph G, String origin) {
        this.G = G;
        this.visited = new HashSet<String>();
        this.queue = new LinkedList<String>();
        this.queue.add(origin);
    }

/*  NO POINT IN DOING THE ENTIRE BFS IN THE CONSTRUCTOR  */
/*  KEEP THE CONSTRUCTOR COMPUTATIONALLY LIGHT           */

//    public void doBfsTraversal(Graph G, List<String> bfsNodes, Queue<String> queue) {
//        List<String> neighbors = new ArrayList<String>();
//
//        while (!queue.isEmpty()) {
//            String node = queue.remove();
//            bfsNodes.add(node);
//            neighbors = G.getNeighbors(node);
//
//            queue.addAll(neighbors);
//
//            //mark visited
//            this.visited.add(node);
//            this.visited.addAll(neighbors);
//        }
//    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasNext() {
        return !this.queue.isEmpty();
    }

    @Override
    public String next() {

        String next = this.queue.remove();  //removes first
        for (String neighbor : G.getNeighbors(next)) {
            if (!this.visited.contains(neighbor)) {
                this.queue.add(neighbor);
                this.visited.add(neighbor);
            }
        }
        this.visited.add(next);
        return next;

    }
}
