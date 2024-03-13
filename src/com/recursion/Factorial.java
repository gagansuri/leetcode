package com.recursion;
public class Factorial {

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        System.out.println("Factorial of 1 is : "+factorial.calculateFactorial(1));
        System.out.println("Factorial of 1 is : "+factorial.calculateFactorial(2));
        System.out.println("Factorial of 1 is : "+factorial.calculateFactorial(3));
    }

    private int calculateFactorial1(int n) {
        if(n <= 0) {
            return 1;
        } else {
            return n*calculateFactorial1(n-1);
        }
    }

    private int calculateFactorial(int n) {
        if(n <= 0) {
            return 1;
        }
        return n*calculateFactorial(n-1);
    }

}
