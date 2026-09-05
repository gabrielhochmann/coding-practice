import java.util.HashSet;

/**
 * 3718. Smallest Missing Multiple of K
 * https://leetcode.com/problems/smallest-missing-multiple-of-k/
 * 
 * Given an integer array nums and an integer k, return the smallest
 * positive multiple of k that is missing from nums.
 * 
 * Insight: nums has only n elements, so at most n of them can be
 * multiples of k. That means the (n+1)-th multiple (k, 2k, 3k, ...)
 * is guaranteed to be missing, which bounds the while to at most n+1
 * iterations (it can't run forever).
 * 
 * Time complexity: O(n) - O(n) to build the set, O(n) worst case for
 * while loop.
 * Space complexity: O(n), for the HashSet.
 */
class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> numsSet = new HashSet<>();
        for (int x : nums)
            numsSet.add(x);

        int m = k;
        while (numsSet.contains(m)) {
            m += k;
        }

        return m;
    }
}
