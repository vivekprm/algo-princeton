package com.algo.part1.chapter1.basicDs.stack.application;

import com.algo.part1.chapter1.basicDs.stack.LinkedListStack;
import com.algo.part1.chapter1.basicDs.stack.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by cov-127 on 22/12/16.
 */
public class InflixExpression {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the expression to evaluate: ");
        String expression = br.readLine();
        expression.replaceAll("\\s+","");
        String[] strs = expression.split("");
        Stack<String> ops = new LinkedListStack<>();
        Stack<Double> vals = new LinkedListStack<>();

        for(int i = 1; i < strs.length; i++){
            String str = strs[i];
            if(str.equals("("));
            else if(str.equals("*") || str.equals("+") || str.equals("-") || str.equals("/")){
                ops.push(str);
            }
            else if(str.equals(")")){
                String op = ops.pop();
                Double val1 = vals.pop();
                Double val2 = vals.pop();
                Double val = null;
                if(op.equals("*")){
                    val = val1 * val2;
                }
                else if(op.equals("+")){
                    val = val1 + val2;
                }
                else if(op.equals("-")){
                    val = val1 - val2;
                }
                else if(op.equals("/")) {
                    val = val1 / val2;
                }
                vals.push(val);
            }
            else{
                vals.push(Double.parseDouble(str));
            }
        }
        System.out.println("Result is: "+ vals.pop());
    }
}
