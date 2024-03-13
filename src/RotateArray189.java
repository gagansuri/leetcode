public class RotateArray189 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] result = new int[nums.length];
        for(int i =  0 ; i<k ; i++) {
            int counter = 0 ;
            for(int j = 0 ; j < nums.length ;j++) {
                int index = (nums.length - 1 + j) % nums.length;
                result[counter++] = nums[index++];
            }

            for(int n = 0 ;n< nums.length ; n++) {
                nums[n] = result[n];
            }
            result = new int[nums.length];
        }
        System.out.println(nums);
    }
    public static void rotate1(int[] nums, int k) {
        int[] result = new int[nums.length];
        for(int i =  0 ; i<k ; i++) {
            int counter = 0 ;
            for(int j = 0 ; j < nums.length ;j++) {
                int index = (nums.length - 1 + j) % nums.length;
                result[counter++] = nums[index++];
            }
            nums = result;
            result = new int[nums.length];
        }
        System.out.println(nums);
    }


}
