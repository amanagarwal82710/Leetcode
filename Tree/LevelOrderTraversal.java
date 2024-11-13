package leetcodeProblems.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        countLevel(root,ans);
        return ans;
    }

    private void countLevel(TreeNode root, List<List<Integer>> ans) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return;
        }

        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                list.add(node.val);

                if(node.left != null){
                    queue.add(node.left);
                }

                if(node.right != null){
                    queue.add(node.right);
                }
            }
            ans.add(list);
        }
    }
}
