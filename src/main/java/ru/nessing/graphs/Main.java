package ru.nessing.graphs;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        testGraph();
//        testDfs();
//        testBfs();
        calcDistance();
    }

    private static void testGraph() {

        Graph graph = new GraphImpl(7);

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdge("A", "B", "C");
        graph.addEdge("B", "C", "D");
        graph.addEdge("C", "A", "B", "D");
        graph.addEdge("D", "B", "C");

        System.out.println("Size of graph is " + graph.getSize());
        graph.display();
    }

    private static void testDfs() {
        Graph graph = new GraphImpl(7);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");

        graph.addEdge("A", "B", "C", "D");
        graph.addEdge("B", "E");
        graph.addEdge("D", "F");
        graph.addEdge("F", "G");

        graph.dfs("A");
    }

    private static void testBfs() {
        Graph graph = new GraphImpl(8);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");

        graph.addEdge("A", "B", "C", "D");
        graph.addEdge("B", "E");
        graph.addEdge("E", "H");
        graph.addEdge("C", "F");
        graph.addEdge("D", "G");

        graph.bfs("A");
    }

    private static void calcDistance() {
        Graph graph = new GraphImplCityDistance(10);

        List<Route> routes;

        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Орёл");
        graph.addVertex("Липецк");
        graph.addVertex("Тамбов");
        graph.addVertex("Курск");
        graph.addVertex("Саратов");
        graph.addVertex("Воронеж");

        graph.addEdge("Москва", "Тула", 188);
        graph.addEdge("Москва", "Рязань", 196);
        graph.addEdge("Москва", "Калуга", 185);
        graph.addEdge("Тула", "Орёл", 184);
        graph.addEdge("Тула", "Липецк", 268);
        graph.addEdge("Рязань", "Липецк", 260);
        graph.addEdge("Рязань", "Тамбов", 277);
        graph.addEdge("Калуга", "Орёл", 216);
        graph.addEdge("Орёл", "Липецк", 281);
        graph.addEdge("Орёл", "Курск", 163);
        graph.addEdge("Липецк", "Тамбов", 149);
        graph.addEdge("Липецк", "Воронеж", 131);
        graph.addEdge("Тамбов", "Саратов", 386);
        graph.addEdge("Тамбов", "Воронеж", 221);
        graph.addEdge("Курск", "Воронеж", 224);
        graph.addEdge("Саратов", "Воронеж", 511);

        graph.displayAdjacencyMatrix();

        routes = graph.searchOfRoutes("Москва", "Воронеж");

        graph.showRoutes(routes);
    }
}
