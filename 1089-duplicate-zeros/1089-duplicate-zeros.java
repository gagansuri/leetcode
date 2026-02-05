class Solution {
    public void duplicateZeros(int[] arr) {
        int[] out = new int[arr.length];
        for(int i = 0 , j = 0 ; j < arr.length;i++) {
            if(arr[i] != 0 ) {
                out[j++] = arr[i];
            } else {
                out[j++] = 0;
                if(j < arr.length)
                    out[j++] = 0;
            }
        }

        for(int i = 0 ; i < arr.length; i++) {
            arr[i] = out[i];
        }
    }
}