package leetcodeProblems.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BalancedBinaryTree {

    public static boolean isBalanced(TreeNode root) {
        int val = depth(root);
        return val != -1;

    }

    public static int depth(TreeNode root){
        if(root == null){
            return 0;
        }

        int lh = depth(root.left);
        int rh = depth(root.right);

        if(lh == -1 || rh == -1){
            return -1;
        }

        if(Math.abs(lh-rh) > 1){
            return -1;
        }


        return Math.max(lh,rh)+1;
    }



    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.left.right.right.right = new TreeNode(7);

        // Creating an instance of the Solution clas

        // Checking if the tree is balanced
        if (isBalanced(root)) {
            System.out.println("The tree is balanced.");
        } else {
            System.out.println("The tree is not balanced.");
        }
    }
}
