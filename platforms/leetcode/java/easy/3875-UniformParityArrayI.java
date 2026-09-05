/**
 * 3875. Construct Uniform Parity Array I
 * https://leetcode.com/problems/construct-uniform-parity-array-i/
 * 
 * Insight: the answer is always true. If the array is already uniform, use
 * nums2[i] = nums1[i] for every index. If it's mixed, build nums2 as all-odd:
 * keep the odd values as-is, and for each value, subtract any odd value that
 * exists in the array (even - odd = odd). Since the array is mixed, there's
 * always at least one odd value available.
 * 
 * Time complexity: O(1)
 * Space complexity: O(1)
 */
class Solution {
    public boolean uniformArray(int[] nums1) {
        return true;
    }
}

/**
 * First approach (brute-force): for each index, simulates whether it's
 * possible to make it even/odd by searching for a partner elsewhere in the
 * array. Works, but redundant... only after implementing this did I realize
 * the answer is always true (see Solution above).
 * 
 * Time complexity: O(n²)
 * Space complexity: O(1)
 */
class SolutionBruteForce {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        boolean isPossibleEven = true;
        boolean isPossibleOdd = true;

        for (int i = 0; i < n; i++) {
            boolean thisIndexEven = nums1[i] % 2 == 0;
            if (!thisIndexEven) {
                for (int j = 0; j < n; j++) {
                    if (i != j && (nums1[i] - nums1[j]) % 2 == 0) {
                        thisIndexEven = true;
                        break;
                    }
                }
            }
            isPossibleEven = isPossibleEven && thisIndexEven;

            boolean thisIndexOdd = nums1[i] % 2 != 0;
            if (!thisIndexOdd) {
                for (int j = 0; j < n; j++) {
                    if (i != j && (nums1[i] - nums1[j]) % 2 != 0) {
                        thisIndexOdd = true;
                        break;
                    }
                }
            }
            isPossibleOdd = isPossibleOdd && thisIndexOdd;
        }
        return isPossibleEven || isPossibleOdd;
    }
}