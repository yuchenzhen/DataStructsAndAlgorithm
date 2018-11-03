public class QuickUnionUF {
  public int[] id;
  public QuickUnionUF(int N) {
    int[] id = new int[N];
    for(int i = 0; i<N; i++) id[i] = i;
  }

  public int root(int p) {
    if (id[p] == p)
      return p;
    return root(id[p]);
  }

  public boolean equal(int p, int q) {
    return root(p) == root(q);
  }

  public void union(int p, int q) {
    if (!equal(p, q))
      id[root(p)] = root(q);
  }
}