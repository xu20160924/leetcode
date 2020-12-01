class NestedInteger:
    def __init__(self, val=None, list=[]):
        self.val = val
        self.list = list

    def isInteger(self) -> bool:
       return self.val is not None
       """
       @return True if this NestedInteger holds a single integer, rather than a nested list.
       """


    def getInteger(self) -> int:
       return self.val
       """
       @return the single integer that this NestedInteger holds, if it holds a single integer
       Return None if this NestedInteger holds a nested list
       """

    def getList(self):
        return self.list
        """
       @return the nested list that this NestedInteger holds, if it holds a nested list
       Return None if this NestedInteger holds a single integer
       """


class NestedIterator(object):

    def __init__(self, nestedList):
        self.stack = [[nestedList, 0]]

    def next(self):
        self.hasNext()
        nestedList, i = self.stack[-1]
        self.stack[-1][1] += 1
        return nestedList[i].getInteger()

    def hasNext(self):
        s = self.stack
        while s:
            nestedList, i = s[-1]
            if i == len(nestedList):
                s.pop()
            else:
                x = nestedList[i]
                if x.isInteger():
                    return True
                s[-1][1] += 1
                s.append([x.getList(), 0])
        return False

if __name__ == '__main__':
    nl1 = NestedInteger(list=[NestedInteger(1), NestedInteger(1)])
    nl2 = NestedInteger(val=2)
    nl3 = NestedInteger(list=[NestedInteger(1), NestedInteger(1)])

    ni = NestedIterator([nl1, nl2, nl3])
    print(ni.next())
    print(ni.next())
    print(ni.next())
    print(ni.next())
    # nestedList =