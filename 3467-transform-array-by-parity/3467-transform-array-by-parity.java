class Solution {
    public int[] transformArray(int[] nums) {

        int n = nums.length;
        int evenCount = 0;

        
        for (int num : nums) {
            if (num % 2 == 0) {
                evenCount++;
            }
        }

        int[] result = new int[n];

       
        for (int i = 0; i < evenCount; i++) {
            result[i] = 0;
        }

        
        for (int i = evenCount; i < n; i++) {
            result[i] = 1;
        }

        return result;
    }
}
