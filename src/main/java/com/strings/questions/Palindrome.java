package com.strings.questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by cov-127 on 30/11/16.
 */
public class Palindrome {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter the string to check:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if(isPalindrome(str)){
            System.out.println("It's a palindrome.");
        }
        else{
            System.out.println("It's not a palindrome.");
        }
    }

    private static boolean isPalindrome(String str) {
        int N = str.length();
        for (int i = 0; i < N/2; i++)
            if (str.charAt(i) != str.charAt(N-1-i))
                return false;
        return true;
    }
}
