package leetcodeProblems.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DiameterOfABinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int diameter  = 0;
        if(root != null){
            stack.push(root);
        }
        Map<TreeNode,Integer> map = new HashMap<>();

        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            if(node.left != null && !map.containsKey(node.left)){
                stack.push(node.left);
            }
            else if (node.right != null && !map.containsKey(node.right)){
                stack.push(node.right);
            }
            else {
                stack.pop();
                int lh = map.getOrDefault(node.left,0);
                int rh = map.getOrDefault(node.right,0);
                map.put(node, 1+Math.max(lh,rh));

                diameter = Math.max(diameter,lh+rh);
            }
        }

        return diameter;
    }
}
