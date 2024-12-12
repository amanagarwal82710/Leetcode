package leetcodeProblems.Bit;

import leetcodeProblems.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinimumNumberOfFlipsToMakeAOrBEqualToC {

    public int minFlips(int a, int b, int c) {
        int flipCount =0;

        while (a >0 || b>0 || c>0) {

            if ((c & 1) == 1) {
                if ((a & 1) == 0 && (b & 1) == 0) {
                    flipCount++;
                }
            } else {
                if ((a & 1) == 1) {
                    flipCount++;
                }

                if ((b & 1) == 1) {
                    flipCount++;
                }
            }

            c = c >> 1;
            a = a >> 1;
            b = b >> 1;

        }

        return flipCount;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        st1.add(root);

        while (!st1.isEmpty()){
            st2.push(st1.peek().val);
            TreeNode node = st1.pop();

            if(node.left != null){
                st1.push(node.left);
            }

            if(node.right != null){
                st1.push(node.right);
            }

        }

        while (!st2.isEmpty()){
            ans.add(st2.pop());
        }

        return ans;
    }
}
