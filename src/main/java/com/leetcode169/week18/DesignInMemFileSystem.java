package com.leetcode169.week18;

import java.util.List;
import java.util.TreeMap;

class FileNode {
    String name;
    boolean isFile;
    StringBuilder content;
    TreeMap<String, FileNode> children;

    public FileNode(String name, boolean isFile) {
        this.name = name;
        this.isFile = isFile;
        this.content = new StringBuilder();
        this.children = new TreeMap<>();
    }
}

public class DesignInMemFileSystem {

    private FileNode root;
     public DesignInMemFileSystem() {
        this.root = new FileNode("", false);
     }

    
    public List<String> ls(String path) {
        FileNode node = traverse(path, false);
        if(node == null) return List.of();

        if(node.isFile){
            return List.of(node.name);
        } else {
            return node.children.keySet().stream().toList();
        }
    }


    public void mkdir(String path) {
        traverse(path, true);
    }

    public void addContentToFile(String filePath, String content) {
        FileNode node = traverse(filePath, true);
        node.isFile = true;
        node.content.append(content);
    }
    
    public String readContentFromFile(String filePath) {
        FileNode node = traverse(filePath, false);
        if(node == null || !node.isFile) return "";
        return node.content.toString();
    }

    private FileNode traverse(String path, boolean create) {
        String[] parts = path.split("/");
        FileNode current = root;

        for(String part: parts){
            if(part.isEmpty()) continue;
            if(!current.children.containsKey(part)){
                if(create){
                    current.children.put(part, new FileNode(part, false));
                } else {
                    return null;
                }
            }
            current = current.children.get(part);
        }

        return current;
    }
    

    
}
