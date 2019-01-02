package com.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class NumberCountInArray {

    public static int getNumberCount() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        Map<Integer, Integer> isexist = new HashMap<>();

        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(2);

        int size = arrayList.size()/2;

        for(int i=0; i < arrayList.size() ; i ++) {
            if(isexist.get(arrayList.get(i)) == null) {
                isexist.put(arrayList.get(i), 1);
            } else if(isexist.get(arrayList.get(i)) < size) {
                isexist.put(arrayList.get(i), isexist.get(arrayList.get(i)) + 1);

            } else {
                isexist.put(arrayList.get(i), isexist.get(arrayList.get(i)) + 1);
                System.out.println(isexist.get(arrayList.get(i)));
                return arrayList.get(i);
            }
        }

        return 0;
    }

    public static int getNumberCount1() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();



        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(2);
        arrayList.add(3);

        int size = arrayList.size()/2;
 int count = 0;
 int ret = 0;
        for(int num : arrayList) {
            if(count == 0) {
                ret = num;
            }

            if(ret !=num) {
                count--;
            } else {
                count++;
            }
            if(count >= size) {
                return ret;
            }
        }

        return 0;
    }

    public static void main(String args[]) {
        System.out.println(getNumberCount());
        System.out.println(getNumberCount1());
    }
}
