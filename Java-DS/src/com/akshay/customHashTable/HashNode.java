package com.akshay.customHashTable;

public class HashNode<K, V> {
    K key;
    V value;
    HashNode<K, V> next;
    HashNode<K, V> prev;

    public HashNode() {

    }

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

}
