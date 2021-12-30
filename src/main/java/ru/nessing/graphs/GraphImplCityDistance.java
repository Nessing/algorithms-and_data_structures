package ru.nessing.graphs;

import java.util.*;

public class GraphImplCityDistance implements Graph {

    private final List<Vertex> vertexList;
    private final int[][] adjMatrix;

    public GraphImplCityDistance(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new int[maxVertexCount][maxVertexCount];
    }

    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel) {

        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }
        return true;
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, int distance) {

        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }
        adjMatrix[startIndex][endIndex] = distance;
        return true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, String... others) {
        boolean result = addEdge(startLabel, secondLabel);

        for (String other : others) {
            result &= addEdge(startLabel, other);
        }

        return result;
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public List<Route> searchOfRoutes(String startLabel, String finishLabel) {
        int startIndex = indexOf(startLabel);

        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина: " + startLabel);
        }
        Stack<Tracker> stack = new Stack<>();
        List<Route> routes = new ArrayList<>();                 // Лист с маршрутами
        Route route = new Route();                              // Маршрут
        Tracker tracker = new Tracker(startIndex, getSize());   // Трекер - объект с указателями по ajdMatrix

        stack.push(tracker);

        while (!stack.isEmpty()) {
            while (tracker.isActive()) {
                // Проверка по матрице, есть ли переход в другую точку?
                if (adjMatrix[tracker.getLocation()][tracker.getIndex()] != 0) {
                    // Запрет на повторное внесение точки в маршрут после возврата с более нижненго уровня
                    if(!route.contains(tracker.getLocation()))
                        route.addPoint(tracker.getLocation()); // Внесение точки в маршрут
                    // Проверка на достижение финиша маршрута
                    if (vertexList.get(tracker.getIndex()).getLabel().equals(finishLabel)) {
                        route.addPoint(indexOf(finishLabel)); //  Внесение финишной точки в маршрут
                        // копирование найденого маршрута в лист с результатами
                        List<Integer> routeList = new ArrayList<>();
                        routeList.addAll(route.getRoute());
                        Route rt = new Route();
                        rt.setRoute(routeList);
                        routes.add(rt);
                        // Удаляем финишную точку из маршрута, та как проходить по её строке не надо проходить
                        route.removeLastPoint();
                        tracker.next();
                    }
                    else {
                        //route.addPoint(tracker.getLocation());
                        stack.push(tracker);
                        int idx = tracker.getIndex();
                        tracker = new Tracker(idx, getSize());
                    }
                }
                else tracker.next();
            }
            route.removeLastPoint();
            tracker = stack.pop();
            tracker.next();
        }
        return routes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getSize(); i++) {
            sb.append(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMatrix[i][j] != 0) {
                    sb.append(" -> ").append(vertexList.get(j));
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина: " + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);
        resetVertexVisited();

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {

                stack.pop();
            }
        }
    }

    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);
        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i] != 0 && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }
        return null;
    }

    private void resetVertexVisited() {
        for (Vertex vertex : vertexList) {
            vertex.setVisited(false);
        }
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.println(vertex.getLabel() + " ");
        stack.add(vertex);
        vertex.setVisited(true);
    }

    private void visitVertex(Queue<Vertex> queue, Vertex vertex) {
        System.out.println(vertex.getLabel() + " ");
        queue.add(vertex);
        vertex.setVisited(true);
    }

    public void showRoutes(List<Route> routes) {
        Integer[] lengths;
        lengths = calcLength(routes);

        System.out.print("\n\tСписок всех маршрутов");
        for (int i = 0; i < routes.size(); i++) {
            int start = routes.get(i).getRoute().get(0);
            int finish;
            System.out.printf("\nМаршрут № %2d. Общая протяжённость: %4d км. Маршрут:%8s",
                    i+1, lengths[i], vertexList.get(routes.get(i).getRoute().get(0)));
            for (int j = 1; j < routes.get(i).getRoute().size(); j++) {
                finish = routes.get(i).getRoute().get(j);
                System.out.printf(" - %3d -> %8s", adjMatrix[start][finish], vertexList.get(routes.get(i).getRoute().get(j)));
                start = finish;
            }
        }

        List<Integer> shortestRoutes;
        shortestRoutes = findMin(lengths);

        System.out.print("\n\n\tСписок самых коротких маршрутов");
        for (int i: shortestRoutes) {
            int start = routes.get(i).getRoute().get(0);
            int finish;
            System.out.printf("\nМаршрут № %2d. Общая протяжённость: %4d км. Маршрут:%8s",
                    i+1, lengths[i], vertexList.get(routes.get(i).getRoute().get(0)));
            for (int j = 1; j < routes.get(i).getRoute().size(); j++) {
                finish = routes.get(i).getRoute().get(j);
                System.out.printf(" - %3d -> %8s", adjMatrix[start][finish], vertexList.get(routes.get(i).getRoute().get(j)));
                start = finish;
            }
        }
    }

    public void displayAdjacencyMatrix() {
        String empty = " ";
        System.out.printf("\n%8s", empty);
        for (int i = 0; i < vertexList.size(); i++) {
            System.out.printf("%8s", vertexList.get(i).getLabel());
        }

        for (int i = 0; i < vertexList.size(); i++) {
            System.out.printf("\n%8s", vertexList.get(i).getLabel());
            for (int j = 0; j < vertexList.size(); j++) {
                System.out.printf("%8d", adjMatrix[i][j]);
            }
        }
        System.out.printf("\n\n");
    }

    private Integer[] calcLength(List<Route> ways) {
        Integer[] lengths = new Integer[ways.size()];

        for (int i = 0; i < ways.size(); i++) {
            int sum = 0;
            int start = ways.get(i).getRoute().get(0);
            int finish;
            for (int j = 1; j < ways.get(i).getRoute().size(); j++) {
                finish = ways.get(i).getRoute().get(j);
                sum += adjMatrix[start][finish];
                start = finish;
            }
            lengths[i] = sum;
        }
        return lengths;
    }

    private List<Integer> findMin(Integer[] lengths) {
        List<Integer> result = new ArrayList<>();
        int min = lengths[0];
        result.add(0);

        for (int i = 1; i < lengths.length; i++) {
            if(lengths[i] < min) {
                min = lengths[i];
                result.clear();
                result.add(i);
            }
            else if(lengths[i] == min) result.add(i);
        }
        return result;
    }

    @Override
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина: " + startLabel);
        }

        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);
        resetVertexVisited();

        visitVertex(queue, vertex);
        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex != null) {
                visitVertex(queue, vertex);
            } else {
                queue.remove();
            }
        }
    }

    @Override
    public void calcDistance(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина: " + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);
        resetVertexVisited();

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }
    }
}
