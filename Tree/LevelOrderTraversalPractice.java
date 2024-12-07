package leetcodeProblems.Tree;

import java.util.*;

public class LevelOrderTraversalPractice {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return  Collections.emptyList();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> listOfList = new ArrayList<>();

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
            listOfList.add(list);
        }
        return listOfList;
    }
}
