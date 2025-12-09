package com.leetcode169.week16;

import com.commonDataTypes.TreeNode;

public class Codec {
    public final String SEP = ",";
    public final String NULL = "X";

    // Encodes a tree to a single string.
    /**
     * Encodes a tree to a single string.
     * 
     * This method converts a binary tree structure into a string representation
     * by traversing the tree and building a serialized format. The resulting
     * string can be used to reconstruct the original tree structure.
     * 
     * @param root the root node of the binary tree to be serialized
     * @return a string representation of the binary tree
     */
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        sb.append(root.val).append(SEP);
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(SEP);
        int[] index = new int[1];
        return deserializeHelper(values, index);
    }

    private TreeNode deserializeHelper(String[] values, int[] index) {
        if(index[0] >= values.length || values[index[0]].equals(NULL)){
            index[0]++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(values[index[0]]));
        index[0]++;
        root.left = deserializeHelper(values, index);
        root.right = deserializeHelper(values, index);
        return root;
    }
  
}
