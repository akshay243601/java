package com.akshay.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
 *
 * We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
 *
 * Example 1:
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * Output: 2
 *
 * Example 2:
 * Input: times = [[1,2,1]], n = 2, k = 1
 * Output: 1
 *
 *  Example 3:
 * Input: times = [[1,2,1]], n = 2, k = 2
 * Output: -1
 *
 * **/
public class NetworkDelayTimeUsingBFS {


    // Here we are using the bfs.
    public static int networkDelayTime(int[][] times, int n, int k) {

        //Prepare a Start -> {End -> distance} map.
        Map<Integer, Map<Integer, Integer>> toFromDist = new HashMap<>();
        for(int[] toDistArr : times) {
            int from = toDistArr[0];
            int to = toDistArr[1];
            int dist = toDistArr[2];
            toFromDist.putIfAbsent(from, new HashMap<>());
            toFromDist.get(from).put(to, dist);
        }

        //This will sort based on distance while storing data into queue
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        //Store node with distance
        queue.add(new int[]{k, 0});

        // Just to store the output
        int res = 0;

        boolean[] visited = new boolean[n+1];

        while(!queue.isEmpty()) {
            int[] currNodeData = queue.remove();
            int currNode = currNodeData[0];
            int currDist = currNodeData[1];

            if(visited[currNode])
                continue;

            visited[currNode] = true;

            n--;

            res = Math.max(currDist, res);

            // this will ensure that signal reach to every terminal
            if(n == 0)
                return res;

            if(toFromDist.containsKey(currNode)) {
                for(Integer next : toFromDist.get(currNode).keySet()) {
                    int dist = currDist + toFromDist.get(currNode).get(next);  //1--> 2 [weight : 4]  -> dist = 4
                    queue.add(new int[] {next, dist});
                }
            }
        }

        // n==0 this will ensure that signal reach to every terminal
        return n == 0 ? res : -1;
    }

    public static void main(String[] args) {
        int[][] fromToArray = new int[][]
                {
                        {2, 1, 1},
                        {2, 3, 1},
                        {3, 4, 1}
                };
        int numberOfVertexes = 4;
        int startedPoint = 2;
        System.out.println(networkDelayTime(fromToArray, numberOfVertexes, startedPoint));


        fromToArray = new int[][]
                {
                        {1, 2, 1}
                };
        numberOfVertexes = 2;
        startedPoint = 1;
        System.out.println(networkDelayTime(fromToArray, numberOfVertexes, startedPoint));


        fromToArray = new int[][]
                {
                        {1, 2, 1}
                };
        numberOfVertexes = 2;
        startedPoint = 2;
        System.out.println(networkDelayTime(fromToArray, numberOfVertexes, startedPoint));

    }


}
