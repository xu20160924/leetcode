class Solution(object):
    # def largestRectangleArea(self, heights):
    #     def calculateArea(heights, start, end):
    #         if start >= end:
    #             return 0
    #         minindex = start
    #         # startindex = start
    #         # endindex = end + 1
    #         for i in range(start, end):
    #             if heights[minindex] > heights[i]:
    #                 minindex = i
    #         return max(heights[minindex] * (end - start + 1),
    #                    max(calculateArea(heights, start, minindex - 1),
    #                    calculateArea(heights, minindex + 1, end)))
    #
    #     return calculateArea(heights, 0, len(heights) - 1)

    # def calculateArea(heights, start, end):
    #     if start >= end:
    #         return 0
    #     minindex = start
    #     for i in range(start, end + 1):
    #         if heights[minindex] > heights[i]:
    #             minindex = i
    #     return max(heights[minindex] * (end - start + 1),
    #                max(calculateArea(heights, start, minindex - 1),
    #                    calculateArea(heights, minindex + 1, end)))
    #
    # return calculateArea(heights, 0, len(heights) - 1)



    # def largestRectangleArea(self, heights: [int]) -> int:
    #     def divide(left, right):
    #         if right < left:
    #             return 0
    #         min_i = left
    #         for i in range(left, right + 1):
    #             if heights[i] < heights[min_i]:
    #                 min_i = i
    #         return max((right - left + 1) * heights[min_i],
    #                    divide(left, min_i - 1),
    #                    divide(min_i + 1, right))
    #     return divide(0, len(heights) - 1)



    """
    dp
    time complexity O(n^2)
    space complexi O(n^2)
    """
    # def largestRectangleArea(self, heights: [int]) -> int:
    #     maxnum = 0
    #     dp = [[0 for i in range(len(heights))] for j in range(len(heights))]
    #
    #     # 计算dp最小高度
    #     for i in range(len(heights)):
    #         for j in range(i, len(heights)):
    #             if i == j or heights[j] < dp[i][j-1]:
    #                 dp[i][j] = heights[j]
    #             else:
    #                 dp[i][j] = dp[i][j-1]
    #
    #             # 计算dp数组的同时也是在枚举[i:j], 因此可以将面积计算也合并到同一个循环之中
    #             s = (j - i + 1) * dp[i][j]
    #             maxmun = max(maxmun, s)
    #     return maxmun

    """
    注意到dp[i][j]的计算只依赖于dp[i][j-1] 那么可以将二维dp直接压成一个变量
    time complexity O(n^2)
    space complexity O(1)
    """
    # def largestRetangleArea(self, heights: [int]) -> int:
    #     maxmum = 0
    #     # dp计算最小高度
    #     for i in range(len(heights)):
    #         min_height = 0
    #         for j in range(i, len(heights)):
    #             if i == j or heights[j] < min_height:
    #                 min_height = heights[j]
    #
    #             s = (j-i+1) * min_height
    #             maxmum = max(maxmum, s)
    #     return maxmum

    def largestRectangleArea(self, heights: [int]) -> int:
        maxmum = 0
        for i in range(len(heights)):
            left, right = i, i
            while left > 0 and heights[left-1] >= heights[i]:
                left -= 1
            while right < len(heights) - 1 and heights[right+1] >= heights[i]:
                right += 1
            s = (right - left + 1) * heights[i]
            maxmum = max(maxmum, s)
        return maxmum


if __name__ == '__main__':
    # nums = [2, 1, 5, 6, 2, 3]
    # nums = [1,2,2]
    # nums = [4,2]
    nums = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28,
            29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55,
            56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82,
            83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107,
            108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128,
            129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149,
            150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170,
            171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191,
            192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212,
            213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233,
            234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254,
            255, 256, 257, 258, 259, 260, 261, 262, 263, 264, 265, 266, 267, 268, 269, 270, 271, 272, 273, 274, 275,
            276, 2]
    solution = Solution()
    print(solution.largestRectangleArea(nums))

