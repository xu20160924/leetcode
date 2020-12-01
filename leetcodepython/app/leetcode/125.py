class Solution(object):
    def isPalindrome(self, s: str) -> bool:
        
        for i in range(len(s) // 2):
            print(s[i])
            print(s[len(s) - i -1])
            if s[i] != s[len(s) - i - 1] and (s[i] != ' ' and s[len(s) - i - 1] != ' '):
                return True
        return False

if __name__ == '__main__':
    input = "A man, a plan, a canal: Panama"
    solution = Solution()
    print(solution.isPalindrome(input))
    # a = ' '

    # if len(a.strip()) == 0:
    #     print('ad')