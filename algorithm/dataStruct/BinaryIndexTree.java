public class BinaryIndexTree {
  int[] tree;
  int length;
  public BinaryIndexTree (int length) {
    this.length = length;
    this.tree = new int[length+1];
  }

  public int sum (int index) {
    int sum = 0;
    while (index > 0) {
      sum += tree[index];
      index -= lowbit(index);
    }
    return sum;
  }

  public int sum (int start, int end) {
    return sum(end) - sum(start - 1);
  }

  public void put (int index, int value) {
    if (index < 1 || index > length) {
      throw new IllegalArgumentException("out of Range !");
    }
    while(index <= length) {
      tree[index] += value;
      index += lowbit(index);
    }
  }

  public int get (int index) {
    if (index < 1 || index > length) {
      throw new IllegalArgumentException("out of Range !");
    }
    int sum = tree[index];
    int z = index - lowbit(index);
    index--;
    while (index != z) {
      sum -= tree[index];
      index -= lowbit(index);
    }
    return sum;
  }

  public int getTest (int index) {
    return tree[index];
  }

  private int lowbit(int k) {
    return k&-k;
  }

  public static void main (String[] args) {
    int length = 15;
    BinaryIndexTree bTree = new BinaryIndexTree(length);
    for (int i = 1; i <= bTree.length; i++) {
      bTree.put(i, i);
    }

    for(int i = 1; i<=bTree.length; i++) {
      int value = bTree.get(i);
      int value2 = bTree.getTest(i);
      System.out.println("value is " + value  + " value2 is " + value2);
    }
    System.out.println();

    for(int i = 1; i <= bTree.length; i++) {
      int sum = bTree.sum(i);
      System.out.println("sum value is " + sum);
    }
  }
}