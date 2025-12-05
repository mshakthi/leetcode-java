package com.leetcode169.week9;

import java.util.HashMap;

class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
public class LRUCache {
    HashMap<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);
        remove(node);
        insertAtEnd(node);

        return node.value;
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAtEnd(Node node){
        Node recent = tail.prev;

        recent.next = node;
        node.prev = recent;
        node.next = tail;
        tail.prev = node;
    }
    
    public void put(int key, int value) {
        Node newNode = new Node(key, value);
        if(map.containsKey(key)){
            remove(map.get(key));
            map.put(key, newNode);
        } else {
            map.put(key, newNode);
            
        }

        insertAtEnd(newNode);
        if(map.size() > capacity){
            Node lru = head.next;
            remove(lru);
            map.remove(lru.key);
        }
        
    }
}

