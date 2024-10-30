package leetcodeProblems.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Symmetric {

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return false;
        }

        Queue<TreeNode> leftqueue = new LinkedList<>();
        Queue<TreeNode> rightqueue = new LinkedList<>();
        leftqueue.add(root.left);
        rightqueue.add(root.right);

        while (!leftqueue.isEmpty() && !rightqueue.isEmpty()){
            TreeNode leftNode = leftqueue.poll();
            TreeNode rightNode = rightqueue.poll();
            if(leftNode == null && rightNode == null){
                continue;
            }
           if(leftNode == null || rightNode == null || leftNode.val != rightNode.val){
               return false;
           }
               leftqueue.add(leftNode.left);
                rightqueue.add(rightNode.right);
                leftqueue.add(leftNode.right);

                rightqueue.add(rightNode.left);

        }

        return true;
    }
}
