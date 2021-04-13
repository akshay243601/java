package com.akshay.array;


import java.util.ArrayList;
import java.util.List;

//https://drive.google.com/file/d/14EorgiFKh3SkPfait8Xf4SavbUEH143G/view?usp=sharing
//https://mega.nz/folder/4nBSDQjZ#j0VTTzegbyfVFlBdRy195Q
public class ProductSumOrSpecialArraySum {

    private static int productSum(List<Object> arrays) {
        return productSum(arrays, 1);
    }

    private static int productSum(List<Object> arrays, int multiplier) {
        int sum = 0;
        for(Object val : arrays) {
            if(val instanceof List || val instanceof ArrayList) {
                sum = sum + productSum((List<Object>) val, multiplier + 1);
            } else {
                sum = sum + (int)val;
            }
        }
        return sum * multiplier;
    }


    public static void main(String[] args) {
        List<Object> arrays = new ArrayList<>();
        arrays.add(4);
        arrays.add(2);
        arrays.add(-1);


        List<Object> arraysNested1 = new ArrayList<>();
        arraysNested1.add(4);
        arraysNested1.add(2);
        arraysNested1.add(4);

        arrays.add(arraysNested1);
        arrays.add(5);

        List<Object> arraysNested2 = new ArrayList<>();
        arraysNested2.add(4);
        arraysNested2.add(2);

        List<Object> arraysNested3 = new ArrayList<>();
        arraysNested3.add(1);
        arraysNested3.add(3);
        arraysNested3.add(4);

        arraysNested2.add(arraysNested3);
        arraysNested2.add(5);


        arrays.add(arraysNested2);
        arrays.add(5);


        System.out.println(productSum(arrays));
    }
}
