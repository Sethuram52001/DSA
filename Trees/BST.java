package Trees;

import java.util.*;

/*class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}*/

public class BST {
    TreeNode root;

    BST() {
        this.root = null;
    }


    public void insert(int value) {
        this.root = insertHelper(this.root, value);
    }

    public TreeNode insertHelper(TreeNode root, int value) {
        if(root == null)
            return new TreeNode(value);
        
        if(root.val < value) {
            root.right = insertHelper(root.right, value);
        }

        else if(root.val > value) {
            root.left = insertHelper(root.left, value);
        }

        else  {
            root.val = value;
        }

        return root;
    }

    public void delete(int value) {
        this.root = deleteHelper(this.root, value);
    }

    public TreeNode deleteHelper(TreeNode root, int value) {
        if(root == null) {
            return root;
        }
        if(root.val < value) {
            root.right = deleteHelper(root.right, value);
        }
        else if(root.val > value) {
            root.left = deleteHelper(root.left, value);
        }
        else {
            // 0 or 1 child just change the links
            if(root.left == null) {
                return root.right;
            }
            else if(root.right == null) {
                return root.left;
            }
            // with 2 children
            root.val = inorderSuccessor(root.right);
            root.right = deleteHelper(root.right, root.val);
        }
        return root;
    }

    public int inorderSuccessor(TreeNode root) {
        int min = root.val;
        while(root.left != null) {
            min = root.left.val;
            root = root.left;
        }
        return min;
    }

    public void search(int value) {
        TreeNode curr = this.root;
        while(curr != null) {
            if(curr.val < value) {
                curr = curr.right;
            }
            else if(curr.val > value) {
                curr = curr.left;
            }
            else {
                System.out.println("value: " + value+ " is present in the bst" );
                return;
            }
        }
        System.out.println("value: " + value + " isn't present in the bst");
    }

    public void inorder() {
        inorderHelper(this.root);
        System.out.println();
    }

    void inorderHelper(TreeNode root) {
        if(root != null) {
            inorderHelper(root.left);
            System.out.print(root.val + " ");
            inorderHelper(root.right);
        }
    }

    public static void main(String[] args) {
        BST t = new BST();
        t.insert(50);
        t.insert(30);
        t.insert(20);
        t.insert(40);
        t.insert(70);
        t.insert(60);
        t.insert(80);
        System.out.println("inorder: ");
        t.inorder();
        System.out.println("inorder: ");
        t.delete(20);
        t.inorder();
        System.out.println("inorder: ");
        t.delete(30);
        t.inorder();
        System.out.println("inorder: ");
        t.delete(50);
        t.inorder();
        t.delete(100);
        t.search(100);
        t.search(40);
    }    
}
