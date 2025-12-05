package com.leetcode169.week7;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.commonDataTypes.TreeNode;

public class BinaryTreeRightSideView {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new java.util.ArrayList<>();
            rightViewHelper(root, result);
            return result;
        }

        private void rightViewHelper(TreeNode node, List<Integer> result){
            if(node == null){
                return;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(node);

            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i =0;i<size;i++){
                    TreeNode current = queue.poll();
                    if(i == size -1){
                        result.add(current.val);
                    }

                    if(current.left != null){
                        queue.offer(current.left);
                    }

                    if(current.right != null){
                        queue.offer(current.right);
                    }
                }
            }
        }
        
    
}
