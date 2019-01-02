package com.examples;

public class MissingNumberInArray {

    public static int getMissingNumberInArray() {

       int[] arr = {1,4,3,-1};
        int sum = 0;
        int size = arr.length;

       for(int i =0 ; i < size ; i ++) {
           if( arr[i] > 0) {
                sum += arr[i];
           }
       }

       int j = (size*(size+1)/2) - sum;
       return j;
    }

    public static void main(String args[]) {
        System.out.println(getMissingNumberInArray());
    }
}
