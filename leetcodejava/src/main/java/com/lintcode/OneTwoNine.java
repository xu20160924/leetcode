package com.lintcode;

import com.entity.ListNode;

/**
 * @author: John
 * @date: 2020-04-18 16:20
 * @description: 129
 **/
public class OneTwoNine {
    public ListNode[] rehasing(ListNode[] hashTable) {
        if (hashTable.length <= 0) {
            return hashTable;
        }
        int newcapacity = 2 * hashTable.length;
        ListNode[] newTable = new ListNode[newcapacity];
        for (int i = 0; i < hashTable.length; i++) {
            while (hashTable[i] != null) {
                int newindex = (hashTable[i].val % newcapacity + newcapacity) % newcapacity;
                System.out.println((hashTable[i].val % newcapacity + newcapacity) % newcapacity);
//                int newindex = hashTable[i].val % newcapacity;
                if (newTable[newindex] == null) {
                    newTable[newindex] = new ListNode(hashTable[i].val);
                } else {
                    ListNode dummy = newTable[newindex];
                    while (dummy.next != null) {
                        dummy = dummy.next;
                    }
                    dummy.next = new ListNode(hashTable[i].val);
                }
                hashTable[i] = hashTable[i].next;
            }
        }
        return newTable;
    }

    public static void main(String[] args) {
        ListNode[] hashTable = new ListNode[4];
        hashTable[0] = null;
        ListNode twoOne = new ListNode(21);
        ListNode nine = new ListNode(9);
        twoOne.next = nine;

        ListNode fourteen = new ListNode(14);

        hashTable[1] = twoOne;
        hashTable[2] = fourteen;
        hashTable[3] = null;

        OneTwoNine oneTwoNine = new OneTwoNine();
        oneTwoNine.rehasing(hashTable);
    }
}
