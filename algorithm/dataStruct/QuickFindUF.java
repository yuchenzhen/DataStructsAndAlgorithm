public class QuickFindUF {
  public int[] id;
  public void QuickFindUF (int n) {
    int[] id = new int[n];
    for (int i = 0; i < n; i++) {
      id[i] = i;
    }
  }

  public boolean equal(int p, int q) {
    return id[p] == id[q];
  }

  /**
     * 合并p的子集和q的子集
     * 将 p 的子集合并到 q 子集里面
     * 将所有值等于id[p]的对象的值改为id[q]
     * @param p
     * @param q
     */
  public void union(int p, int q) {
    int pid = id[p];
    int qid = id[q];
    for (int i = 0; i < id.length; i++) {
      if (id[i] == pid)
        id[i] = qid;
    }
  }
}