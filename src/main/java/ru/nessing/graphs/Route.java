package ru.nessing.graphs;

// Данный класс создан для того что бы уйти от Листа в котором содержаться Листы

import java.util.ArrayList;
import java.util.List;

public class Route {
    private List<Integer> route;
    public Route() {
        this.route = new ArrayList<>();
    }

    public List<Integer> getRoute() {
        return route;
    }

    public void setRoute(List<Integer> route) {
        this.route = route;
    }

    public void addPoint(Integer idx){
        route.add(idx);
    }

    public void removeLastPoint(){
        int size = route.size();
        if(size == 0) return;
        route.remove(size-1);
    }

    public boolean contains(Integer idx) {
        if(route.contains(idx)) return true;
        return false;
    }
}
