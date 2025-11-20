class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        int k = 0, i = 0 , j = 0 ;
        double median = 0 ;
        while(i < nums1.length && j < nums2.length) {
            res[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        }

        while(i < nums1.length) {
            res[k++] = nums1[i++];
        }

        
        while(j < nums2.length) {
            res[k++] = nums2[j++];
        }

        //System.out.println(res + " " + res.length + " by 2 " + res.length/2);
        if(res.length % 2 == 0 ) {
            // even taken length/2 and length / 2 -1 and average them
            //System.out.println(" res[res.length/2] : "+ res[res.length/2] + " res[res.length/2 - 1]: "+ res[res.length/2 - 1]);
            median = (res[res.length/2] + res[res.length/2 - 1] ) / 2.0;
        } else {
            median = res[res.length/2];
        }
        return median;
    }
}