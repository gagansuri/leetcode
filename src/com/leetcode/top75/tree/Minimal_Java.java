package com.leetcode.top75.tree;


    import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
public class Minimal_Java {
    /*
         * Complete the 'minSum' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER_ARRAY num
         *  2. INTEGER k
         */

        public static int minSum(List<Integer> num, int k) {
            // Write your code here
            // find the k largest elements in this array
            // perform the operation ceil /2  upto k times
            // once k operations are performed
            // sum the elements in the array return

            // maxheap -> put all the elements in the max heap
            // for 1 to k
            // get the element perform the operation and put in back
            // sort ascending
            // perform operation
            // put it back - sort it again
            // perform the operation
            //nlogn * k

            // maxheap
            //n + k*n

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> n2.compareTo(n1));
            for (int n : num) {
                maxHeap.add(n);
            }

            for (int i = 0; i < k; i++) {
                int numberB4 = maxHeap.poll();
                //0.5 round
                int numberAfter = (int) Math.ceil(numberB4 / 2.0);
                maxHeap.add(numberAfter);

            }
            int sum = 0;
            for (int n : maxHeap) {
                sum += n;
            }
            return sum;
            // KlogN

            // NlogN +
            // 1 99 100
            // 1 99 50
            // poll should 99
        }



        public static void main1(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int numCount = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> num = IntStream.range(0, numCount).mapToObj(i -> {
                        try {
                            return bufferedReader.readLine().replaceAll("\\s+$", "");
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    })
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(toList());

            int k = Integer.parseInt(bufferedReader.readLine().trim());

            int result = minSum(num, k);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }

    public static void main(String[] args) {
        //List.of(1,1,1,1);
        //System.out.println(minSum(List.of(1,1,1,1),2));
        System.out.println(minSum(List.of(2,3),1));
    }


}

