package com.gayle;
public class Fibonacci {
    //1 1 2 3 5 8

    static int fib(int n) {
        if(n == 1 || n == 0) {
            return 1;
        } else {
            return fib(n-1) + fib(n-2);
        }

    }

    static void printFibonacci(){
        for(int i = 0 ; i <10; i++) {
            System.out.println(fib(i));
        }
    }

    public static void main(String[] args) {
        printFibonacci();
    }
}


/**
 * Time complexity of recursion is code branches ^ steps so this would be 2^N
 *
 * for 1 : 2^1, for 2 : 2^2 , for 3 : 3^2
 *
 * so total time is 2^1 + 2^2 + 2^3 ... 2^N which is 2^N+1 => O(2^N)
 */