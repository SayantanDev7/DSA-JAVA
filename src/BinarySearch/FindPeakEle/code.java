package BinarySearch.FindPeakEle;
//Leetcode 162

//A peak element is an element that is strictly greater than its neighbors.
//
//Given a 0-indexed integer array nums, find a peak element, and return its index.
//If the array contains multiple peaks, return the index to any of the peaks.
//
//You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor
//that is outside the array.
//
//You must write an algorithm that runs in O(log n) time.
//
//com.example.college.Example 1:
//
//Input: nums = [1,2,3,1]
//Output: 2
//Explanation: 3 is a peak element and your function should return the index number 2.

public class code {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0,right = n - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            //case 1:RHS bigger
            if(nums[mid + 1] > nums[mid]){
                left = mid + 1;
            }
            //search LHS
            else{
                right = mid;
            }
        }

        return left;
    }
}
