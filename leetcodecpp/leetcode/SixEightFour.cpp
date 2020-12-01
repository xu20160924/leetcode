//
// Created by John on 2020/3/28.
//

#include "vector"

using namespace std;

class UnionFindSet{
public:
    UnionFindSet(int n) {
        ranks_ = vector<int>(n + 1, 0);
        parents_ = vector<int>(n + 1, 0);

        for (int i = 0; i < parents_.size(); i++) {
            parents_[i] = i;
        }
    }

    // Merge sets that contains u and v.
    // Return true if merged, false if u and v are already in one set.
    bool Union(int u, int v) {
        int pu = Find(u);
        int pv = Find(v);
        if (pu == pv) {
            return false;
        }
        // Merge low rank tree into high rank tree
        if (ranks_[pu] < ranks_[pv]) {
            parents_[pv] = pu;
        } else if (ranks_[pu] < ranks_[pv]) {
            parents_[pu] = pv;
        } else {
            parents_[pv]= pu;
            ranks_[pu] += 1;
        }
        return true;
    }

   // Get the root of u.
    int Find(int u) {
        // Compress the path during traversal.
        if (u != parents_[u]) {
            parents_[u] = Find(parents_[u]);
        }
        return parents_[u];
    }

    vector<int> findRedundantConnection(vector<vector<int>> & edges) {
        UnionFindSet s (edges.size());
        for (const auto & edge : edges) {
            if (!s.Union(edge[0], edge[1])) {
                return edge;
            }
        }
        return {};
    }

private:
    vector<int> parents_;
    vector<int> ranks_;
};

//int main() {
//    vector<vector<int>> edges;
//    vector<int> edge1, edge2, edge3;
//    edge1.push_back(1);
//    edge1.push_back(2);
//
//    edge2.push_back(1);
//    edge2.push_back(3);
//
//    edge3.push_back(2);
//    edge3.push_back(3);
//
//    edges.push_back(edge1);
//    edges.push_back(edge2);
//    edges.push_back(edge3);
//
//    UnionFindSet * unionFindSet = new UnionFindSet(edges.size());
//    unionFindSet->findRedundantConnection(edges);
//
//}

