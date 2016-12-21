package com.strings.questions;

import java.util.Scanner;

/**
 * Created by cov-127 on 30/11/16.
 */
public class NameExtensionCheck {
    public static void main(String[] args) {
        System.out.println("Enter the file name to check:");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int lastIndex = str.lastIndexOf('.');
        String extension = str.substring(lastIndex, str.length());
        String fileName = str.substring(0, lastIndex);
        System.out.println("File name is: " + fileName);
        System.out.println("File extension is: " + extension);
    }
}
