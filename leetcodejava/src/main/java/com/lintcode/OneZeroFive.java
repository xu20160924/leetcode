package com.lintcode;

import com.entity.RandomListNode;

/**
 * @author: John
 * @date: 2020-04-11 13:31
 * @description: 105
 **/
public class OneZeroFive {

    /**
     * copy next node
     *
     * @param head
     */
    private void copyNext(RandomListNode head) {
        while (head != null) {
            RandomListNode copyNode = new RandomListNode(head.val);
            // copyNode 的random 和被复制的random 保持一个
            copyNode.random = head.random;
            // 1->2  --- 1->1'-2
            copyNode.next = head.next;
            head.next = copyNode;
            // 1(head)->1'->2 ---  1->1'->2(head)
            head = head.next.next;
        }
    }

    /**
     * copy random node
     *
     * @param head
     */
    private void copyRandom(RandomListNode head) {
        while (head != null) {
            if (head.next.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }

    //    private RandomListNode splitList(RandomListNode head) {
//       RandomListNode newHead = head.next;
//       while (head != null) {
//           RandomListNode temp = head.next;
//           head.next = temp.next;
//           head = head.next;
//           if (temp.next != null) {
//               temp.next = temp.next.next;
//           }
//       }
//       return newHead;
//    }

    private RandomListNode splitNode(RandomListNode head) {
        // 取下一个copy的
        RandomListNode dummyNode = head.next;
        while (head != null) {
            RandomListNode copyNode = head.next;
            // 1->1'->2->2' ----- 1->2->2'
            head.next = copyNode.next;
            head = head.next;
            if (copyNode.next != null) {
                // 1->1'->2->2'  ----- 1'->2'
                copyNode.next = copyNode.next.next;
            }
        }
        return dummyNode;
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        copyNext(head);
        copyRandom(head);
        return splitNode(head);
    }


    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(-1);
        OneZeroFive oneZeroFive = new OneZeroFive();
        oneZeroFive.copyRandomList(head);
    }
    /**
     * HashMap version
     * @param head
     * @return
     */
//    public RandomListNode copyRandomList(RandomListNode head) {
//        if (head == null) {
//           return null;
//        }
//
//        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
//        RandomListNode dummy = new RandomListNode(0);
//        RandomListNode pre = dummy, newNode;
//        while (head != null) {
//           if (map.containsKey(head)) {
//              newNode = map.get(head);
//           } else {
//               newNode = new RandomListNode(head.val);
//               map.put(head, newNode);
//           }
//           // 由prev节点一直向前填充 prev 开始和dummy相等
//           pre.next = newNode;
//
//           if (head.random != null) {
//              if (map.containsKey(head.random)) {
//                  newNode.random = map.get(head.random);
//              } else {
//                  newNode.random = new RandomListNode(head.random.val);
//                  map.put(head.random, newNode.random);
//              }
//           }
//
//           pre = newNode;
//           head = head.next;
//        }
//        return dummy.next;
//    }


    /**
     * 第一遍扫的时候巧妙运用next指针， 开始数组是1->2->3->4  。
     * 然后扫描过程中 先建立copy节点 1->1`->2->2`->3->3`->4->4`,
     * 然后第二遍copy的时候去建立边的copy， 拆分节点, 一边扫描一边拆成两个链表，
     * 这里用到两个dummy node。第一个链表变回  1->2->3 , 然后第二变成 1`->2`->3`
     */
//    private void copyNext(RandomListNode head) {
//       while (head != null) {
//           RandomListNode newNode = new RandomListNode(head.val);
//           newNode.random = head.random;
//           newNode.next = head.next;
//           head.next = newNode;
//           head = head.next.next;
//       }
//    }
//
//    private void copyRandom(RandomListNode head) {
//       while (head != null) {
//          if (head.next.random != null) {
//             head.next.random = head.random.next;
//          }
//          head = head.next.next;
//       }
//    }
//
//    private RandomListNode splitList(RandomListNode head) {
//       RandomListNode newHead = head.next;
//       while (head != null) {
//           RandomListNode temp = head.next;
//           head.next = temp.next;
//           head = head.next;
//           if (temp.next != null) {
//               temp.next = temp.next.next;
//           }
//       }
//       return newHead;
//    }
//
//    public RandomListNode copyRandomList(RandomListNode head) {
//        if (head == null) {
//            return head;
//        }
//        copyNext(head);
//        copyRandom(head);
//        return splitList(head);
//    }


}
