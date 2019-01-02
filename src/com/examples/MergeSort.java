package com.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    private static List<Integer> merge(List<Integer> left, List<Integer> right, List finalList) {

        if(left.isEmpty()) {
            finalList.addAll(right);
        } else if(right.isEmpty()) {
            finalList.addAll(left);
        } else {
            if(left.get(0) <= right.get(0)) {
                finalList.add(left.get(0));
                return merge(left.subList(1, left.size()), right, finalList);
            } else {
                finalList.add(right.get(0));
                return merge(left, right.subList(1, right.size()), finalList);
            }
        }



        return finalList;

    }

    public static List<Integer> mergeSort(List<Integer> list) {

        int m = list.size()/2;
        System.out.print(m);
        if(m==0) {
            return list;
        }

        return merge(mergeSort(list.subList(0,m)), mergeSort(list.subList(m, list.size())), new ArrayList<Integer>());

    }

    public static void main(String args[]) {

        mergeSort(Arrays.asList(2,4,12,10,3,4,5)).forEach(System.out:: println);
    }
}
