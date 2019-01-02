package com.examples;

public class Palidrome {


        public static void main(String[] args) {

            int num = -130, reversedInteger = 0, remainder, originalInteger;

            originalInteger = num;

            // reversed integer is stored in variable
            while( num != 0 )
            {
                remainder = num % 10;
                reversedInteger = reversedInteger * 10 + remainder;
                num  /= 10;
            }

            // palindrome if orignalInteger and reversedInteger are equal
            if (originalInteger == reversedInteger)
                System.out.println(originalInteger + " is a palindrome. " + reversedInteger);
            else
                System.out.println(originalInteger + " is not a palindrome. " + reversedInteger);
        }

}
