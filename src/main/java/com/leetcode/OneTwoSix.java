package com.leetcode;

import java.util.*;

/**
 * @author: John
 * @date: 2020-03-30 12:25
 * @description: 126
 **/
public class OneTwoSix {
//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        List<List<String>> res = new ArrayList<>();
//
//        if (wordList == null) {
//            return res;
//        }
//
//        if (beginWord.equals(endWord)) {
//            res.get(0).add(beginWord);
//            res.get(0).add(endWord);
//            return res;
//        }
//
//        int L = beginWord.length();
//        Map<String, List<String>> allComboDict = new HashMap<>();
//
//        wordList.forEach(word -> {
//            for (int i = 0; i < L; i++) {
//                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
//                List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
//                transformations.add(newWord);
//                allComboDict.put(word, transformations);
//            }
//        });
//
//        Queue<Pair<String, Integer>> queue = new LinkedList<>();
//        queue.add(new Pair<>(beginWord, 1));
//
//        Map<String, Boolean> visited = new HashMap<>();
//        visited.put(beginWord, true);
//
//        while (!queue.isEmpty()) {
//            Pair<String, Integer> pair = queue.remove();
//            String word = pair.getKey();
//            int value = pair.getValue();
//
//            for (int i = 0; i < L; i++) {
//                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
//
//                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
//
//                }
//            }
//        }

//        Queue<String> qBegin = new LinkedList<>();
//        Queue<String> qEnd = new LinkedList<>();
//        qBegin.add(beginWord);
//        qEnd.add(endWord);
//
//        Map<String, Integer> mapBegin = new HashMap<>();
//        Map<String, Integer> mapEnd = new HashMap<>();
//        mapBegin.put(beginWord, 1);
//        mapEnd.put(endWord, 1);
//
//        while (!qBegin.isEmpty() && !qEnd.isEmpty()) {
//
//        }

//    }

//    private int visiteNode(Queue<String> queue,
//                           Map<String, Integer> mapBegin,
//                           Map<String, Integer> mapEnd) {
//
//    }

//    public List<List<String>> findLadders(String start, String end, List<String> wordList) {
//        HashSet<String> dict = new HashSet<>();
//        List<List<String>> res = new ArrayList<>();
//        HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<>();  // Neighbors for every node
//        HashMap<String, Integer> distance = new HashMap<>(); // Distance of every node from the start node
//        ArrayList<String> solution = new ArrayList<>();
//
//        dict.add(start);
//        bfs(start, end, dict, nodeNeighbors, distance);
//        return res;
//    }
//
//    // BFS Trace every node's  distance from the start node (level by level)
//    private void bfs(String start, String end, Set<String> dict, HashMap<String,
//            ArrayList<String>> nodeNeighbors,
//            HashMap<String, Integer> distance) {
//
//        for (String str : dict) {
//            nodeNeighbors.put(str, new ArrayList<>());
//        }
//        Queue<String> queue = new LinkedList<>();
//        queue.offer(start);
//        distance.put(start, 0);
//
//        while (!queue.isEmpty()) {
//            int count = queue.size();
//            boolean foundEnd = false;
//            for (int i = 0; i < count; i++) {
//               String cur = queue.poll();
//               int curDistance = distance.get(cur);
//               ArrayList<String> neighbors = getNeighbors(cur, dict);
//
//               for (String neighbor : neighbors) {
//                   nodeNeighbors.get(cur).add(neighbor);
//                   if (!distance.containsKey(neighbor)) { // check if visited
//                       distance.put(neighbor, curDistance + 1);
//                       if (end.equals(neighbor)) { // Found the shortest path
//                           foundEnd = true;
//                       } else {
//                           queue.offer(neighbor);
//                       }
//                   }
//               }
//               if (foundEnd) {
//                   break;
//               }
//            }
//        }
//    }
//
//    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
//        ArrayList<String> res = new ArrayList<>();
//        char chs[] = node.toCharArray();
//        for (char ch = 'a'; ch <= 'z'; ch++) {
//            for (int i = 0; i < chs.length; i++) {
//                if (chs[i] == ch) {
//                   continue;
//                }
//                char old_ch = chs[i];
//                chs[i] = ch;
//                if (dict.contains(String.valueOf(chs))) {
//                   res.add(String.valueOf(chs));
//                }
//                chs[i] = old_ch;
//            }
//        }
//        return res;
//    }


    // dict 就是wordList，为了提高速度，从list 转为HashSet
    // cur 是我们要考虑的单词
//    private List<String> getNext(String cur, Set<String> dict) {
//        List<String> res = new ArrayList<>();
//        char[] chars = cur.toCharArray();
//        // 考虑每一位
//        for (int i = 0; i < chars.length; i++) {
//            char old = chars[i];
//            // 考虑变成其他所有的字母
//            for (char c = 'a'; c <= 'z'; c++) {
//                if (c == old) {
//                    continue;
//                }
//                chars[i] = c;
//                String next = new String(chars);
//                // 判断wordList 是否包含修改后的单词
//                if (dict.contains(next)) {
//                    res.add(next);
//                }
//            }
//            chars[i] = old;
//        }
//        return res;
//    }
//

//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        List<List<String>> ans = new ArrayList<>();
//        ArrayList<String> temp = new ArrayList<>();
//        // temp 用来保存当前的路径
//        temp.add(beginWord);
//
//    }
//
//    int min = Integer.MAX_VALUE;
//
//    private void findLaddersHelper(String beginWord, String endWord, List<String> wordList,
//                                   ArrayList<String> temp, List<List<String>> ans) {
//        // 到了结尾单词
//        if (beginWord.equals(endWord)) {
//            // 当前长度更小，清空之前的，将新的路径加入到结果中
//            if (min > temp.size()) {
//                ans.clear();
//                min = temp.size();
//                ans.add(new ArrayList<>(temp));
//                // 相等的话就直接将路径加入到结果中
//            } else if (min == temp.size()) {
//                ans.add(new ArrayList<>(temp));
//            }
//            return;
//        }
//
//        // 当前的长度到达了min， 还是没有达到结束单词就提前结束
//        if (temp.size() >= min) {
//           return;
//        }
//
//        // 遍历当前所有的单词
//        for (int i = 0; i < wordList.size(); i++) {
//           String curWord = wordList.get(i);
//           // 路径中已经包含有当前单词， 如果再把当前单词加到路径，那肯定会是的路径更长，所以跳过
//            if (temp.contains(curWord)) {
//                continue;
//            }
//            // 符合只有一个单词不同,就进入递归
//            if (oneChanged(beginWord, curWord)) {
//                temp.add(curWord);
//                findLaddersHelper(curWord, endWord, wordList, temp, ans);
//                temp.remove(temp.size() - 1);
//            }
//        }
//    }
//
//    private boolean oneChanged(String beginWord, String curWord) {
//        int count = 0;
//        for (int i = 0; i < beginWord.length(); i++) {
//           if (beginWord.charAt(i) != curWord.charAt(i)) {
//              count++;
//           }
//           if (count == 2) {
//               return false;
//           }
//        }
//        return count == 1;
//    }


//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        List<List<String>> ans = new ArrayList<>();
//        // 如果不含有结束单词, 直接结束，不然后边会造成死循环
//        if (!wordList.contains(endWord)) {
//            return ans;
//        }
//        // 利用BFS得到所有的邻居节点, 以及每个节点的所在层数
//        HashMap<String, Integer> distance = new HashMap<>();
//        HashMap<String, ArrayList<String>> map = new HashMap<>();
//        bfs(beginWord, endWord, wordList, map, distance);
//        ArrayList<String> temp = new ArrayList<>();
//        // temp 用来保存当前的路径
//        temp.add(beginWord);
//        findLaddersHelper(beginWord, endWord, map, distance, temp, ans);
//        return ans;
//    }
//
//    private void findLaddersHelper(String beginWord, String endWord,
//                                   HashMap<String, ArrayList<String>> map,
//                                   HashMap<String, Integer> distance,
//                                   ArrayList<String> temp,
//                                   List<List<String>> ans) {
//        if (beginWord.equals(endWord)) {
//            ans.add(new ArrayList<>(temp));
//            return;
//        }
//
//        // 得到所有的下一个的节点
//        /*
//      "a"
//      "c"
//      ["a","b","c"]*/
//        //之所以是 map.getOrDefault 而不是 get，就是上边的情况 get 会出错
//        ArrayList<String> neighbors = map.getOrDefault(beginWord, new ArrayList<>());
//        for (String neighbor : neighbors) {
//            // 判断层数是否符合
//            if (distance.get(beginWord) + 1 == distance.get(neighbor)) {
//                temp.add(neighbor);
//                findLaddersHelper(neighbor, endWord, map, distance, temp, ans);
//                temp.remove(temp.size() - 1);
//            }
//        }
//    }
//
//    public void bfs(String beginWord, String endWord, List<String> wordList,
//                    HashMap<String, ArrayList<String>> map,
//                    HashMap<String, Integer> distance) {
//
//        Queue<String> queue = new LinkedList<>();
//        queue.offer(beginWord);
//        distance.put(beginWord, 0);
//        boolean isFound = false;
//        int depth = 0;
//        Set<String> dict = new HashSet<>();
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            depth++;
//            for (int j = 0; j < size; j++) {
//                String temp = queue.poll();
//                // 一次性得到所有的下一个的节点
//                ArrayList<String> neighbors = getNeighbors(temp, dict);
//                map.put(temp, neighbors);
//                for (String neighbor : neighbors) {
//                    if (!distance.containsKey(neighbor)) {
//                        distance.put(neighbor, depth);
//                        if (neighbor.equals(endWord)) {
//                            isFound = true;
//                        }
//                        queue.offer(neighbor);
//                    }
//                }
//            }
//            if (isFound) {
//                break;
//            }
//        }
//    }
//
//    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
//        ArrayList<String> res = new ArrayList<>();
//        char chs[] = node.toCharArray();
//
//        for (char ch = 'a'; ch <= 'z'; ch++) {
//            for (int i = 0; i < chs.length; i++) {
//                if (chs[i] == ch) {
//                    continue;
//                }
//                char old_ch = chs[i];
//                chs[i] = ch;
//                if (dict.contains(String.valueOf(chs))) {
//                    res.add(String.valueOf(chs));
//                }
//                chs[i] = old_ch;
//            }
//        }
//        return res;
//    }

//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        List<List<String>> ans = new ArrayList<>();
//        // 如果不含有结束单词， 直接结束，不然后边会造成死循环
//        if (!wordList.contains(endWord)) {
//            return ans;
//        }
//        // 利用BFS得到所有的邻居节点，以及每个节点的所在层数
//        HashMap<String, Integer> distance = new HashMap<>();
//        HashMap<String, ArrayList<String>> map = new HashMap<>();
//        bfs(beginWord, endWord, wordList, map, distance);
//        ArrayList<String> temp = new ArrayList<>();
//
//        // temp 用来保存当前的路径
//        temp.add(beginWord);
//        findLaddersHelper(beginWord, endWord,
//                map, distance, temp, ans);
//        return ans;
//    }
//
//    private void findLaddersHelper(String beginWord, String endWord,
//                                   HashMap<String, ArrayList<String>> map,
//                                   HashMap<String, Integer> distance,
//                                   ArrayList<String> temp,
//                                   List<List<String>> ans) {
//        if (beginWord.equals(endWord)) {
//            ans.add(new ArrayList<>(temp));
//        }
//        // 得到所有的下一个的节点
//        /*
//      "a"
//      "c"
//      ["a","b","c"]*/
//        ArrayList<String> neighbors = map.getOrDefault(beginWord, new ArrayList<>());
//        for (String neighbor : neighbors) {
//            // 判断层数是否符合
//            if (distance.get(beginWord) + 1 == distance.get(neighbor)) {
//                temp.add(neighbor);
//                findLaddersHelper(neighbor, endWord, map, distance, temp, ans);
//                temp.remove(temp.size() - 1);
//            }
//        }
//    }
//
//    private void bfs(String beginWord, String endWord, List<String> wordList,
//                     HashMap<String, ArrayList<String>> map,
//                     HashMap<String, Integer> distance) {
//
//        Queue<String> queue = new LinkedList<>();
//        queue.offer(beginWord);
//        distance.put(beginWord, 0);
//        boolean isFound = false;
//        int depth = 0;
//        Set<String> dict = new HashSet<>(wordList);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            depth++;
//            for (int j = 0; j < size; j++) {
//                String temp = queue.poll();
//                // 一次性得到所有的下一个的节点
//                ArrayList<String> neighbors = getNeighbors(temp, dict);
//                map.put(temp, neighbors);
//                for (String neighbor : neighbors) {
//                    if (!distance.containsKey(neighbor)) {
//                        distance.put(neighbor, depth);
//                        if (neighbor.equals(endWord)) {
//                            isFound = true;
//                        }
//                        queue.offer(neighbor);
//                    }
//                }
//            }
//            if (isFound) {
//                break;
//            }
//        }
//    }
//
//    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
//        ArrayList<String> res = new ArrayList<>();
//        char chs[] = node.toCharArray();
//        for (char ch = 'a'; ch <= 'z'; ch++) {
//            for (int i = 0; i < chs.length; i++) {
//                if (chs[i] == ch) {
//                   continue;
//                }
//                char old_ch = chs[i];
//                chs[i] = ch;
//                if (dict.contains(String.valueOf(chs))) {
//                    res.add(String.valueOf(chs));
//                }
//                chs[i] = old_ch;
//            }
//        }
//        return res;
//    }

//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        List<List<String>> ans = new ArrayList<>();
//        if (!wordList.contains(endWord)) {
//            return ans;
//        }
//
//        // 利用BFS得到所有的邻居节点
//        HashMap<String, ArrayList<String>> map = new HashMap<>();
//        bfs(beginWord, endWord, wordList, map);
//        ArrayList<String> temp = new ArrayList<>();
//        // temp 用来保存当前的路径
//        temp.add(beginWord);
//        findLaddersHelper(beginWord, endWord, map, temp, ans);
//        return ans;
//    }
//
//    private void findLaddersHelper(String beginWord, String endWord,
//                                   HashMap<String, ArrayList<String>> map,
//                                   ArrayList<String> temp,
//                                   List<List<String>> ans) {
//        if (beginWord.equals(endWord)) {
//            ans.add(new ArrayList<>(temp));
//            return;
//        }
//
//        // 得到所有的下一个的节点
//        ArrayList<String> neighbors = map.getOrDefault(beginWord, new ArrayList<>());
//        for (String neighbor : neighbors) {
//            temp.add(neighbor);
//            findLaddersHelper(neighbor, endWord, map, temp, ans);
//            temp.remove(temp.size() - 1);
//        }
//    }
//
//
//    private void bfs(String beginWord, String endWord, List<String> wordList, HashMap<String, ArrayList<String>> map) {
//        Queue<String> queue = new LinkedList<>();
//        queue.offer(beginWord);
//        boolean isFound = false;
//        int depth = 0;
//        Set<String> dict = new HashSet<>(wordList);
//        Set<String> visited = new HashSet<>();
//        visited.add(beginWord);
//
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            depth++;
//            Set<String> subVisited = new HashSet<>();
//            for (int j = 0; j < size; j++) {
//                String temp = queue.poll();
//                // 一次性得到所有的下一个的节点
//                ArrayList<String> neighbors = getNeighbors(temp, dict);
//                Iterator<String> it = neighbors.iterator(); // 把元素导入迭代器
//                while (it.hasNext()) {
//                    String neighbor = it.next();
//                    if (!visited.contains(neighbor)) {
//                        if (neighbor.equals(endWord)) {
//                            isFound = true;
//                        }
//                        queue.offer(neighbor);
//                        subVisited.add(neighbor);
//                    } else {
//                        it.remove();
//                    }
//                }
//                map.put(temp, neighbors);
//            }
//            visited.addAll(subVisited);
//            if (isFound) {
//                break;
//            }
//        }
//    }
//
//    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
//        ArrayList<String>  res = new ArrayList<>();
//        char chs[] = node.toCharArray();
//        for (char ch = 'a'; ch <= 'z'; ch++) {
//            for (int i = 0; i < chs.length; i++) {
//                if (chs[i] == ch) {
//                   continue;
//                }
//                char old_ch = chs[i];
//                chs[i]= ch;
//                if (dict.contains(String.valueOf(chs))) {
//                   res.add(String.valueOf(chs));
//                }
//                chs[i] = old_ch;
//            }
//        }
//        return res;
//    }

//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        List<List<String>> ans = new ArrayList<>();
//        // 如果不含有结束单词，直接结束，不然后边会造成死循环
//        if (!wordList.contains(endWord)) {
//            return ans;
//        }
//        bfs(beginWord, endWord, wordList, ans);
//        return ans;
//    }

//    private void bfs(String beginWord, String endWord, List<String> wordList,
//                     List<List<String>> ans) {
//        Queue<List<String>> queue = new LinkedList<>();
//        List<String> path = new ArrayList<>();
//        path.add(beginWord);
//        queue.offer(path);
//        boolean isFound = false;
//        Set<String> dict = new HashSet<>(wordList);
//        Set<String> visited = new HashSet<>();
//        visited.add(beginWord);

//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            Set<String> subVisited = new HashSet<>();
//            for (int i = 0; i < size; i++) {
//                List<String> p = queue.poll();
//                // 得到当前路径的末尾单词
//                String temp = p.get(p.size() - 1);
//                // 一次性得到所有的下一个的节点
//                ArrayList<String> neighbors = getNeighbor(temp, dict);
//                for (String neighbor : neighbors) {
//                    // 只考虑之前没有出现过的单词
//                    if (!visited.contains(neighbor)) {
//                        // 到达结束单词
//                        if (neighbor.equals(endWord)) {
//                            isFound = true;
//                            p.add(neighbor);
//                            ans.add(new ArrayList<>(p));
//                            p.remove(p.size() - 1);
//                        }
//                        // 加入当前单词
//                        p.add(neighbor);
//                        queue.offer(new ArrayList<>(p));
//                        p.remove(p.size() - 1);
//                        subVisited.add(neighbor);
//                    }
//                }
//            }
//            visited.addAll(subVisited);
//            if (isFound) {
//                break;
//            }
//        }
//    }

//
//    private ArrayList<String> getNeighbor(String node, Set<String> dict) {
//        ArrayList<String> res = new ArrayList<>();
//        char[] chs = node.toCharArray();
//        for (char ch = 'a'; ch <= 'z'; ch++) {
//            for (int i = 0; i < chs.length; i++) {
//                if (chs[i] == ch) {
//                   continue;
//                }
//                char old_ch = chs[i];
//                chs[i] = ch;
//                if (dict.contains(String.valueOf(chs))) {
//                   res.add(String.valueOf(chs));
//                }
//                chs[i] = old_ch;
//            }
//        }
//        return res;
//    }


//    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        List<List<String>> ans = new ArrayList<>();
//        if (!wordList.contains(endWord)) {
//            return ans;
//        }
//        // 利用BFS得到所有的邻居节点
//        HashMap<String, ArrayList<String>> map = new HashMap<>();
//        bfs(beginWord, endWord, wordList, map);
//        ArrayList<String> temp = new ArrayList<>();
//        // temp 用来保存当前的路径
//        temp.add(beginWord);
//        findLaddersHelper(beginWord, endWord, map, temp, ans);
//        return ans;
//    }

//    private void findLaddersHelper(String beginWord, String endWrod,
//                                   HashMap<String, ArrayList<String>> map,
//                                   ArrayList<String> temp, List<List<String>> ans) {
//        if (beginWord.equals(endWrod)) {
//            ans.add(new ArrayList<>(temp));
//            return;
//        }
//        // 得到所有的下一个的节点
//        ArrayList<String> neighbors = map.getOrDefault(beginWord, new ArrayList<>());
//        for (String neighbor : neighbors) {
//            temp.add(neighbor);
//            findLaddersHelper(neighbor, endWrod, map, temp, ans);
//            temp.remove(temp.size() - 1);
//        }
//    }

//    // 利用递归实现了双向搜索
//    private void bfs(String beginWord, String endWord, List<String> wordList, HashMap<String, ArrayList<String>> map) {
//        Set<String> set1 = new HashSet<>();
//        set1.add(beginWord);
//        Set<String> set2 = new HashSet<>();
//        set2.add(endWord);
//        Set<String> wordSet = new HashSet<>(wordList);
//        bfsHelper(set1, set2, wordSet, true, map);
//    }

//    private boolean bfsHelper(Set<String> set1, Set<String> set2, Set<String> wordSet,
//                              boolean direction, HashMap<String, ArrayList<String>> map) {
//        // set1 为空了， 就直接结束
//        //比如下边的例子就会造成 set1 为空
//            /*    "hot"
//                "dog"
//                ["hot","dog"]*/
//        if (set1.isEmpty()) {
//            return false;
//        }
//        // set1的数量多， 就反向扩展
//        if (set1.size() > set2.size()) {
//            return bfsHelper(set2, set1, wordSet, !direction, map);
//        }
//        // 将已经访问过单词删除
//        wordSet.removeAll(set1);
//        wordSet.removeAll(set2);

//        boolean done = false;

//        // 保存新扩展得到的节点
//        Set<String> set = new HashSet<>();
//        for (String str : set1) {
//            // 遍历每一位
//            for (int i = 0; i < str.length(); i++) {
//               char[] chars = str.toCharArray();
//               //尝试所有字母
//                for (char ch = 'a'; ch <= 'z'; ch++) {
//                    if (chars[i] == ch) {
//                       continue;
//                    }
//                    chars[i] = ch;
//                    String word = new String(chars);
//                    // 根据方向得到map的key 和value
//                    String key = direction ? str : word;
//                    String val = direction ? word : str;

//                    ArrayList<String> list = map.containsKey(key) ? map.get(key) : new ArrayList<>();
//
//                    // 如果相遇了就保存结果
//                    if (set2.contains(word)) {
//                       done = true;
//                       list.add(val);
//                       map.put(key, list);
//                    }
//                    // 如果还没有相遇， 并且新的单词在word中，那么久加到set中
//                    if (!done && wordSet.contains(word)) {
//                        set.add(word);
//                        list.add(val);
//                        map.put(key, list);
//                    }
//                }
//            }
//        }
//        // 一般情况下新扩展的元素会多一些，所以我们下次反方向扩展set2
//        return done || bfsHelper(set2, set, wordSet, !direction, map);
//    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return ans;
        }
        // 利用BFS得到所有的邻居节点
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        bfs(beginWord, endWord, wordList, map);
        ArrayList<String> temp = new ArrayList<>();
        // temp 用来保存当前的路径
        temp.add(beginWord);
        findLaddersHelper(beginWord, endWord, map, temp, ans);
        return ans;
    }

    private void findLaddersHelper(String beginWord, String endWord, HashMap<String, ArrayList<String>> map,
                                   ArrayList<String> temp, List<List<String>> ans) {
        if (beginWord.equals(endWord)) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        // 得到所有的下一个的节点
        ArrayList<String> neighbors = map.getOrDefault(beginWord, new ArrayList<>());
        for (String neighbor : neighbors) {
            temp.add(neighbor);
            findLaddersHelper(neighbor, endWord, map, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }

    private void bfs(String beginWord, String endWord, List<String> wordList, HashMap<String, ArrayList<String>> map) {
        Set<String> set1 = new HashSet<>();
        set1.add(beginWord);
        Set<String> set2 = new HashSet<>();
        set2.add(endWord);
        Set<String> wordSet = new HashSet<>(wordList);
        bfsHelper(set1, set2, wordSet, true, map);
    }

    // direction为true代表向下扩展，false代表向上扩展
    private boolean bfsHelper(Set<String> set1, Set<String> set2, Set<String> wordSet,
                              boolean direction,
                              HashMap<String, ArrayList<String>> map) {
        // set1 为空了， 就直接结束
        //比如下边的例子就会造成 set1 为空
            /*    "hot"
                "dog"
                ["hot","dog"]*/
        if (set1.isEmpty()) {
            return false;
        }

        // set1的数量多， 就反向扩展
        if (set1.size() > set2.size()) {
            return bfsHelper(set2, set1, wordSet, !direction, map);
        }

        // 将已经访问过单词删除
        wordSet.removeAll(set1);
        wordSet.removeAll(set2);

        boolean done = false;

        // 保存新扩展得到的节点
        Set<String> set = new HashSet<>();

        for (String str : set1) {
            // 遍历每一位
            for (int i = 0; i < str.length(); i++) {
                char[] chars = str.toCharArray();
                // 尝试所有字母
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (chars[i] == ch) {
                        continue;
                    }
                    chars[i] = ch;

                    String word = new String(chars);
                    //根据方向得到map的key和val
                    String key = direction ? str : word;
                    String val = direction ? word : str;

                    ArrayList<String> list = map.containsKey(key) ? map.get(key) : new ArrayList<>();

                    // 如果相遇了就保存结果
                    if (set2.contains(word)) {
                        done = true;
                        list.add(val);
                        map.put(key, list);
                    }

                    // 如果还没有相遇， 并且新的单词在Word中，那么就加到set中
                    if (!done && wordSet.contains(word)) {
                        set.add(word);
                        list.add(val);
                        map.put(key, list);
                    }
                }
            }
        }
        // 一般情况下新扩展的元素会多一些，所以我们下次反方向扩展 set2
        return done || bfsHelper(set2, set, wordSet, !direction, map);
    }

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        OneTwoSix oneTwoSix = new OneTwoSix();
        oneTwoSix.findLadders("hit", "cog", wordList);
    }
}
