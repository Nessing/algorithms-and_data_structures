package ru.nessing.graphs;

import java.util.List;

public interface Graph {

    void addVertex(String label);

    boolean addEdge(String startLabel, String secondLabel, String... others);
    boolean addEdge(String startLabel, String secondLabel);
    boolean addEdge(String startLabel, String secondLabel, int distance);

    int getSize();

    void display();

    List<Route> searchOfRoutes(String startLabel, String finishLabel);

    void showRoutes(List<Route> routes);

    void displayAdjacencyMatrix();

    /**
     * англ. Depth-first search, DFS
     */
    void dfs(String startLabel);

    /**
     * англ. breadth-first search, BFS
     */
    void bfs(String startLabel);

    void calcDistance(String startLabel);

}
