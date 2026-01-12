class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] present = new boolean[26];

        
        for (char c : allowed.toCharArray()) {
            present[c - 'a'] = true;
        }

        int count = 0;

        for (String word : words) {
            boolean isConsistent = true;

            for (char c : word.toCharArray()) {
                if (!present[c - 'a']) {
                    isConsistent = false;
                    break;
                }
            }

            if (isConsistent) {
                count++;
            }
        }
        return count;
    }
}
