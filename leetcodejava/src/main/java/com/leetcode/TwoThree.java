package com.leetcode;

import com.entity.ListNode;

/**
 * @author: John
 * @date: 2020-02-04 20:12
 * @description: 23
 **/
public class TwoThree {


    /**
     * Merge with Divide And Conquer
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int interval = 1;
        while (interval < lists.length) {
            for (int i = 0; i + interval < lists.length; i = i + interval * 2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            // 进入下一轮
            interval *= 2;
        }
        return lists[0];
    }

    /**
     * Merge lists one by one
     * 这个方案只是单纯的一个list一个list的合并
     * 会产生很多重复计算
     * @return
     */
//    public ListNode mergeKLists(ListNode[] lists) {
//        if (lists.length == 1) {
//            return lists[0];
//        }
//        if (lists.length == 0) {
//            return lists[1];
//        }
//
//        ListNode head = mergeTwoLists(lists[0], lists[1]);
//        for (int i = 2; i < lists.length; i++) {
//            head = mergeTwoLists(head, lists[i]);
//        }
//        return head;
//    }


    /**
     * merge two lists
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode h = new ListNode(0);
        ListNode ans = h;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                h.next = l1;
                h = h.next;
                l1 = l1.next;
            } else {
                h.next = l2;
                h = h.next;
                l2 = l2.next;
            }
        }

        if (l1 == null) {
            h.next = l2;
        }

        if (l2 == null) {
            h.next = l1;
        }
        return ans.next;
    }


    /**
     * Optimize merge one by one with Priority Queue
     *
     * @param lists
     * @return
     */
//    public ListNode mergeKLists(ListNode[] lists) {
//        Comparator<ListNode> cmp;
//        cmp = new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//                return o1.val - o2.val;
//            }
//        };
//
//        // 利用优先队列来逐一比对节点
//        Queue<ListNode> queue = new PriorityQueue<>(cmp);
//        for (ListNode l : lists) {
//            if (l != null) {
//                queue.add(l);
//            }
//        }
//
//        ListNode head = new ListNode(0);
//        ListNode point = head;
//
//        while (!queue.isEmpty()) {
//            point.next = queue.poll();
//            point = point.next;
//            // 当拿出当前节点后, 如果当前节点还有后续节点; 同时将后续节点放入优先队列
//            ListNode next = point.next;
//            if (next != null) {
//                queue.add(next);
//            }
//        }
//        return head.next;
//    }

    /**
     * merge one by one
     * @param lists
     * @return
     */
//    public ListNode mergeKLists(ListNode[] lists) {
//        int minIndex = 0;
//        ListNode dummy = new ListNode(0);
//        ListNode h = dummy;
//
//        while (true) {
//           boolean isBreak = true;
//           int min = Integer.MAX_VALUE;
//
//           // 逐个ListNode节点比较找出最小值 及 下标
//           for (int i = 0; i < lists.length; i++) {
//               if (lists[i] != null) {
//                  if (lists[i].val < min) {
//                      minIndex = i;
//                      min = lists[i].val;
//                  }
//                  // 只要剩余节点不为空就不跳出while
//                  isBreak = false;
//               }
//           }
//
//           // 没有节点了 跳出
//           if (isBreak) {
//               break;
//           }
//           // 拼接
//           ListNode newNode = new ListNode(lists[minIndex].val);
//           h.next = newNode;
//           h = h.next;
//           // 将当前找到的节点向前移动
//           lists[minIndex] = lists[minIndex].next;
//        }
//        h.next = null;
//        return dummy.next;
//    }


    /**
     * brute force
     * @param lists
     * @return
     */
//    public ListNode mergeKLists(ListNode[] lists) {
//        List<Integer> list = new ArrayList<>();
//
//        // 先将所有值放入list中
//        for (ListNode ln : lists) {
//           while (ln != null) {
//              list.add(ln.val);
//              ln = ln.next;
//           }
//        }
//
//        // 对list 进行排序
//        Collections.sort(list);
//
//        // 重新构建新的ListNode
//        ListNode head = new ListNode(0);
//        ListNode h = head;
//        for (int i : list) {
//           ListNode tmp = new ListNode(i);
//           h.next = tmp;
//           h = h.next;
//        }
//        h.next = null;
//        return head.next;
//    }


//    public static ListNode mergeKLists(ListNode[] lists) {
//        if (lists == null || lists.length == 0) {
//            return null;
//        }
//        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//                if (o1.val < o2.val) {
//                    return -1;
//                } else if (o1.val == o2.val) {
//                    return 0;
//                } else {
//                    return 1;
//                }
//            }
//        });
//
//        ListNode dummy = new ListNode(0);
//        ListNode tail = dummy;
//        for (ListNode node : lists) {
//            if (node != null) {
//                queue.add(node);
//            }
//        }
//        while (!queue.isEmpty()) {
//            tail.next = queue.poll();
//            tail = tail.next;
//        }
//        return dummy.next;
//    }
//        if (lists == null || lists.length == 0) {
//            return null;
//        }
//        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//                if (o1.val < o2.val) {
//                    return -1;
//                } else if (o1.val == o2.val) {
//                    return 0;
//                } else {
//                    return 1;
//                }
//            }
//        });
//
//        ListNode dummy = new ListNode(0);
//        ListNode tail = dummy;
//        for (ListNode node : lists) {
//            if (node != null) {
//                queue.add(node);
//            }
//        }
//        while (!queue.isEmpty()) {
//            tail.next = queue.poll();
//            tail = tail.next;
//            // there because linkedlist is chain structure， so should put next of current into queue
//            if (tail.next != null) {
//                queue.add(tail.next);
//            }
//        }
//        return dummy.next;
//    }

//    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null) {
//            return l2;
//        }
//        if (l2 == null) {
//            return l1;
//        }
//
//        ListNode head = null;
//        ListNode former = null;
//        int i = 0;
//        while (l1!=null && l2!=null) {
//            i++;
//            if (l1.val > l2.val) {
//                if (former == null) {
//                    former = l2;
//                } else {
//                    former.next = l2;
//                }
//                if (head == null) {
//                    head = former;
//                } else {
//                    former = former.next;
//                }
//                l2 = l2.next;
//            } else {
//                if (former == null) {
//                    former = l1;
//                } else {
//                    former.next = l1;
//                }
//                if (head == null) {
//                    head = former;
//                } else {
//                    former = former.next;
//                }
//                l1 = l1.next;
//            }
//        }
//        System.out.println(i);
//        if (l2 != null) {
//            l1 = l2;
//        }
//        former.next = l1;
//        return head;
//    }
//
//    public static ListNode mergeKLists(List<ListNode> lists) {
//        if (lists.size() == 0) {
//            return null;
//        }
//        if (lists.size() == 1) {
//            return lists.get(0);
//        }
//        if (lists.size() == 2) {
//            return mergeTwoLists(lists.get(0), lists.get(1));
//        }
//        return mergeTwoLists(mergeKLists(lists.subList(0, lists.size()/2)),
//                mergeKLists(lists.subList(lists.size()/2, lists.size())));
//    }

    /**
     * brute force
     *
     * @param lists
     * @return
     */
//    public ListNode mergeKLists(ListNode[] lists) {
//        List<Integer> l = new ArrayList<>();
//        for (ListNode ln : lists) {
//            while (ln != null) {
//               l.add(ln.val);
//               ln = ln.next;
//            }
//        }
//
//        Collections.sort(l);
//
//        ListNode head = new ListNode(0);
//        ListNode h = head;
//        for (int i : l) {
//            ListNode t = new ListNode(i);
//            h.next = t;
//            h = h.next;
//        }
//        h.next = null;
//        return head.next;
//    }

    /**
     * compare one by one O(n) space
     * @param lists
     * @return
     */
//    public ListNode mergeKLists(ListNode[] lists) {
//        int min_index = 0;
//        ListNode head = new ListNode(0);
//        ListNode h = head;
//        while (true) {
//            boolean isBreak = true;
//            int min = Integer.MAX_VALUE;
//            for (int i = 0; i < lists.length; i++) {
//               if (lists[i] != null) {
//                  if (lists[i].val < min) {
//                     min_index = i;
//                     min = lists[i].val;
//                  }
//                  isBreak = false;
//               }
//            }
//            if (isBreak) {
//                break;
//            }
//            ListNode a = new ListNode(lists[min_index].val);
//            h.next = a;
//            h = h.next;
//            lists[min_index] = lists[min_index].next;
//        }
//        h.next = null;
//        return head.next;
//    }

//    /**
//     * compare one by one O(1) space
//     * @param lists
//     * @return
//     */
//    public ListNode mergetKLists(ListNode[] lists) {
//        int min_index = 0;
//        ListNode head = new ListNode(0);
//        ListNode h = head;
//        while (true) {
//            boolean isBreak = true;
//            int min = Integer.MAX_VALUE;
//            for (int i = 0; i < lists.length; i++) {
//                if (lists[i] != null) {
//                   if (lists[i].val < min) {
//                      min_index = i;
//                      min = lists[i].val;
//                   }
//                   isBreak = false;
//                }
//            }
//            if (isBreak) {
//                break;
//            }
//            h.next = lists[min_index];
//            h = h.next;
//            lists[min_index] = lists[min_index].next;
//        }
//        h.next = null;
//        return head.next;
//    }

    /**
     * Priority Queue
     *
     * @param args
     */
//    public ListNode mergeKLists(ListNode[] lists) {
//        Comparator<ListNode> cmp;
//        cmp = new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//                return o1.val - o2.val;
//            }
//        };
//
//        Queue<ListNode> q = new PriorityQueue<>(cmp);
//        for (ListNode l : lists) {
//           if (l != null) {
//              q.add(l);
//           }
//        }
//        ListNode head = new ListNode(0);
//        ListNode point = head;
//        while (!q.isEmpty()) {
//            point.next = q.poll();
//            point = point.next;
//            ListNode next = point.next;
//            if (next != null) {
//               q.add(next);
//            }
//        }
//        return head.next;
//    }

    /**
     * merge Lists one by one
     * @param l1
     * @param l2
     * @return
     */
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode h = new ListNode(0);
//        ListNode ans = h;
//        while (l1 != null && l2 != null) {
//            if (l1.val < l2.val) {
//                h.next = l1;
//                h = h.next;
//                l1 = l1.next;
//            } else {
//                h.next = l2;
//                h = h.next;
//                l2 = l2.next;
//            }
//        }
//        if (l1 == null) {
//            h.next = l2;
//        }
//        if (l2 == null) {
//            h.next = l1;
//        }
//        return ans.next;
//    }
//
//    public ListNode mergeKLists(ListNode[] lists) {
//        if (lists.length == 1) {
//            return lists[0];
//        }
//        if (lists.length == 0) {
//            return null;
//        }
//        ListNode head = mergeTwoLists(lists[0], lists[1]);
//        for (int i = 2; i < lists.length; i++) {
//            head = mergeTwoLists(head, lists[i]);
//        }
//        return head;
//    }

//    /**
//     * merge with divide and conquer
//     * @param l1
//     * @param l2
//     * @return
//     */
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//       ListNode h = new ListNode(0);
//       ListNode ans = h;
//       while (l1 != null && l2 != null) {
//          if (l1.val < l2.val) {
//             h.next = l1;
//             h = h.next;
//             l1 = l1.next;
//          } else {
//              h.next = l2;
//              h = h.next;
//              l2 = l2.next;
//          }
//       }
//       if (l1 == null) {
//          h.next = l2;
//       }
//       if (l2 == null) {
//          h.next = l1;
//       }
//       return ans.next;
//    }
//
//    public ListNode mergeKLists(ListNode[] lists) {
//       if (lists.length == 0) {
//           return null;
//       }
//       int interval = 1;
//       while (interval < lists.length) {
//           System.out.println(lists.length);
//           for (int i = 0; i + interval < lists.length; i = i + interval * 2) {
//               lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
//           }
//           interval *= 2;
//       }
//       return lists[0];
//    }


    /**
     * divide  conquer
     *
     * @param lists
     * @return
     */
//    public ListNode mergeKLists(List<ListNode> lists) {
//       if (lists.size() == 0) {
//          return null;
//       }
//       return mergeHelper(lists, 0, lists.size() - 1);
//    }
//
//    private ListNode mergeHelper(List<ListNode> lists, int start, int end) {
//        if (start == end) {
//           return lists.get(start);
//        }
//
//        int mid = start + (end - start) / 2;
//        ListNode left = mergeHelper(lists, start, mid);
//        ListNode right = mergeHelper(lists, mid + 1, end);
//        return mergeTwoLists(left, right);
//    }
//
//    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        ListNode dummy = new ListNode(0);
//        ListNode tail = dummy;
//        while (list1 != null && list2 != null) {
//            if (list1.val < list2.val) {
//               tail.next = list1;
//               tail = tail.next;
//               list1 = list1.next;
//            } else {
//                tail.next = list2;
//                tail = tail.next;
//                list2 = list2.next;
//            }
//        }
//
//        if (list1 != null) {
//           tail.next = list2;
//        }
//        if (list2 != null) {
//           tail.next = list1;
//        }
//        return dummy.next;
//    }
    public static void main(String[] args) {
        ListNode[] result = new ListNode[3];
        ListNode listNode1 = new ListNode(1);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode4;
        listNode4.next = listNode5;

        ListNode listNode11 = new ListNode(1);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode44 = new ListNode(4);
        listNode11.next = listNode3;
        listNode3.next = listNode44;

        ListNode listNode2 = new ListNode(2);
        ListNode listNode6 = new ListNode(6);
        listNode2.next = listNode6;

//        result[0] = listNode1;
//        result[1] = listNode11;
//        result[2] = listNode2;
//        List<ListNode> input = new ArrayList<>();
//        input.add(listNode1);
//        input.add(listNode11);
//        input.add(listNode2);
        ListNode[] input = new ListNode[3];
        input[0] = listNode1;
        input[1] = listNode2;
        input[2] = listNode3;

        TwoThree twoThree = new TwoThree();
        ListNode aa = twoThree.mergeKLists(input);
    }
}
