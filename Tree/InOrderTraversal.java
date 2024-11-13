package leetcodeProblems.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        return list;

    }

    private void inorder(TreeNode root, List<Integer> list) {
        if(root == null){
            return;
        }

        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }

    public List<Integer> inorderTraversalUsingStack(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (true){
            if(node != null){
                stack.push(node);
                node = node.left;
            }
            else {
                if(stack.isEmpty()){
                    break;
                }
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }

        return list;
    }
}
