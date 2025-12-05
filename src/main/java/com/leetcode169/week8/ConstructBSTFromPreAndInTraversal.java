package com.leetcode169.week8;

import java.util.HashMap;

import com.commonDataTypes.TreeNode;

/**
 * Constructs a Binary Search Tree from given preorder and inorder traversal arrays.
 * 
 * <p>This class provides functionality to build a binary tree given two arrays representing
 * the preorder and inorder traversals of the tree. It uses a HashMap to optimize the lookup
 * of elements in the inorder array.</p>
 * 
 * <p>Algorithm:</p>
 * <ul>
 *   <li>The first element of preorder traversal is always the root</li>
 *   <li>Find the root in inorder traversal to determine left and right subtrees</li>
 *   <li>Recursively build left and right subtrees</li>
 * </ul>
 * 
 * <p>Time Complexity: O(n) where n is the number of nodes in the tree</p>
 * <p>Space Complexity: O(n) for the HashMap and recursion stack</p>
 * 
 * <p>Example:</p>
 * <pre>
 * {@code
 * int[] preorder = {3, 9, 20, 15, 7};
 * int[] inorder = {9, 3, 15, 20, 7};
 * ConstructBSTFromPreAndInTraversal constructor = new ConstructBSTFromPreAndInTraversal();
 * TreeNode root = constructor.buildTree(preorder, inorder);
 * // Returns a tree with root 3, left child 9, right child 20, etc.
 * }
 * </pre>
 * 
 */
public class ConstructBSTFromPreAndInTraversal {
    HashMap<Integer, Integer> inorderIndexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        buildInOrderIndexMap(inorder);
        return buildTreeHelper(preorder, 0, preorder.length -1, inorder, 0, inorder.length -1);
        
    }

    public void buildInOrderIndexMap(int[] inorder){
        inorderIndexMap = new HashMap<>();
        for(int i =0;i<inorder.length;i++){
            inorderIndexMap.put(inorder[i], i);
        }
    }   

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int inOrderIndex = inorderIndexMap.get(rootVal);
        int leftTreeSize = inOrderIndex - inStart;
        root.left = buildTreeHelper(preorder, preStart +1, preStart + leftTreeSize, inorder, inStart, inOrderIndex -1);
        root.right = buildTreeHelper(preorder, preStart + leftTreeSize +1, preEnd, inorder, inOrderIndex +1, inEnd);

        return root;
    }


}
