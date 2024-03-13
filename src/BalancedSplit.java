import java.util.*;

public class BalancedSplit {

    public static void main(String[] args) {
        int[] arr1 = {1, 5, 7, 1};
        assert balancedSplitExists(arr1);
        System.out.println(balancedSplitExists(arr1));
        int[] arr2 = {12, 7, 6, 7, 6};
        System.out.println(balancedSplitExists(arr2));
    }

    static boolean balancedSplitExists(int[] arr) {
        // Write your code here
        Arrays.sort(arr);
        int left = 1 , right = arr.length - 2;
        int leftSum = arr[0] , rightSum = arr[arr.length-1] ;
        while(left <= right) {
            if (leftSum == rightSum && right - left == 1) {
                //if left + right == nums.length
                return true;
            } else if(leftSum < rightSum) {
                leftSum += arr[left];
            } else {
                //left sum > right
                rightSum += arr[right--];
            }

        }
        return false;
    }
}
