/*
. Given an integer array nums of length n and an integer target, find three integers at 
distinct indices in nums such that the sum is closest to target. 
Return the sum of the three integers. 
You may assume that each input would have exactly one solution. 
Example 1: 
Input: nums = [-1,2,1,-4], target = 1 
Output: 2 
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2). 
Example 2: 
Input: nums = [0,0,0], target = 1 
Output: 0 
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0). 
Constraints: 
3 <= nums.length <= 500 -1000 <= nums[i] <= 1000 -10^4 <= target <= 10^4 
*/

import java.util.Arrays;

public class ThreeSum {

    public int threeSumCloser(int[] nums, int target) {
        Arrays.sort(nums);
        int minTargetDiff = Integer.MAX_VALUE;
        int reqSum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int val = Math.abs(target - sum);
                if (val < minTargetDiff) {
                    minTargetDiff = val;
                    reqSum = sum;
                }

                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return sum;
                }
            }
        }
        return reqSum;
    }

    public static void main(String[] args) {
        ThreeSum t = new ThreeSum();
        int[] arr = { -1, 2, 1, -4 };
        // int[] arr = { 0,0,0};
        int res = t.threeSumCloser(arr, 1);
        System.out.println(res);
    }
}
