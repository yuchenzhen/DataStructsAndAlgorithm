public class Trie {
    private TrieNode root;

    public Trie () {
        root = new TrieNode();
    }

    // insert
    public void insert (String words) {
        TrieNode node = root;
        for (int i = 0; i < words.length(); i++) {
            char word = words.charAt(i);
            if (!node.containsKey(word)) {
                node.put(word, new TrieNode());
            }
            node = node.get(word);
        }
        node.setEnd();
    }


    public TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i =0; i < word.length(); i++) {
            char current = word.charAt(i);
            if (node.containsKey(current)) {
                node = node.get(current);
            } else {
                return null;
            }
        }
        return node;
    }

    public boolean search (String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public boolean startsWith (String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}
