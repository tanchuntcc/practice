package binarytree;

/**
 * @author 谭春
 * Date: 2020/3/28
 * Description:
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
 * 说明:
 *
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 *
 * 思路1.使用search时，前缀查询返回false，所以需要一个isEnd变量，保存单词的结束位置。
 */
public class Trie {
    boolean isEnd;
    Trie[] tries;

    public Trie() {
        //创建一个26位的数组
        tries = new Trie[26];
    }

    public void insert(String word) {
        if (word.length() == 0) {
            return;
        }
        //开始时在Trie中创建并实例化了一个head节点，会一致自己创建自己导致栈溢出。。。使用this代表当前的类
        Trie aTry = this;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            //如果字符不存在，则创建
            if (aTry.tries[c] == null) {
                aTry.tries[c] = new Trie();
            }
            //向下遍历字典树
            aTry = aTry.tries[c];
        }
        //单词插入完成后，在最后一个字符的位置标记上isEnd
        aTry.isEnd = true;
    }

    public boolean search(String word) {
        Trie aTry = this;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';

            if (aTry.tries[c] == null) {
                return false;
            }
            aTry = aTry.tries[c];
        }
        //如果isEnd不为true，说明该词只是一个前缀，也返回false
        if (aTry.isEnd) {
            return true;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        Trie aTry = this;
        for (int i = 0; i < prefix.length(); i++) {
            int c = prefix.charAt(i) - 'a';
            //如果不包含字符，则返回false
            if (aTry.tries[c] == null) {
                return false;
            }
            aTry = aTry.tries[c];
        }
        return true;
    }
}

