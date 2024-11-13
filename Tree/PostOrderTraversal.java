package leetcodeProblems.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorder(root,list);
        return list;

    }

    private void postorder(TreeNode root, List<Integer> list) {
        if(root == null){
            return;
        }
        postorder(root.left,list);
        postorder(root.right,list);
        list.add(root.val);
    }

    public List<Integer> postorderTraversalUsingTwoStack(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty()){
            root = stack1.pop();
            stack2.push(root);

            if(root.left != null){
                stack1.push(root.left);
            }

            if(root.right != null){
                stack1.push(root.right);
            }
        }

        while (!stack2.isEmpty()){
            list.add(stack2.pop().val);
        }

        return list;
    }
}
