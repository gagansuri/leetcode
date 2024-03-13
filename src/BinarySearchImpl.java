public class BinarySearchImpl {
    public static void main(String[] args) {
        int[] nums = {1,3,5,7,8,9,12};
        /*System.out.println(search(nums,1));
        System.out.println(search(nums,12));
        System.out.println(search(nums,11));
        System.out.println(search(nums,7));*/
        System.out.println(binarySearchRec(0, nums.length - 1, nums , 1));
        System.out.println(binarySearchRec(0, nums.length - 1, nums , 12));
        System.out.println(binarySearchRec(0, nums.length - 1, nums , 11));
        System.out.println(binarySearchRec(0, nums.length - 1, nums , 7));
    }

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    return -1;
    }
    public static int binarySearchRec(int start, int end, int[] nums, int target) {
        int mid = start + (end - start)/2;
        if(start <= end) {
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            return binarySearchRec(start, end, nums, target);
        } else {
            return -1;
        }
    }
}
