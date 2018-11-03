public class LeftistHeap {
  private ListNode Root;
  private class ListNode{
    int key;
    int npl;
    ListNode left;
    ListNode right;

    public ListNode(int key, ListNode left, ListNode right) {
      this.key = key;
      this.npl = 0;
      this.left = left;
      this.right = right;
    }
  }

  private ListNode merge(ListNode x, ListNode y) {
    if (x == null) return y;
    if (y == null) return x;

    if (x.key < y.key) {
      ListNode temp = x;
      x = y;
      y = temp;
    }

    // 将x的右孩子和y合并，"合并后的树的根"是x的右孩子。
    x.right = merge(x.right, y);

    // 如果"x的左孩子为空" 或者 "x的左孩子的npl<右孩子的npl"
    // 则，交换x和y
    if (x.left == null || x.left.npl < x.right.xpl) {
      ListNode tempSwitch = x.left;
      x.left = x.right;
      x.right = tempSwitch;
    }

    if (x.right == null || x.left == null) {
      x.npl = 0;
    } else {
      x.npl = x.left.npl > x.right.npl ? x.right.npl + 1 : x.left.npl + 1;
    }
    return x;
  }

  public void merge(LeftistHeap right) {
    this.Root = merger(this.Root, right.Root);
  }

  public void insert(int key) {
    ListNode newNode = new ListNode(key, null, null);
    if (newNode != null)
      merge(this.Root, newNode);
  }

  // 移除跟节点
  public int remove() {
    ListNode left = this.Root.left;
    ListNode right = this.Root.right;

    int key = this.Root.key;
    this.Root = null;
    this.Root = merge(left, right);

    return key;
  }

}