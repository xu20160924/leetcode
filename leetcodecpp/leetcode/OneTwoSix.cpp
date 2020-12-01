//
// Created by John on 2020/3/31.
//
#include "vector"
#include "string"
#include "unordered_set"
#include "unordered_map"
#include "queue"

using namespace std;

class Solution{

    // 前两中bfs 第一个是存储父节点进行遍历， 第二个是存储子节点进行遍历
//public:
//    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string> & wordList) {
//        unordered_set<string> dict(wordList.begin(), wordList.end());
//        if (!dict.count(endWord)) {
//            return {};
//        }
//        dict.erase(beginWord);
//        dict.erase(endWord);
//
//        unordered_map<string, int> steps{{beginWord, 1}};
//        unordered_map<string, vector<string>> parents;
//
//        queue<string> q;
//        q.push(beginWord);
//
//        vector<vector<string>> ans;
//        const int l = beginWord.length();
//        int step = 0;
//        bool found = false;
//
//        while (!q.empty() && !found) {
//            ++step;
//            for (int size = q.size(); size > 0; size--) {
//                const string p = q.front(); q.pop();
//                string w = p;
//                for (int i = 0; i < l; i++) {
//                    const char ch = w[i];
//                    for (int j = 'a'; j <= 'z'; j++) {
//                        if (j == ch) {
//                            continue;
//                        }
//                        w[i] = j;
//                        if (w == endWord) {
//                            parents[w].push_back(p);
//                            found = true;
//                        } else {
//                            // Not a new word， but another transform
//                            // with the same number of steps
//                            if (steps.count(w) && step < steps.at(w)) {
//                                parents[w].push_back(p);
//                            }
//                        }
//                        if (!dict.count(w)) {
//                            continue;
//                        }
//                        dict.erase(w);
//                        q.push(w);
//                        steps[w] = steps.at(p) + 1;
//                        parents[w].push_back(p);
//                    }
//                    w[i] = ch;
//                }
//            }
//        }
//        if (found) {
//            vector<string> curr{endWord};
//            getPaths(endWord, beginWord, parents, curr, ans);
//        }
//        return ans;
//    }
//
//private:
//    void getPaths(const string & word,
//                  const string & beginWord,
//                  const unordered_map<string, vector<string>> & parents,
//                  vector<string> & curr,
//                  vector<vector<string>> & ans) {
//        if (word == beginWord) {
//            ans.push_back(vector<string> (curr.rbegin(), curr.rend()));
//            return;
//        }
//
//        for (const string & p : parents.at(word)) {
//            curr.push_back(p);
////            curr.insert(curr.begin(), p);
//            getPaths(p, beginWord, parents, curr, ans);
//            curr.pop_back();
////            curr.erase(curr.begin());
//        }
//    }






//public:
//    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
//        unordered_set<string> dict (wordList.begin(), wordList.end());
//        if (!dict.count(endWord)) {
//            return {};
//        }
//        dict.erase(beginWord);
//        dict.erase(endWord);
//
//        unordered_map<string, int> steps {{beginWord, 1}};
//        unordered_map<string, vector<string>> parents;
//
//        queue<string> q;
//        q.push(beginWord);
//
//        vector<vector<string>> ans;
//        const int l = beginWord.length();
//        int step = 0;
//        bool found = false;
//
//        while (!q.empty() && !found) {
//            ++step;
//            for (int size = q.size(); size > 0; size--) {
//                const string p = q.front(); q.pop();
//                string w = p;
//                for (int i = 0; i < l; i++) {
//                    const char ch = w[i];
//                    for (int j = 'a'; j <= 'z'; j++) {
//                        if (ch == j) {
//                            continue;
//                        }
//                        w[i] = j;
//                        if (w == endWord) {
//                            found = true;
//                            parents[w].push_back(p);
//                        } else {
//                            if (steps.count(w) && step < steps.at(w)) {
//                                parents[w].push_back(p);
//                            }
//                        }
//                        if (!dict.count(w)) {
//                            continue;
//                        }
//                        dict.erase(w);
//                        q.push(w);
//                        steps[w] = steps.at(p) + 1;
//                        parents[w].push_back(p);
//                    }
//                    w[i] = ch;
//                }
//            }
//        }
//        if (found) {
//            vector<string> curr{endWord};
//            getPaths(endWord, beginWord, parents, curr, ans);
//        }
//        return ans;
//    }
//private:
//    void getPaths(const string & word,
//                  const string & beginWord,
//                  const unordered_map<string, vector<string>> & parents,
//                  vector<string> & curr,
//                  vector<vector<string>> & ans) {
//        if (word == beginWord) {
//            ans.push_back(vector<string>(curr.begin(), curr.end()));
//            return;
//        }
//        for (const string & p : parents.at(word)) {
//            curr.insert(curr.begin(), p);
////            curr.push_back(p);
//            getPaths(p, beginWord, parents, curr, ans);
//            curr.erase(curr.begin());
////            curr.pop_back();
//        }
//    }

//public:
//    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string> & wordList) {
//        vector<vector<string>> ans;
//        unordered_set<string> dict(wordList.begin(), wordList.end());
//        if (!dict.count(endWord)) {
//            return ans;
//        }
//        dict.erase(endWord);
//        const int l = beginWord.length();
//        unordered_set<string> q{beginWord}, p;
//        unordered_map<string, vector<string>> children;
//        bool found = false;
//
//        while (!q.empty() && !found) {
//            for (const string & word : q) {
//                dict.erase(word);
//            }
//
//            for (const string & word : q) {
//                string curr = word;
//                for (int i = 0; i < l; i++) {
//                    char ch = curr[i];
//                    for (int j = 'a'; j <= 'z'; j++) {
//                        curr[i] = j;
//                        if (curr == endWord) {
//                            found = true;
//                            children[word].push_back(curr);
//                        } else if (dict.count(curr) && !found) {
//                            p.insert(curr);
//                            children[word].push_back(curr);
//                        }
//                    }
//                    curr[i] = ch;
//                }
//            }
//            swap(p, q);
//            p.clear();
//        }
//        if (found) {
//            vector<string> path{beginWord};
//            getPaths(beginWord, endWord, children, path, ans);
//        }
//        return ans;
//    }
//private:
//    void getPaths(const string & word,
//                  const string & endWord,
//                  const unordered_map<string, vector<string>> & children,
//                  vector<string> & path,
//                  vector<vector<string>> & ans) {
//        if (word == endWord) {
//            ans.push_back(path);
//            return;
//        }
//        const auto it = children.find(word);
//        if (it == children.cend()) {
//            return;
//        }
//        for (const string & child : it->second) {
//            path.push_back(child);
//            getPaths(child, endWord, children, path, ans);
//            path.pop_back();
//        }
//    }
public:
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string> & wordList) {
        vector<vector<string>> ans;
        unordered_set<string> dict(wordList.begin(), wordList.end());
        if (!dict.count(endWord)) {
            return ans;
        }

        int l = beginWord.length();

        unordered_set<string> q1{beginWord};
        unordered_set<string> q2{endWord};
        unordered_map<string, vector<string>> children;

        bool found = false;
        bool backward = false;

        while (!q1.empty() && !q2.empty() && !found) {
            if (q1.size() > q2.size()) {
                swap(q1, q2);
                backward = !backward;
            }

            for (const string & w : q1) {
                dict.erase(w);
            }
            for (const string & w : q2) {
                dict.erase(w);
            }
            unordered_set<string> q;
            for (const string & word : q1) {
                string curr = word;
                for (int i = 0; i < l; i++) {
                    char ch = curr[i];
                    for (int j = 'a'; j S<= 'z'; j++) {
                        curr[i] = j;
                        const string * parent = &word;
                        const string * child = &curr;
                        if (backward) {
                            swap(parent, child);
                        }
                        if (q2.count(curr)) {
                            found = true;
                            children[*parent].push_back(*child);
                        } else if (dict.count(curr) && !found) {
                            q.insert(curr);
                            children[*parent].push_back(*child);
                        }
                    }
                    curr[i] = ch;
                }
            }
            // 这里交换是因为处理后的大概率是比没处理的节点要多, 所以交换处理少的一个
            swap(q, q1);
        }
        if (found) {
            vector<string> path{beginWord};
            getPaths(beginWord, endWord, children, path, ans);
        }
        return ans;
    }
private:
    void getPaths(const string & word,
                  const string & endWord,
                  const unordered_map<string, vector<string>> & children,
                  vector<string> & path,
                  vector<vector<string>> & ans) {
        if (word == endWord) {
            ans.push_back(path);
            return;
        }

        const auto it = children.find(word);
        if (it == children.cend()) {
            return;
        }
        for (const string & child : it->second) {
            path.push_back(child);
            getPaths(child, endWord, children, path, ans);
            path.pop_back();
        }
    }

};

int main() {
    vector<string> wordList;
//    wordList.push_back("hot");
//    wordList.push_back("dot");
//    wordList.push_back("dog");
//    wordList.push_back("lot");
//    wordList.push_back("log");
//    wordList.push_back("cog");
//    wordList.push_back("a");
//    wordList.push_back("b");
//    wordList.push_back("c");

      wordList.push_back("ted");
      wordList.push_back("tex");
      wordList.push_back("red");
      wordList.push_back("tax");
      wordList.push_back("tad");
      wordList.push_back("den");
      wordList.push_back("rex");
      wordList.push_back("pee");

//    "red"
//    "tax"
//    ["ted","tex","red","tax","tad","den","rex","pee"]


    Solution * solution = new Solution();
    vector<vector<string>> res = solution->findLadders("red", "tax", wordList);

}