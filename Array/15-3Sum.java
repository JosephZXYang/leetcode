/**

Key points:

1. First, sort the array.
2. Loop over the array, but in order to avoid duplicates,
add a condition.
3. Since the array is sorted, in each iteration of the outer 
loop, we could do 2Sum by bi-direction loop of remaining subarray.

*/

import java.util.*;

class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
				int sm = i+1, lg = nums.length - 1, target = -nums[i];
				while (sm < lg) {
					if (nums[sm] + nums[lg] == target) {
						result.add(Arrays.asList(nums[i], nums[sm], nums[lg]));
						while (sm < lg && nums[sm] == nums[sm + 1]) {
							sm ++;
						}
						while (sm < lg && nums[lg] == nums[lg - 1]) {
							lg --;
						}
						sm ++; lg --;
					}
					else if (nums[sm] + nums[lg] < target) {
						sm ++;
					}
					else {
						lg --;
					}
				}
			}
		}
		return result;
	}
}