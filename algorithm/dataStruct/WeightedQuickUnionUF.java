public class WeightedQuickUnionUF {
  public int[] id;
  public int[] sz;
  public count;
  public WeightedQuickUnionUF(int N) {
    int[] id = new int[N];
    for(int i = 0; i<N; i++) id[i] = i;
    for(int i = 0; i<N; i++) sz[i] = 1;
    count = N;
  }

  public int root(int p) {
    if (id[p] == p)
      return p;
    return root(id[p]);
  }

  /**
   * 路径压缩
   * @param p
   * @param q
   * @return
   */
  // private int root(int i){
  //   while(i != id[i]){
  //       id[i] = id[id[i]];//(父节点的父节点)
  //       i = id[i];//i和id[i] 一起更新
  //   }
  //   return i;
  // }

  public boolean equal(int p, int q) {
    return root(p) == root(q);
  }

  public void union(int p, int q) {
    if (!equal(p, q))
      if (sz[p] < sz[q]) {
        sz[q] += sz[p];
        id[q] = root(p);
        count--;
      } else {
        sz[p] += sz[q];
        id[p] = root(q);
        count--;
      }
  }
}