// LeetCode 1480 - Running Sum of 1D Array
// Given an array nums, return the running sum where runningSum[i] = sum(nums[0]...nums[i]).
//
// Example 1: nums = [1,2,3,4]   → [1,3,6,10]
// Example 2: nums = [1,1,1,1,1] → [1,2,3,4,5]
// Example 3: nums = [3,1,2,10,1] → [3,4,6,16,17]
//
// Constraints: 1 <= nums.length <= 1000, -10^6 <= nums[i] <= 10^6

class Solution {

    // Modifies array in-place: each element becomes the prefix sum up to that index.
    // Time: O(n) | Space: O(1)
    public static int[] runningSum(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {3,1,2,10,1};
        int[] result = runningSum(arr);

        System.out.print("Output: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println(); // Output: 1 3 6 10
    }
}
