package com.lintcode;

import java.util.*;

/**
 * @author: John
 * @date: 2020-03-26 21:58
 * @description: 137
 **/
public class OneThreeSeven {
    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        public UndirectedGraphNode(int label, List<UndirectedGraphNode> neighbors) {
            this.label = label;
            this.neighbors = neighbors;
        }

        public UndirectedGraphNode(int label) {
            this.label = label;
            neighbors = new ArrayList<>();
        }
    }

    private ArrayList<UndirectedGraphNode> getNode(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();

        queue.offer(node);
        set.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            for (UndirectedGraphNode neighbor : head.neighbors) {
                if (!set.contains(neighbor)) {
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return new ArrayList<UndirectedGraphNode>(set);
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }

        // use bfs algorithm to traverse the graph and get all nodes.
        ArrayList<UndirectedGraphNode> nodes = getNode(node);

        // copy nodes, store the old->new mapping information in a hash map
        HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();
        for (UndirectedGraphNode n : nodes) {
            mapping.put(n, new UndirectedGraphNode(n.label));
        }

        // copy neighbors(edges)
        for (UndirectedGraphNode n : nodes) {
            UndirectedGraphNode newNode = mapping.get(n);
            for (UndirectedGraphNode neighbor : n.neighbors) {
                UndirectedGraphNode newNeighbor = mapping.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
        return mapping.get(node);
    }

    //    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
//        if (node == null) {
//            return node;
//        }
//        ArrayList<UndirectedGraphNode> nodes = new ArrayList<>();
//        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
//
//        // clone nodes
//        nodes.add(node);
//        map.put(node, new UndirectedGraphNode(node.label));
//
//        int start = 0;
//        while (start < nodes.size()) {
//            UndirectedGraphNode head = nodes.get(start++);
//            for (int i = 0; i < head.neighbors.size(); i++) {
//                UndirectedGraphNode neighbor = head.neighbors.get(i);
//                if (!map.containsKey(neighbor)) {
//                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
//                    nodes.add(neighbor);
//                }
//            }
//        }
//
//        // clone neighbors
//        for (int i = 0; i < nodes.size(); i++) {
//           UndirectedGraphNode newNode = map.get(nodes.get(i));
//           for (int j = 0; j < nodes.get(i).neighbors.size(); j++) {
//              newNode.neighbors.add(map.get(nodes.get(i).neighbors.get(j)));
//           }
//        }
//        return map.get(node);
//    }
    public static void main(String[] args) {
//        UndirectedGraphNode one = new UndirectedGraphNode(1);
        OneThreeSeven oneThreeSeven = new OneThreeSeven();
        UndirectedGraphNode one = oneThreeSeven.new UndirectedGraphNode(1);
        UndirectedGraphNode two = oneThreeSeven.new UndirectedGraphNode(2);
        UndirectedGraphNode four = oneThreeSeven.new UndirectedGraphNode(4);
        UndirectedGraphNode three = oneThreeSeven.new UndirectedGraphNode(3);
        UndirectedGraphNode five = oneThreeSeven.new UndirectedGraphNode(5);

        List<UndirectedGraphNode> oneEdges = new ArrayList<>();
        List<UndirectedGraphNode> twoEdges = new ArrayList<>();
        List<UndirectedGraphNode> fourEdges = new ArrayList<>();
        List<UndirectedGraphNode> threeEdges = new ArrayList<>();
        List<UndirectedGraphNode> fiveEdges = new ArrayList<>();
        oneEdges.add(two);
        oneEdges.add(four);

        twoEdges.add(one);
        twoEdges.add(four);

        fourEdges.add(one);
        fourEdges.add(two);

        threeEdges.add(five);
        fiveEdges.add(three);

        one.neighbors = oneEdges;
        two.neighbors = twoEdges;
        three.neighbors = threeEdges;
        four.neighbors = fourEdges;
        five.neighbors = fiveEdges;

        oneThreeSeven.cloneGraph(one);

    }
}


