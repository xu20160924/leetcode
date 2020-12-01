from collections import Counter


class Solution(object):
    # def minWindow(self, s, t):
    #
    #     if not t or not s:
    #         return ""
    #
    #     # Dictionary which keeps a count of all the unique characters in t.
    #     dict_t = Counter(t)
    #
    #     # Number of unique characters in t, which need to be present in the desired window.
    #     required = len(dict_t)
    #
    #     # left and right pointer
    #     l, r = 0, 0
    #
    #     # formed is used to keep track of how many unique characters in t are present in the current window in its desired frequency.
    #     # e.g. if t is "AABC" then the window must have two A's, one B and one C. Thus formed would be = 3 when all these conditions are met.
    #     formed = 0
    #
    #     # Dictionary which keeps a count of all the unique characte in the current window.
    #     window_counts = {}
    #
    #     # ans tuple of the form (window length, left, right)
    #     ans = float("inf"), None, None
    #
    #     while r < len(s):
    #
    #         # Add one character from the right to the window
    #         character = s[r]
    #         window_counts[character] = window_counts.get(character, 0) + 1
    #
    #         # If the frequency of the current character added equals to the desired count in
    #         # t then increment the formed count by 1
    #         if character in dict_t and window_counts[character] == dict_t[character]:
    #             formed += 1
    #
    #         # Try and **  the window till the point where it caeses to be 'desirable
    #         while l <= r and formed == required:
    #             character = s[l]
    #
    #             # Save the smallest window until now.
    #             if r - l + 1 < ans[0]:
    #                 ans = (r - l + 1, l, r)
    #
    #             # The character at the position pointed by the `left` pointer is no longer a
    #             # part of the window
    #             window_counts[character] -= 1
    #             if character in dict_t and window_counts[character] < dict_t[character]:
    #                 formed -= 1
    #
    #             # Move the left pointer ahead, this would help to look for a new window.
    #             l += 1
    #
    #         # Keep expanding the window once we are done  ***
    #         r += 1
    #     return "" if ans[0] == float("inf") else s[ans[1] : ans[2] + 1]

    # def minWindow(self, s: str, t: str) -> str:
    #     if not s or not t:
    #         return ""
    #
    #     dict_t = Counter(t)
    #
    #     required = len(dict_t)
    #
    #     l, r = 0, 0
    #     formed = 0
    #
    #     window_counts = {}
    #     ans = float("inf"), None, None
    #
    #     while r < len(s):
    #
    #         character = s[r]
    #         window_counts[character] = window_counts.get(character, 0) + 1
    #
    #         if character in dict_t and window_counts[character] == dict_t[character]:
    #             formed += 1
    #
    #         while l < r and formed == required:
    #             character = s[l]
    #
    #             if r - l + 1 < ans[0]:
    #                 ans = (r - l + 1, l, r)
    #
    #             window_counts[character] -= 1
    #             if character in dict_t and window_counts[character] < dict_t[character]:
    #                 formed -= 1
    #
    #             l += 1
    #         r += 1
    #     return "" if ans[0] == float("inf") else s[ans[1]: ans[2] + 1]

    """
    after optimize
    """
    def minWindow(self, s, t):
        if not t or not s:
            return ""
        dict_t = Counter(t)
        required = len(dict_t)

        filtered_s = []
        for i, char in enumerate(s):
            if char in dict_t:
                filtered_s.append((i, char))

        l, r = 0, 0
        formed = 0
        window_counts = {}

        ans = float("inf"), None, None
        while r < len(filtered_s):
            character = filtered_s[r][1]
            window_counts[character] = window_counts.get(character, 0) + 1
            if window_counts[character] == dict_t[character]:
                formed += 1
            while l <= r and formed == required:
                character = filtered_s[l][1]

                end = filtered_s[r][0]
                start = filtered_s[l][0]
                if end - start + 1 < ans[0]:
                    ans = (end - start + 1, start, end)

                window_counts[character] -= 1
                if window_counts[character] < dict_t[character]:
                    formed -= 1
                l += 1
            r += 1
        return "" if ans[0] == float("inf") else s[ans[1] : ans[2] + 1]

if __name__ == '__main__':
    s = "ADOBECODEBANC"
    t = "ABC"
    solution = Solution()
    print(solution.minWindow(s, t))