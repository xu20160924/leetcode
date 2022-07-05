class Solution(object):
    # def isMatch(self, text, pattern):
    #     if not pattern:
    #         return not text
    #     first_match = bool(text) and pattern[0] in {text[0], '.'}
    #
    #     if len(text) >= 2 and pattern[1] == '*':
    #         return (self.isMatch(text, pattern[2:]) and self.isMatch(text[1:], pattern))
    #     else:
    #         return first_match and self.isMatch(text[1:], pattern[1:])

    def match(text, pattern):
        if not pattern:
            return not text
        first_match = bool(text) and pattern[0] in {text[0], '.'}
        return first_match and max(text[1:], pattern[1:])