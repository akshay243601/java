package com.akshay.customHashTable;

import java.util.ArrayList;
import java.util.List;

public class HashTable<K, V> {
    List<HashNode<K, V>> bucketArray;
    int bucketSize;
    int size;

    public HashTable() {
        this.bucketArray = new ArrayList<HashNode<K, V>>();
        this.bucketSize = 16;
        for(int i = 0; i < this.bucketSize; i++) {
            this.bucketArray.add(null);
        }
    }

    private int getBucketIndex(K key) {
        return key.hashCode()%this.bucketSize;
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> node = bucketArray.get(bucketIndex);
        while(node != null) {
            if(node.key == key) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public V remove(K key) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> node = bucketArray.get(bucketIndex);
        HashNode<K, V> prev = null;
        while(node != null) {
            if(node.key == key) {
                break;
            }
            prev = node;
            node = node.next;
        }

        if(node == null) {
            return null;
        }

        size--;

        if(prev == null) {
            bucketArray.set(bucketIndex, node.next);
        } else {
            prev.next = node.next;
        }
        return node.value;
    }

    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> node = bucketArray.get(bucketIndex);
        while(node != null) {
            if(node.key == key) {
                node.value = value;
                return;
            }
            node = node.next;
        }

        node = bucketArray.get(bucketIndex);

        size++;

        HashNode<K, V> newHashNode = new HashNode<>(key, value);
        newHashNode.next = node;
        bucketArray.set(bucketIndex, newHashNode);

        if(bucketSize/size < 0.7) {
            List<HashNode<K, V>> temp = bucketArray;
            this.bucketArray = new ArrayList<>();
            this.bucketSize = this.bucketSize*2;

            for(int  i = 0; i < this.bucketSize; i++) {
                this.bucketArray.add(null);
            }
            size = 0;
            for(int  i = 0; i < temp.size(); i++) {
                HashNode<K, V> tempNode = temp.get(i);
                while(tempNode != null) {
                    put(tempNode.key, tempNode.value);
                    tempNode = tempNode.next;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getCanonicalName());
        sb.append(" [ ");
        for(int i = 0; i < bucketArray.size(); i++) {
            HashNode<K, V> tmpNode = bucketArray.get(i);
            while(tmpNode != null) {
                sb.append(tmpNode.key + " = " + tmpNode.value);
                sb.append(",");
                tmpNode = tmpNode.next;
            }
        }

        if(sb.lastIndexOf(",") == sb.length()-1) {
            sb.deleteCharAt(sb.lastIndexOf(","));
        }
        sb.append(" ] ");
        return sb.toString();
    }
}
