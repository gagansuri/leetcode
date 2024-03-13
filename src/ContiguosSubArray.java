public class ContiguosSubArray {
    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 6, 2};
        System.out.println(countSubarrays(arr));
    }

    static  int[] countSubarrays(int[] arr) {
        int[] result = new int[arr.length];
        for(int i = 0 ;i<arr.length;i++) {
            int leftCount = 0 ;
            int rightCount = 0 ;
            for(int j = i-1; j>=0;j--) {
                if(arr[i] > arr[j]) {
                    leftCount++;
                } else {
                    break;
                }

            }

            for(int j = i+1; j< arr.length;j++) {
                if(arr[i] > arr[j]) {
                    rightCount++;
                } else {
                    break;
                }

            }

            result[i] = leftCount + rightCount + 1;

        }
        return result;


    }
}
