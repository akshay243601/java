package com.akshay.customLRU;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
    int capacity;
    Map<K, HashNode<K, V>> cacheMap;
    HashNode<K, V> head, tail;
    int count = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        head = new HashNode<>();
        tail = new HashNode<>();

        head.next = tail;
        tail.prev = head;
    }

    public V get(K key) {
        if(cacheMap.containsKey(key)) {
            HashNode<K, V> node = cacheMap.get(key);
            remomveANode(node);
            addToHead(node);
            return node.value;
        }
        return null;
    }

    public V put(K key, V value) {
        if(cacheMap.containsKey(key)) {
            HashNode<K, V> node = cacheMap.get(key);
            node.value = value;
            remomveANode(node);
            addToHead(node);
            return node.value;

        } else {
            HashNode<K, V> newNode = new HashNode<>(key, value);
            if(count < capacity) {
                count++;
                addToHead(newNode);
            } else {
                cacheMap.remove(tail.prev.key);
                remomveANode(tail.prev);
                addToHead(newNode);
            }
            cacheMap.put(key, newNode);
        }
        return value;
    }


    private void addToHead(HashNode<K, V> node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private void remomveANode(HashNode<K, V> node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public void print(){
        HashNode<K, V> node = head.next;
        System.out.println();
        System.out.println("Print LRU Cache");
        while(node != null) {
            System.out.print(" { " + node.key + " = " + node.value + " }, ");
            node = node.next;
        }
    }
}



// Below Approach used when we dont want to have extra space for Head and tail

//package com.akshay.customLRU;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class LRUCache<K, V> {
//    int capacity;
//    Map<K, HashNode<K, V>> cacheMap;
//    HashNode<K, V> head, tail;
//    int count = 0;
//
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//        this.cacheMap = new HashMap<>();
//        head = tail = null;
//    }
//
//    public V get(K key) {
//        if(cacheMap.containsKey(key)) {
//            HashNode<K, V> node = cacheMap.get(key);
//            remomveANode(node);
//            addToHead(node);
//            return node.value;
//        }
//        return null;
//    }
//
//    public V put(K key, V value) {
//        if(cacheMap.containsKey(key)) {
//            HashNode<K, V> node = cacheMap.get(key);
//            node.value = value;
//            remomveANode(node);
//            addToHead(node);
//            return node.value;
//
//        } else {
//            HashNode<K, V> newNode = new HashNode<>(key, value);
//            if(count < capacity) {
//                count++;
//                if (head == null) {
//                    head = newNode;
//                    tail = newNode;
//                    return value;
//                }
//                addToHead(newNode);
//            } else {
//                cacheMap.remove(tail.key);
//                remomveANode(tail);
//                addToHead(newNode);
//            }
//            cacheMap.put(key, newNode);
//        }
//        return value;
//    }
//
//
//    private void addToHead(HashNode<K, V> node) {
//        node.next = head;
//        if(node.next != null) {
//            node.next.prev = node;
//            node.prev = head;
//        }
//        head = node;
//    }
//
//    private void remomveANode(HashNode<K, V> node) {
//        if(node.next == null) {
//            tail.prev.next = null;
//            tail = tail.prev;
//        } else {
//            node.next.prev = node.prev;
//            node.prev.next = node.next;
//        }
//    }
//
//    public void print(){
//        HashNode<K, V> node = head;
//        System.out.println();
//        System.out.println("Print LRU Cache");
//        while(node != null) {
//            System.out.print(" { " + node.key + " = " + node.value + " }, ");
//            node = node.next;
//        }
//    }
//}



