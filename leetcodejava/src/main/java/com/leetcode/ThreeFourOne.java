package com.leetcode;

import java.util.*;

/**
 * @author: John
 * @date: 2020-03-01 08:33
 * @description: 341
 **/
public class ThreeFourOne implements Iterator<Integer> {
//    Stack<NestedInteger> stack = new Stack<>();

//    public ThreeFourOne(List<NestedInteger> nestedList) {
////        for (int i = nestedList.size() -1; i >= 0; i--) {
////            stack.push(nestedList.get(i));
////        }
//        flattenList(nestedList);
//    }

//    @Override
//    public boolean hasNext() {
//        while (!stack.isEmpty()) {
//            NestedInteger curr = stack.peek();
//            if (curr.isInteger()) {
//                return true;
//            }
//            stack.pop();
//            for (int i = curr.getList().size() - 1; i >= 0; i--) {
//                stack.push(curr.getList().get(i));
//            }
//        }
//        return false;
//    }

//    @Override
//    public Integer next() {
//        return stack.pop().getInteger();
//    }

    private Stack<ListIterator<NestedInteger>> lists;

    public ThreeFourOne(List<NestedInteger> nestedList) {
        lists = new Stack<>();
        lists.push(nestedList.listIterator());
    }

    @Override
    public Integer next() {
        hasNext();
        return lists.peek().next().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!lists.empty()) {
            if (!lists.peek().hasNext()) {
                lists.pop();
            } else {
                NestedInteger x = lists.peek().next();
                if (x.isInteger()) {
                    return lists.peek().previous() == x;
                }
                lists.push(x.getList().listIterator());
            }
        }
        return false;
    }

    //    @Override
//    public Integer next() {
//        return hasNext() ? stack.pop().getInteger() : null;
//    }
//
//    @Override
//    public boolean hasNext() {
//       while (!stack.isEmpty()) {
//           if (stack.peek().isInteger()) {
//               return true;
//           }
//           flattenList(stack.pop().getList());
//       }
//       return false;
//    }

//    private void flattenList(List<NestedInteger> list) {
//       for (int i = list.size() - 1; i >= 0; i--) {
//           stack.push(list.get(i));
//       }
//    }

    static class NestedInteger {
        private Integer val;
        private List<NestedInteger> list;
        public boolean isInteger() {
            return val != null;
        }
        public Integer getInteger() {
            return val;
        }
        public List<NestedInteger> getList() {
            return list;
        }

        public NestedInteger(Integer val) {
            this.val = val;
        }

        public NestedInteger(List<NestedInteger> list) {
            this.list = list;
        }
    }

    public static void main(String[] args) {
        List<NestedInteger> list = new ArrayList<>();

        List<NestedInteger> l1 = new ArrayList<>();
        NestedInteger n11 = new NestedInteger(1);
        NestedInteger n12 = new NestedInteger(1);
        l1.add(n11);
        l1.add(n12);
        NestedInteger nl1 = new NestedInteger(l1);

        NestedInteger n2 = new NestedInteger(2);
        NestedInteger n21 = new NestedInteger(1);
        NestedInteger n22 = new NestedInteger(1);
        List<NestedInteger> l2 = new ArrayList<>();
        l2.add(n21);
        l2.add(n22);
        NestedInteger nl2 = new NestedInteger(l2);

        list.add(nl1);
        list.add(n2);
        list.add(nl2);
        ThreeFourOne threeFourOne = new ThreeFourOne(list);
//        System.out.println(threeFourOne.next());
//        System.out.println(threeFourOne.next());
//        System.out.println(threeFourOne.next());
//        System.out.println(threeFourOne.next());
        if (threeFourOne.hasNext()) {
            System.out.println(threeFourOne.next());
        }
        if (threeFourOne.hasNext()) {
            System.out.println(threeFourOne.next());
        }
        if (threeFourOne.hasNext()) {
            System.out.println(threeFourOne.next());
        }
        if (threeFourOne.hasNext()) {
            System.out.println(threeFourOne.next());
        }
    }
}
