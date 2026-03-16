/*
Given an integer array nums and an integer k, return the kth largest element in the array. 
Note that it is the kth largest element in the sorted order, not the kth distinct element. Can you solve it without sorting? 

Example 1: 
Input: 
nums = [3,2,1,5,6,4], k = 2 
Output: 5 

Example 2: 
Input: 
nums = [3,2,3,1,2,4,5,5,6], k = 4 
Output: 4 

Constraints: 
 1 <= k <= nums.length <= 10^5 
 -10^4 <= nums[i] <= 10^4
*/

import java.util.ArrayList;

public class KthLargestInAnArray {
    int solve(ArrayList<Integer> nums, int k) {

        int largest = Integer.MIN_VALUE;
        int count = 0;
        for (int j = 0; j < k; j++) {
            int index = -1;
            for (int i = 0; i < nums.size(); i++) {
                int val = nums.get(i);
                if (val > largest) {
                    largest = val;
                    index = i;
                }
            }
            count++;
            if (count == k) {
                return largest;
            }
            nums.remove(index);
            largest = Integer.MIN_VALUE;
        }
        return 0;
    }

    public static void main(String[] args) {
        KthLargestInAnArray k = new KthLargestInAnArray();
        ArrayList<Integer> nums1 = new ArrayList<>();
        nums1.add(3);
        nums1.add(2);
        nums1.add(1);
        nums1.add(5);
        nums1.add(6);
        nums1.add(4);
        int k1 = 2;
        System.out.println("Case 1 result: " + k.solve(nums1, k1));

        ArrayList<Integer> nums2 = new ArrayList<>();
        nums2.add(3);
        nums2.add(2);
        nums2.add(3);
        nums2.add(1);
        nums2.add(2);
        nums2.add(4);
        nums2.add(5);
        nums2.add(5);
        nums2.add(6);
        int k2 = 4;
        System.out.println("Case 2 result: " + k.solve(nums2, k2));
    }
}
