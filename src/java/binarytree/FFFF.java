package binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by TanChun on 2018/12/19.
 */
public class FFFF {
    class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) {
            val = x;
        }
    }

    class Solution {
        public void connect(TreeLinkNode root) {
            if (root == null) return;
            Queue<TreeLinkNode> nodes = new LinkedList<>();
            nodes.offer(root);
            while (!nodes.isEmpty()) {
                int size = nodes.size();
                for (int i = 0; i < size; i++) {
                    TreeLinkNode cur = nodes.poll();
                    TreeLinkNode n = null;
                    if (i < size - 1) {
                        n = nodes.peek();
                    }
                    cur.next = n;
                    if (cur.left != null) nodes.offer(cur.left);
                    if (cur.right != null) nodes.offer(cur.right);
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}

