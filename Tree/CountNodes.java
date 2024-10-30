package leetcodeProblems.Tree;

public class CountNodes {

    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }


        int lN = countNodes(root.left);
        int rN = countNodes(root.right);

        return lN+rN+1;
    }
}
