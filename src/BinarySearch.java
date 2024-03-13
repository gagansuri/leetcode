import java.util.HashMap;
import java.util.Map;

public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {1,4,5,8,9,11,15};
        Map<Character,Integer> map = new HashMap<>();

        System.out.println(search(nums,5));
        System.out.println(search(nums,1));
        System.out.println(search(nums,7));
    }

    static int search(int[] nums, int target) {
        int start = 0 , end = nums.length-1;
        while(start <= end) {
            int mid = start + (end-start)/2;
            if(target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                end = mid-1;
            } else {
                start = mid +1;
            }
        }
    return -1;
    }
}
