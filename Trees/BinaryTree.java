package Trees;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

public class BinaryTree {
    public Stack<TreeNode> st;

    BinaryTree() {
        st = new Stack<>();
    }
    public void inorderTraversal(TreeNode root) {
        List<Integer> in = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            in.add(curr.val);
            curr = curr.right;
        }
        System.out.println("inorder: ");
        printOrder(in);
    }

    public void preorderTraversal(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        TreeNode curr = root;
        st.push(curr);
        while (!st.isEmpty()) {
            curr = st.pop();
            if (curr != null) {
                pre.add(curr.val);
            }
            if (curr.right != null) {
                st.push(curr.right);
            }
            if (curr.left != null) {
                st.push(curr.left);
            }
        }
        System.out.println("preorder: ");
        printOrder(pre);
    }

    public void postorderTraversal(TreeNode root) {
        LinkedList<Integer> post = new LinkedList<>();
        TreeNode curr = root;
        st.push(curr);
        while (!st.isEmpty()) {
            curr = st.pop();
            post.addFirst(curr.val);
            if (curr != null) {
                if (curr.left != null) {
                    st.push(curr.left);
                }
                if (curr.right != null) {
                    st.push(curr.right);
                }
            }
        }
        System.out.println("inorder: ");
        printOrder(post);
    }

    public void levelorderTraversal(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();
        TreeNode curr = root;
        q.offer(curr);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = size; i > 0; i--) {
                curr = q.poll();
                level.add(curr.val);
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            levels.add(level);
        }
        System.out.println("Level order traversal");
        printLevelOrder(levels);
    }
    
    public void printOrder(List<Integer> arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void printLevelOrder(List<List<Integer>> levels) {
        for (List<Integer> level : levels) {
            for (int i : level) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BinaryTree t = new BinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        t.inorderTraversal(root);
        t.preorderTraversal(root);
        t.postorderTraversal(root);
        t.levelorderTraversal(root);
    }
}
