package leetcodeProblems.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int lc = maxDepth(root.left);
        int rc = maxDepth(root.right);

        return Math.max(lc,rc)+1;

    }

    public int maxDepthUsingQueue(TreeNode root){
        if(root == null){
            return 0;
        }

        int lastNode =0;
        int level = -1;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (true){
            lastNode = queue.size();
            if(lastNode == 0){
                return level;
            }

            while (lastNode > 0){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
                lastNode --;
            }
            level++;
        }
    }
}
