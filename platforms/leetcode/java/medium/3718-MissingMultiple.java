import java.util.HashSet;

/**
 * 3718. Smallest Missing Multiple of K
 * https://leetcode.com/problems/smallest-missing-multiple-of-k/
 * 
 * Given an integer array nums and an integer k, return the smallest positive
 * multiple of k that is missing from nums.
 * 
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> numsSet = new HashSet<>();
        for (int n : nums) numsSet.add(n);

        int m = k;
        while (numsSet.contains(m)) {
            m+=k;
        }

        return m;
    }
}
