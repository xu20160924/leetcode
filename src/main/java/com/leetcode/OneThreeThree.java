package com.leetcode;

import com.lintcode.OneThreeSeven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: John
 * @date: 2020-03-27 09:30
 * @description: 133
 **/
public class OneThreeThree {

    class UndirectedGraphNode {
        public int val;
        public List<UndirectedGraphNode> neighbors;

        public UndirectedGraphNode() {
        }

        public UndirectedGraphNode(int val) {
            this.val = val;
        }

        public UndirectedGraphNode(int val, List<UndirectedGraphNode> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }

//    private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
//    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
//        return clone(node);
//    }
//
//    private UndirectedGraphNode clone(UndirectedGraphNode node) {
//        if (node == null) {
//            return null;
//        }
//        if (map.containsKey(node.val)) {
//            return map.get(node.val);
//        }
//        UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.val);
//        map.put(cloneNode.val, cloneNode);
//        for (UndirectedGraphNode neighbor : node.neighbors) {
//            cloneNode.neighbors.add(clone(neighbor));
//        }
//        return cloneNode;
//    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
        public Node(int val, List<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }


    public Node cloneGraph(Node node) {
        Map<Integer, Node> map = new HashMap<>();
        return clone(node, map);
    }

    private Node clone(Node node, Map<Integer, Node> map) {
        if (node == null) {
           return null;
        }
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }

        Node cloneNode = new Node(node.val, new ArrayList<>());
        map.put(cloneNode.val, cloneNode);
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(clone(neighbor, map));
        }
        return cloneNode;
    }

    public static void main(String[] args) {
        OneThreeThree oneThreeSeven = new OneThreeThree();
        OneThreeThree.Node one = oneThreeSeven.new Node(1);
        OneThreeThree.Node two = oneThreeSeven.new Node(2);
        OneThreeThree.Node four = oneThreeSeven.new Node(4);
        OneThreeThree.Node three = oneThreeSeven.new Node(3);
        OneThreeThree.Node five = oneThreeSeven.new Node(5);

        List<Node> oneEdges = new ArrayList<>();
        List<Node> twoEdges = new ArrayList<>();
        List<Node> fourEdges = new ArrayList<>();
        List<Node> threeEdges = new ArrayList<>();
        List<Node> fiveEdges = new ArrayList<>();
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

        Node node = oneThreeSeven.cloneGraph(one);
    }
}
