package Session1;

import java.util.HashMap;
import java.util.Map;

class Trie {
    public Map<Character, Trie> children;
    public boolean isWord;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        children = new HashMap<Character, Trie>();
        isWord = false;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word.length() == 0) {
            isWord = true;
            return;
        }
        char cursor = word.charAt(0);
        if (children.containsKey(cursor) == false) {
            Trie letterNode = new Trie();
            children.put(cursor, letterNode);
        }
        children.get(cursor).insert(word.substring(1));
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word.length() == 0)
            return isWord;
        char cursor = word.charAt(0);
        if (children.containsKey(cursor) == false)
            return false;
        return children.get(cursor).search(word.substring(1));
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix.equals(""))
            return true;
        char cursor = prefix.charAt(0);
        if (children.containsKey(cursor) == false)
            return false;
        return children.get(cursor).startsWith(prefix.substring(1));
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

public class TrieDriver {
    public static void main(String[] args) {
        //code
        Trie root = new Trie();
        root.insert("apple");
        System.out.println(root.search("app"));
    }
}
