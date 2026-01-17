class Solution {
    public long maxProduct(int[] nums) {
        int n = nums.length;

        // find top 3 max and bottom 2 min
        long max1 = Long.MIN_VALUE, max2 = Long.MIN_VALUE, max3 = Long.MIN_VALUE;
        long min1 = Long.MAX_VALUE, min2 = Long.MAX_VALUE;

        for (int x : nums) {
            if (x > max1) {
                max3 = max2;
                max2 = max1;
                max1 = x;
            } else if (x > max2) {
                max3 = max2;
                max2 = x;
            } else if (x > max3) {
                max3 = x;
            }

            if (x < min1) {
                min2 = min1;
                min1 = x;
            } else if (x < min2) {
                min2 = x;
            }
        }

        long ans = Long.MIN_VALUE;

        // no replacement
        ans = Math.max(ans, max1 * max2 * max3);
        ans = Math.max(ans, max1 * min1 * min2);

        long P = 100000;

        // replacement with +100000
        ans = Math.max(ans, P * max1 * max2);
        ans = Math.max(ans, P * min1 * min2);

        // replacement with -100000
        ans = Math.max(ans, -P * min1 * max1);
        ans = Math.max(ans, -P * max1 * max2);

        return ans;
    }
}
