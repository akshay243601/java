package com.akshay.graph.airportConnection;


import java.util.*;

/**
 * Airport Connections - Extremely Hard 2
 * Nice Explanation
 * https://drive.google.com/drive/u/0/folders/1-c-B5PjZkrEjl-9TNx5tFnP72L_rScSL
 *
 * https://github.com/bluepsyduck93/Coding-Problems/wiki/Algo-Expert-Extremely-Hard-2
 *
 * You are given a list of airports (three-letter codes like 'JFK'), a list of routes (one-way flights from one airport to another like ['JFK', 'SFO']), and a starting airport.
 *
 * Write a function that returns the minimum number of airport connections (one-way flights) that need to be added in order for someone to be able to reach any airport in the list, starting at the starting airport.
 *
 * Note that the connections don't have to be direct; it's okay if an airport can only be reached from the starting airport by stopping at other airports first.
 *
 *
 * Sample Input:
 *
 * [
 * "BGI",
 * "CDG",
 * "DEL",
 * "DOH",
 * "DSM",
 * "EWR",
 * "EYW",
 * "HDN",
 * "ICN",
 * "JFK",
 * "LGA",
 * "LHR",
 * "ORD",
 * "SAN",
 * "SFO",
 * "SIN",
 * "TLV",
 * "BUD,
 * "HND"
 * ],
 * [
 * ["DSM","ORD"],
 * ["ORD","BGI"],
 * ["BGI","LGA"],
 * ["SIN","CDG"],
 * ["CDG","SIN"],
 * ["CDG","BUD"],
 * ["DEL","DOH"],
 * ["DEL","CDG"],
 * ["TLV","DEL"],
 * ["EWR","HND"],
 * ["HND","ICN"],
 * ["HND","JFK"],
 * ["ICN","JFK"],
 * ["JFK","LGA"],
 * ["EYW","LHR"],
 * ["LHR","SFO"],
 * ["SFO","SAN"],
 * ["SFO", "DSM"],
 * ["SAN","EYW"]
 * ],
 * "LGA"
 *
 *
 * Sample output: 3
 *
 *
 *
 * **/
public class AirportConnectionGraphDemo {


    /***
     * Steps to find out the Minimum connections required to reach each airport from starting point
     *
     * 1. Create Airport Graph from Airport List and Routes
     * 2. Get List of Visited Nodes (Reachable Airports) using dfs
     * 3. Prepare list of non-reachable Airport
     * 4. Prepare unreachableAirportConnection from unreachableAirport using again DFS
     * 5. Prepare count for unreachableAirport  by sorting them in Descending order based on number of unreachable connection
     *
     * *****/
    private static int airportConnections(List<String> airports, List<String[]> routes, String startedPoint) {
        HashMap<String, AirportNode> airportGraph = createAirportGraph(airports, routes);
        List<AirportNode> unreachableAirportNodes = getUnreachableAirportNodes(airportGraph, airports, startedPoint);
        markUnreachableConnections(airportGraph, unreachableAirportNodes);
        return getMinNumberOfNewConnections(airportGraph, unreachableAirportNodes);
    }

    private static HashMap<String, AirportNode> createAirportGraph(List<String> airports, List<String[]> routes) {
        HashMap<String, AirportNode> airportGraph = new HashMap<>();
        for (String airport : airports) {
            airportGraph.put(airport, new AirportNode(airport));
        }
        for (String[] route : routes) {
            String source = route[0];
            String destination = route[1];
            airportGraph.get(source).connections.add(destination);
        }
        return airportGraph;
    }

    // Get List of Unreachable Nodes.
    private static List<AirportNode> getUnreachableAirportNodes(HashMap<String, AirportNode> airportGraph, List<String> airports, String startedPoint) {

        // Prepare List of Reachable Nodes
        Set<String> visitedAirport = new HashSet<>();
        depthFirstTraverseAirports(airportGraph, startedPoint, visitedAirport);

        //Prepare List of UnReachable Nodes
        List<AirportNode> unreachableAirportNodes = new ArrayList<>();
        for(String airport : airports) {
            if(visitedAirport.contains(airport)) {
                continue;
            }
            AirportNode airportNode = airportGraph.get(airport);
            airportNode.isReachable = false;
            unreachableAirportNodes.add(airportNode);
        }
        return unreachableAirportNodes;
    }

    // Similiar to DFS only.
    private static void depthFirstTraverseAirports(HashMap<String, AirportNode> airportGraph, String airport, Set<String> visitedAirport) {
        if(visitedAirport.contains(airport)) {
            return;
        }
        visitedAirport.add(airport);
        airportGraph.get(airport).isReachable = true;
        for(String connectedAirport : airportGraph.get(airport).connections) {
            depthFirstTraverseAirports(airportGraph, connectedAirport, visitedAirport);
        }

    }

    private static void markUnreachableConnections(HashMap<String, AirportNode> airportGraph, List<AirportNode> unreachableAirportNodes) {
        for (AirportNode airportNode : unreachableAirportNodes) {
            String airport = airportNode.airport;
            List<String> unreachableConnections = new ArrayList<>();
            Set<String> visitedAirports = new HashSet<String>();
            depthFirstAddUnreachableConnection(airportGraph, unreachableConnections, airport, visitedAirports);
            airportNode.unreachableConnections = unreachableConnections;

        }
    }

    private static void depthFirstAddUnreachableConnection(HashMap<String, AirportNode> airportGraph, List<String> unreachableConnections, String airport, Set<String> visitedAirports) {
        if(visitedAirports.contains(airport)) {
            return;
        }

        if(airportGraph.get(airport).isReachable) {
            return;
        }

        visitedAirports.add(airport);
        unreachableConnections.add(airport);

        for(String connectedAirport : airportGraph.get(airport).connections) {
            depthFirstAddUnreachableConnection(airportGraph, unreachableConnections, connectedAirport, visitedAirports);
        }
    }

    private static int getMinNumberOfNewConnections(HashMap<String, AirportNode> airportGraph, List<AirportNode> unreachableAirportNodes) {
        unreachableAirportNodes.sort(
                (a1, a2) -> a2.unreachableConnections.size() -  a1.unreachableConnections.size());

        int numberOfConnection = 0;
        for(AirportNode airportNode : unreachableAirportNodes) {
            if(airportNode.isReachable) {
                continue;
            }
            numberOfConnection = numberOfConnection + 1;
            for(String connectedAirport : airportNode.connections) {
                airportGraph.get(connectedAirport).isReachable = true;
            }
        }


        return numberOfConnection;
    }



    public static void main(String[] args) {
        List<String> airports =  Arrays.asList(
                                                "BGI",
                                                "CDG",
                                                "DEL",
                                                "DOH",
                                                "DSM",
                                                "EWR",
                                                "EYW",
                                                "HDN",
                                                "ICN",
                                                "JFK",
                                                "LGA",
                                                "LHR",
                                                "ORD",
                                                "SAN",
                                                "SFO",
                                                "SIN",
                                                "TLV",
                                                "BUD",
                                                "HND"
                                        );

        List<String[]> routes = new ArrayList<>();
        routes.add(new String[]{"DSM","ORD"});
        routes.add(new String[]{"ORD","BGI"});
        routes.add(new String[]{"BGI","LGA"});
        routes.add(new String[]{"SIN","CDG"});
        routes.add(new String[]{"CDG","SIN"});
        routes.add(new String[]{"CDG","BUD"});
        routes.add(new String[]{"DEL","DOH"});
        routes.add(new String[]{"DEL","CDG"});
        routes.add(new String[]{"TLV","DEL"});
        routes.add(new String[]{"EWR","HND"});
        routes.add(new String[]{"HND","ICN"});
        routes.add(new String[]{"HND","JFK"});
        routes.add(new String[]{"ICN","JFK"});
        routes.add(new String[]{"JFK","LGA"});
        routes.add(new String[]{"EYW","LHR"});
        routes.add(new String[]{"LHR","SFO"});
        routes.add(new String[]{"SFO","SAN"});
        routes.add(new String[]{"SFO", "DSM"});
        routes.add(new String[]{"SAN", "EYW"});
        String startedAirport = "LGA";
        System.out.println(airportConnections(airports, routes, startedAirport));
    }
}
