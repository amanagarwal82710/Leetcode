package leetcodeProblems.Tree;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int lc = maxDepth(root.left);
        int rc = maxDepth(root.right);

        return Math.max(lc,rc)+1;

    }
}
