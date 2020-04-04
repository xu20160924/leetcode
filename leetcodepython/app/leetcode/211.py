class WordDictionary:
    def __init__(self):
        self.root = {}

    def addWord(self, word):
        node = self.root
        for char in word:
            node = node.setdefault(char, {})
        node[None] = None

    def search(self, word):
        def find(word, node):
            if not word:
                return None in node
            char, word = word[0], word[1:]
            if char != '.':
                return char in node and find(word, node[char])
            print(find(word, kid) for kid in node.values() if kid)
            return any(find(word, kid) for kid in node.values() if kid)
        return find(word, self.root)

    def search(self, word):
        nodes = [self.root]
        for char in word:
            nodes = [kid for node in nodes for key, kid in node.items()
                     if char in (key, '.') and kid]
        return any(None in node for node in nodes)

    def search(self, word):
        nodes = [self.root]
        for char in word:
            nodes = [kid for node in nodes for kid in
                     ([node[char]] if char in node else
                      filter(None, node.values()) if char == '.' else [])]
            # kid
            # for node in nodes:
            #     for kid in ([node[char]] if char in node else filter(None, node.values()) if char == '.' else []):

        return any(None in node for node in nodes)

class WordDictionary1:
    def __init__(self):
        self.root = {}
    def addWord(self, word):
        node = self.root
        for char in word:
            node = node.setdefault(char, {})
        node['$'] = None

    def search(self, word):
        nodes = [self.root]
        for char in word + '$':
            nodes = [kid for node in nodes for kid in
                     ([node[char]] if char in node else
                      filter(None, node.values()) if char == '.' else [])]
        return bool(nodes)

if __name__ == '__main__':
    word = WordDictionary()
    word.addWord("bad")
    word.addWord("dad")
    word.addWord("mad")
    word.search("pad")
    word.search("bad")
    word.search(".ad")
    word.search("b..")
    # print(word.search(None))
