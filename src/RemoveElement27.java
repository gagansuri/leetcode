import java.util.Arrays;

public class RemoveElement27 {
    public static void main(String[] args) {
        //int nums[] = {3,2,2,3}, val = 3;
        int nums[] = {0,1,2,2,3,0,4,2}, val = 2;
        removeElement(nums,val);
    }
    public static int removeElement(int[] nums, int val) {
        int index=0;
        for(int i =0;i<nums.length;i++) {
            if(nums[i]!=val) {
                nums[index++]=nums[i];
            }
        }
        return index;
    }
    public static int removeElement1(int[] nums, int val) {
        Arrays.sort(nums);
        for(int i = 0,j=0 ;i< nums.length;) {
            // find the location where nums[i] ! = val
            if(nums[i] != val) {
                i++;
            } else {
                j = i;
                while(j < nums.length && nums[j]==val) {
                    j++;
                }
                if(j< nums.length && i <nums.length) {
                    nums[i++] = nums[j];
                    nums[j] = val;
                }
            }
        }
        return 1;
    }
}
