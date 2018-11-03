public class UnionFind {
  Node[] node;
  private static class Node {
    int parent;
    boolean isRoot;

    private Node() {
      parent = 1;
      root = true;
    }
  }

  public UnionFind (int n) {
    node = new Node[n + 1];
    for (int e = 0; e<= n; e++) {
      node[e] = new Node();
    }
  }

  public void union(int a, int b) {
    if (node[a].parent < node[b].parent) {
      node[b].parent += node[a].parent;
      node[a].isRoot = false;
      node[b].parent = a;
    } else {
      node[a].parent += node[b].parent;
      node[b].isRoot = false;
      node[a].parent = a;
    }
  }

  public void find(int e) {

  }
}