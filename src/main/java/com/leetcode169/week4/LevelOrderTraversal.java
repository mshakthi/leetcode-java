package com.leetcode169.week4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.commonDataTypes.TreeNode;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();

        if(root==null){
            return results;
        }

        /**
         * Queue to store tree nodes for level-order traversal.
         * Uses LinkedList implementation to support FIFO operations needed for BFS traversal.
         */
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> currLevel = new ArrayList<>();
            for(int i =0;i<size;i++){
                TreeNode curr = queue.poll();

                currLevel.add(curr.val);

                if(curr.left!=null){
                    queue.add(curr.left);
                }

                if(curr.right!=null){
                    queue.add(curr.right);
                }
            }
            results.add(currLevel);
        }

        return results;
        
    }
}
