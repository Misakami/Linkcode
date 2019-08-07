package week4;

/**
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Trie {

    class Node{
        boolean isEnd;
        Node[] son;
        Node(){
            isEnd = false;
            son = new Node[26];
        }
    }

    Node root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node p = root;

        for (int i = 0; i < word.length() ; i++) {
            int a = word.charAt(i) - 'a';
            if (p.son[a] == null) p.son[a] = new Node();
            p = p.son[a];
        }
        p.isEnd = true;
    }


    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node p = root;
        for (int i = 0; i < word.length() ; i++) {
            int a = word.charAt(i) - 'a';
            if (p.son[a] == null) return false;
            p = p.son[a];
        }
        if (p.isEnd) return true;
        return false;
    }


    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node p = root;
        for (int i = 0; i < prefix.length() ; i++) {
            int a = prefix.charAt(i) - 'a';
            if (p.son[a] == null) return false;
            p = p.son[a];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */