package org.hsmak.datastructures.graph;

import java.util.*;
import java.util.function.Consumer;

/*
 * Representations:
 *      - AdjacencyMatrix
 *      - AdjacencyList
 */
public class AdjacencyMapGraph<V> {

    private Map<Vertex, List<Vertex>> adjMap;

    AdjacencyMapGraph() {
        this.adjMap = new HashMap<>();
    }

    public static void main(String[] args) {
        AdjacencyMapGraph<String> graph = new AdjacencyMapGraph<>();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");

        System.out.println("PrintGraph():");
        System.out.println(graph.printGraph());

        graph.breadthFirstTraversal("Bob", System.out::println);
        System.out.println();
        graph.depthFirstTraversal("Bob", System.out::println);

        System.out.println();
        graph.removeVertex("Maria");

        graph.breadthFirstTraversal("Bob", System.out::println);
        System.out.println();
        graph.depthFirstTraversal("Bob", System.out::println);


    }

    void addVertex(V val) {
        Vertex newV = new Vertex(val);
        adjMap.putIfAbsent(newV, new ArrayList<>());
    }

    void addEdge(V val1, V val2) {
        Vertex ver1 = new Vertex(val1);
        Vertex ver2 = new Vertex(val2);
        adjMap.get(ver1).add(ver2);
        adjMap.get(ver2).add(ver1);
    }

    void removeVertex(V val) {
        Vertex toBeRemovedVert = new Vertex(val);
        adjMap.values().forEach(e -> e.remove(toBeRemovedVert));
        adjMap.remove(toBeRemovedVert);
    }

    void removeEdge(V val1, V val2) {
        Vertex ver1 = new Vertex(val1);
        Vertex ver2 = new Vertex(val2);

        List<Vertex> edgesOfV1 = adjMap.get(ver1);
        List<Vertex> edgesOfV2 = adjMap.get(ver2);
        if (edgesOfV1 != null)
            edgesOfV1.remove(ver2);
        if (edgesOfV2 != null)
            edgesOfV2.remove(ver1);
    }

    List<Vertex> getAdjVertices(V val) {
        return adjMap.get(new Vertex(val));
    }

    String printGraph() {
        StringBuffer sb = new StringBuffer();
        for (Vertex v : adjMap.keySet())
            sb.append(v.val).append(" -> ").append(adjMap.get(v)).append(" ");
        return sb.toString();
    }

    /* ********************
     *      Traversal
     * ********************/

    Set<V> depthFirstTraversal(V root, Consumer<V> c) {
        Set<V> visited = new LinkedHashSet<>();
        Stack<V> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            V val = stack.pop();
            if (!visited.contains(val)) {
                visited.add(val);
                c.accept(val);
                for (Vertex v : getAdjVertices(val)) {
                    stack.push(v.val);
                }
            }
        }
        return visited;
    }

    Set<V> breadthFirstTraversal(V root, Consumer<V> c) {
        Set<V> visited = new LinkedHashSet<>();
        Queue<V> queue = new LinkedList<>();

        queue.add(root);
        visited.add(root);
        c.accept(root);
        while (!queue.isEmpty()) {
            V val = queue.poll();
            for (Vertex ver : getAdjVertices(val)) {
                if (!visited.contains(ver.val)) {
                    visited.add(ver.val);
                    c.accept(ver.val);
                    queue.add(ver.val);
                }
            }
        }
        return visited;
    }

    class Vertex {
        V val;

        Vertex(V val) {
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex vertex = (Vertex) o;
            return Objects.equals(val, vertex.val);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val);
        }

        @Override
        public String toString() {
            return val.toString();
        }
    }
}
