#include<bits/stdc++.h>
using namespace std;

void makeUnion(int n1, int n2, vector<int>& parent, vector<int>& rank) {
    if(rank[n1]==rank[n2]) {
        parent[n1] = n2;
        rank[n2]++;
    }
    else if(rank[n1]>rank[n2]) {
        parent[n2]=n1;
    }
    else {
        parent[n1]=n2;
    }
}
int findParent(int node, vector<int>& parent) {
    if(node == parent[node]) {
        return node;
    }
    return parent[node] = findParent(parent[node],parent);
}

vector<int> findRedundantConnection(vector<vector<int>>& edges) {
    vector<int> parent(edges.size()+1),rank(edges.size(),0);
    for(int i=0;i<edges.size();i++) {
        parent[i]=i;
    }
    for(auto e:edges) {
        int x=findParent(e[0],parent);
        int y=findParent(e[1],parent);
        if(x==y) {
            return e;
        }
        makeUnion(x,y,parent,rank);
    }
    return {0,0};
}

int main() {
    vector<vector<int>> edges = {{1,2},{2,3},{3,4},{1,4},{1,5}};
    vector<int> ans = findRedundantConnection(edges);
    for(auto node:ans) {
        cout << node << ' ';
    }
    cout << endl;
}