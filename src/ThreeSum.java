import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums={-1,0,1,2,-1,-4};
        threeSum(nums);
    }

    //[-1,0,1,2,-1,-4]
    public static List<List<Integer>> threeSum(int[] nums) {
        Map<Integer,Integer> lookup = new HashMap<>();
        List<List<Integer>> finalResult = new ArrayList<>();
        for(int i = 0 ;i< nums.length;i++) {
            int target = nums[i];
            for(int j = i+1; j<nums.length;j++) {
                int key = target + nums[j];
                key = -1*key;
                if(lookup.containsKey(key)) {
                    List<Integer> result = new ArrayList<>();
                    result.add(target);
                    result.add(nums[j]);
                    result.add(key);
                    finalResult.add(result);
                } else {
                    lookup.put(nums[j],j);
                }
            }
        }
        return finalResult;
    }
}
