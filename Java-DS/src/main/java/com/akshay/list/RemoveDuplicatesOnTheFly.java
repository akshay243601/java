package com.akshay.list;

import java.util.*;

/*
Given a continuous stream of strings,
maintain strings such that duplicate are eliminated on the fly.
The interviewer wanted working code.
So coded the solution during the interview and emailed it to him 10 mins after.
*/
public class RemoveDuplicatesOnTheFly {

    private static List<String> streamValues = new ArrayList<>();
    private static Set<String> outputs = new LinkedHashSet<>();
    private static Set<String> duplicates = new HashSet<>();
    private static int i = 1;
    private static void processRemoveDuplicates() {
        while(true) {
            try {
                System.out.println("Adding Elements into the Stream ........ ");
                if(i == 1) {
                    addValuesIntoList(Arrays.asList("A", "B", "C", "D", "E"));
                } else if(i == 2) {
                    addValuesIntoList(Arrays.asList("B", "C", "F", "G", "H"));
                }  else if(i == 3) {
                    addValuesIntoList(Arrays.asList("L", "X", "Y", "Z", "C"));
                }
                Thread.sleep(3000);
            } catch (Exception e) {

            }
            removeDuplicates();
            printList();
            i++;
            if(i >= 4) {
                break;
            }
        }
    }

    private static void removeDuplicates() {
        for(String str : streamValues) {
            if(outputs.contains(str)) {
                outputs.remove(str);
                duplicates.add(str);
            } else if(!duplicates.contains(str)) {
                outputs.add(str);
            }
        }
    }

    private static void printList() {
        System.out.println("OUTPUT : " +  outputs);
        System.out.println("DUPLICATES : " + duplicates);
    }

    private static void addValuesIntoList(List<String> vals) {
        streamValues.clear();
        streamValues.addAll(vals);
    }

    public static void main(String[] args) {
        processRemoveDuplicates();
    }
}
