package leetcodeProblems.Tree;

import java.util.HashMap;
import java.util.Map;

public class Leetcode105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=inorder.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        TreeNode treeNode = constructTree(preorder,map,0,0,n-1);
        return treeNode;

    }

    private TreeNode constructTree(int[] preorder, Map<Integer,Integer> map,int ri,int left,int right){
        TreeNode root = new TreeNode(preorder[ri]);
        int mid = map.get(preorder[ri]);
        if(mid > left){
            root.left = constructTree(preorder,map,ri+1,left,mid-1);
        }
        if(mid < right){
            root.right = constructTree(preorder, map, ri + mid - left +1, mid+1, right);
        }

        return root;

    }
}
