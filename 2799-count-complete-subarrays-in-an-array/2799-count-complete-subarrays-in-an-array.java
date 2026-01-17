import java.util.*;

class Solution {
    public int countCompleteSubarrays(int[] nums) {

        // total distinct elements in the whole array
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }
        int totalDistinct = set.size();

        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

            // shrink window while it is complete
            while (freq.size() == totalDistinct) {
                count += nums.length - right;

                freq.put(nums[left], freq.get(nums[left]) - 1);
                if (freq.get(nums[left]) == 0) {
                    freq.remove(nums[left]);
                }
                left++;
            }
        }
        return count;
    }
}
