package com.examples;

public class Permutation {

    public static void permute(String str, int l, int r) {

        if(l == r) {
            System.out.println(str);
        } else {
            for(int i =1 ; i<= r ; i ++) {

                str = swap(str, l, i);
                permute(str, l+1, r);
                str = swap(str, l , i);
                //System.out.println(str);
            }
        }


    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }

    public static String swap(String str, int l, int j) {
        char[] ch = str.toCharArray();
        char temp = ch[l];
        ch[l] = ch[j];
        ch[j] = temp;
        return String.valueOf(ch);


    }

    public static void main(String args[]) {
        String permuteString = "ABC";
        //permute(permuteString, 0, permuteString.length()-1);
        permutation("", permuteString);
    }
}
