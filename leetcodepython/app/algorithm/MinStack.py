"""
155 最小栈 get min stack
data stack and helper stack is synchronous
"""
class MinStack:
    def __init__(self):
        # data stack
        self.data = []
        # helper stack
        self.helper = []



    def push(self, num):
        self.data.append(num)
        if len(self.helper) == 0 or num <= self.helper[-1]:
            self.helper.append(num)
        else:
            self.helper.append(self.helper[-1])

    def pop(self):
        if self.data:
            self.helper.pop()
            return self.data.pop()

    def top(self):
        if self.data:
            return self.data[-1]

    def getMin(self):
        if self.helper:
            return self.helper[-1]

if __name__ == '__main__':
    minStack = MinStack()
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    print(minStack.getMin())
    minStack.pop()
    print(minStack.top())
    print(minStack.getMin())
