package dificuldade.Medium;

/**
 * 2091. Removing Minimum and Maximum From Array
 * https://leetcode.com/problems/removing-minimum-and-maximum-from-array
 * 
 * Given an array of distinct integers, remove the minimum element and the maximum.
 * Each removal can only be made from the start or from the end of the array.
 * Return the minimum number of removals needed.
 * 
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class MinimumDeletions2091 {

	public int minimumDeletions(int[] nums) {

		int minIndex = 0;
		int maxIndex = 0;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[maxIndex])
				maxIndex = i;
			if (nums[i] < nums[minIndex])
				minIndex = i;
		}

		if (minIndex > maxIndex) {
			int c = minIndex;

			minIndex = maxIndex;
			maxIndex = c;
		}

		int removeFromBothEnds = (minIndex + 1) + (nums.length - maxIndex);
		int removeFromStart = maxIndex + 1;
		int removeFromEnd = nums.length - minIndex;

		return Math.min(Math.min(removeFromBothEnds, removeFromStart), removeFromEnd);
	}
}
