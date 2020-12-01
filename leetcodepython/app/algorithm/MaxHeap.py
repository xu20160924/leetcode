class MaxHeap:
    def __init__(self, capacity):
        # 我们这个版本的实现中，0号索引是不存数据的， 这一点一定要注意
        # 因为数组从索引1开始存放数值
        # 所以开辟 capacity + 1 这么多打下的空间
        self.data = [None for _ in range(capacity + 1)]
        # 当前堆中存储的元素的个数
        self.count = 0
        # 堆中能够存储的元素的最大数量(为简化问题， 不考虑动态扩展)
        self.capacity = capacity

    def size(self):
        """
        返回最大堆中的元素个数
        :return:
        """
        return self.count

    def is_empty(self):
        return self.count == 0

    def insert(self, item):
        if self.count + 1 > self.capacity:
            raise Exception('堆的容量不够了')

        self.count += 1
        self.data[self.count] = item
        # 上移
        self.__siwn(self.count)

    def __shift_up(self, k):
        # 有索引就要考虑索引越界的情况，已经在索引1的位置，就没有必要上移了
        while k > 1 and self.data[k // 2] < self.data[k]:
            self.data[k // 2], self.data[k] = self.data[k], self.data[k // 2]
            k //= 2

    def __shift_down(self, k):
        # 只要有左右孩子，左右孩子只要比自己大，就交换
        while 2 * k <= self.count:
            # 如果这个元素有左边的孩子
            j = 2 * k
            # 如果右边的孩子，大于左边的孩子，就好像左边的孩子不存在一样
            if j + 1 <= self.count and self.data[j + 1] > self.data[j]:
                j = j + 1
            if self.data[k] >= self.data[j]:
                break
            self.data[k], self.data[j] = self.data[j], self.data[k]
            k = j

    def extract_max(self):
        if self.count == 0:
            raise Exception('堆里没有可以取出的元素')
        ret = self.data[1]
        self.data[1], self.data[self.count] = self.data[self.count], self.data[1]
        self.count -= 1
        self.__sink(1)
        return ret

    def __siwn(self, k):
        # 上浮， 与父节点进行比较
        temp = self.data[k]
        # 有索引就要考虑索引越界的情况，已经在索引1的位置，就没必要上移了
        while k > 1 and self.data[k // 2] < temp:
            self.data[k] = self.data[k // 2]
            k //= 2
        self.data[k] = temp

    def __sink(self, k):
        # 下沉
        temp = self.data[k]
        # 只要它有孩子， 这里的等于号是十分关键的
        while 2 * k <= self.count:
            j = 2 * k
            # 如果它有右边的孩子，并且右边的孩子大于左边的孩子
            if j + 1 <= self.count and self.data[j + 1] > self.data[j]:
                # 右边的孩子胜出，此时可以认为没有左孩子
                j += 1
            # 如果当前的元素的值，比右边的孩子节点要大，则逐渐下落的过程到此结束
            if temp >= self.data[j]:
                break
            # 否则， 交换位置， 继续循环
            self.data[k] = self.data[j]
            k = j
        self.data[k] = temp