package com.akshay.graph.airportConnection;

import java.util.ArrayList;
import java.util.List;

public class AirportNode {
    String airport;
    List<String> connections = new ArrayList<>();
    boolean isReachable = true;
    List<String> unreachableConnections = new ArrayList<>();
    public AirportNode(String airport) {
        this.airport = airport;
    }

}
