/**
 * 2091. Removing Minimum and Maximum From Array
 * https://leetcode.com/problems/removing-minimum-and-maximum-from-array
 * 
 * Given an array of distinct integers, remove the minimum element and the
 * maximum. Each removal can only be made from the start or from the end of
 * the array. Return the minimum number of removals needed.
 * 
 * Insight: only 3 strategies are possible, since removals only happens at
 * the ends. Let leftPos/rightPos be the smaller/larger of the two positions
 * (min's index and max's index, in either order):
 * 1. Remove both from the front: rightPos + 1 removals.
 * 2. Remove both from the back: n - leftPos removals.
 * 3. Remove one from each end: (leftPos + 1) + (n - rightPos) removals.
 * The answer is the minimum of the three.
 * 
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {

	public int minimumDeletions(int[] nums) {
		int minIndex = 0;
		int maxIndex = 0;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[maxIndex])
				maxIndex = i;
			if (nums[i] < nums[minIndex])
				minIndex = i;
		}

		int leftPos = Math.min(minIndex, maxIndex);
		int rightPos = Math.max(minIndex, maxIndex);

		int removeFromBothFront = rightPos + 1;
		int removeFromBothBack = nums.length - leftPos;
		int removeFromBothSides = (leftPos + 1) + (nums.length - rightPos);

		return Math.min(Math.min(removeFromBothSides, removeFromBothFront), removeFromBothBack);
	}
}
