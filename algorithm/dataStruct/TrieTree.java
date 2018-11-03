public class TrieTree {
  private final int SIZE = 26;
  private Node root;

  private class Node {
    private boolean isStr;
    private int num;
    private Node[] child;

    public Node() {
      child = new Node[SIZE];
      isStr = false;
      num = 1;
    }
  }

  public TrieTree() {
    root = new Node();
  }

  /**
   * 检查字典树中是否完全包含字符串word
   * @param word
   * @return
   */
  public boolean hasStr(String word) {
    Node pNode = this.root;
    for (int i = 0; i < word.length(); i++) {
      int index = word.charAt(i) - 'a';
      if (pNode.child[index] == null || (index + 1 == word.length() && pNode.child[index + 1].isStr == false))
        return false;
      pNode = pNode.child[index];
    }
    return true;
  }

  /**
   * 在字典树中插入一个单词
   * @param word
   */
  public void insert(String word) {
    if (word == null || word.isEmpty())
      return;

    Node pNode = this.root;
    for (int i = 0; i < word.length(); i++) {
      int index = word.charAt(i) - 'a';
      if (pNode.child[index] == null) {
        Node temp = new Node();
        pNode.child[index] = temp;
      } else {
        pNode.child[index].num++;       //如果字典树中改路径上存在节点，则num加1，表示在该节点上有一个新的单词经过
      }
      pNode = pNode.child[index];
    }
    pNode.isStr = true;
  }

  /**
   * 统计在字典树中有多少个单词是以str为前缀的
   * @param str
   * @return
   */
  public int countPrefix(String str) {
    Node pNode = this.root;
    for(int i = 0; i < str.length(); i++) {
      int index = str.charAt(i) - 'a';
      if (pNode.child[index] == null)
        return 0;
      else
        pNode = pNode.child[index];
    }
    return pNode.num;
  }
}