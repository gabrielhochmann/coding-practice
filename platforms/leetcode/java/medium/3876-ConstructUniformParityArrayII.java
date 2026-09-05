/**
 * 3876. Construct Uniform Parity Array II
 * https://leetcode.com/problems/construct-uniform-parity-array-ii/
 * 
 * Insight: if nums1 alredy has a single parity, it's trivially true.
 * Otherwise, targeting all-odd is the only viable strategy (targeting
 * all-even would require the smallest odd value itself to convert, wichi is
 * impossible... there's no smaller odd to subtract from it). For all-odd,
 * every even value x needs some odd value less than x to subtract
 * (even - odd = odd, and the problem requires the result to be >= 1). It's
 * enough to compare the smallest even against the smallest odd: if the
 * smallest odd is less than the smallest even, every even value has a valid
 * odd to subtract; otherwise it's impossible.
 * 
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {
    public boolean uniformArray(int[] nums1) {
        int minOdd = Integer.MAX_VALUE;
        int minEven = Integer.MAX_VALUE;

        for (int x : nums1) {
            if (x % 2 != 0) {
                minOdd = Math.min(minOdd, x);
            } else {
                minEven = Math.min(minEven, x);
            }
        }

        return minOdd == Integer.MAX_VALUE || minEven > minOdd;
    }
}