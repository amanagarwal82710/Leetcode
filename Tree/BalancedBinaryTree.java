package leetcodeProblems.Tree;

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        int val = depth(root);
        return val != -1;

    }

    public int depth(TreeNode root){
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
}
