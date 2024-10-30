package leetcodeProblems.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>() ;
        queue.add(p);
        queue.add(q);

        while (!queue.isEmpty()){
            TreeNode first = queue.poll();
            TreeNode second = queue.poll();

            if(first == null && second == null){
                continue;
            }
            if(first == null || second == null || first.val!=second.val){
                return false;
            }

            queue.add(p.left);
            queue.add(q.left);
            queue.add(p.right);
            queue.add(q.right);
        }

        return true;
    }
}
