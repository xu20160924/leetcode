"""
155 最小栈 get min stack
data stack and helper stack is asynchronous
"""
class AsyncMinSack:
    def __init__(self):
        self.data = []
        self.helper = []

    def push(self, num):
        self.data.append(num)
        if len(self.helper) == 0 or self.helper[-1] > num:
            self.helper.append(num)

    def pop(self):
        # the key is the pop item judge contain in helper and pop too every time
        top = self.data.pop()
        if self.helper and top == self.helper[-1]:
            self.helper.pop()
        return top

    def top(self):
        if self.data:
            return self.data[-1]

    def getMin(self):
        if self.helper:
            return self.helper[-1]