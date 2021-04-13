package com.akshay.customHashTable;

//https://www.geeksforgeeks.org/implementing-our-own-hash-table-with-separate-chaining-in-java/
public class CustomHashTableDemo {

    public static void main(String[] args) {
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.put("Akshay", "Akshay Value");
        hashTable.put("Akshay1", "Akshay Value1");
        hashTable.put("Akshay2", "Akshay Value2");
        hashTable.put("Akshay3", "Akshay Value3");
        hashTable.put("Akshay4", "Akshay Value4");
        hashTable.put("Akshay5", "Akshay Value5");

        System.out.println(hashTable);


        System.out.println(hashTable.get("Akshay3"));
        System.out.println(hashTable.get("Akshay2"));

        System.out.println(hashTable.remove("Akshay2"));
        System.out.println(hashTable.get("Akshay2"));
        System.out.println(hashTable);

    }
}

