from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        res = []
        if not nums or n < 3: # 不能构成结果 直接返回
            return []
        nums.sort()

        for i in range(n):
            if nums[i] > 0: # 如果排序后的取i是大于0的  由于后面都是正数 更不可能构成答案 直接返回
                return res
            if i > 0 and nums[i] == nums[i - 1]: # 如果下一个与当前是重复的 直接跳过当前
                continue
            L = i + 1
            R = n - 1
            while L < R:
                if nums[i] + nums[L] + nums[R] == 0:
                    res.append([nums[i], nums[L], nums[R]])
                    # 从左边开始去重
                    while L < R and nums[L] == nums[L + 1]:
                        L += 1
                    # 从右边开始去重
                    while L < R and nums[R] == nums[R - 1]:
                        R -= 1
                    # 去重后分别向中间一步
                    L += 1
                    R -= 1
                elif nums[i] + nums[L] + nums[R] > 0:
                    R -= 1
                else:
                    L += 1
        return res
