package leetcodeProblems.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root,list);
        return list;

    }

    private void preorder(TreeNode root, List<Integer> list) {
        if(root == null){
            return;
        }

        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right,list);
    }

    public List<Integer> preorderTraversalStack(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right != null){
                stack.push(node.right);
            }
        }

        return list;
    }


}
