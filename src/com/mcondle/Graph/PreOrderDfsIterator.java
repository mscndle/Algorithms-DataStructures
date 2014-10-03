package com.mcondle.Graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

public class PreOrderDFSIterator implements Iterator<String> {

    private Stack<String> stack;
    private Set<String> visited;
    private Graph G;

    public PreOrderDFSIterator(Graph G, String origin) {
        this.G = G;
        this.stack = new Stack<String>();
        this.visited = new HashSet<String>();
        this.stack.push(origin);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasNext() {
        return !this.stack.isEmpty();
    }

    @Override
    public String next() {
        String next = this.stack.pop();

        for (String s : this.G.getNeighbors(next)) {
            if (!this.visited.contains(s)) {
                this.stack.push(s);
                this.visited.add(s);
            }
        }
        this.visited.add(next);
        return next;
    }
}
