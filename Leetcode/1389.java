// Given two arrays of integers nums and index. Your task is to create target array under the following rules:

// Initially target array is empty.
// From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
// Repeat the previous step until there are no elements to read in nums and index.
// Return the target array.

// It is guaranteed that the insertion operations will be valid.

 

// Example 1:

// Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
// Output: [0,4,1,3,2]
// Explanation:
// nums       index     target
// 0            0        [0]
// 1            1        [0,1]
// 2            2        [0,1,2]
// 3            2        [0,1,3,2]
// 4            1        [0,4,1,3,2]

class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[nums.length];
        for(int i=0;i<index.length;i++){
           //need to right shift the elements from index[i] to the end of the array if target[index[i]] is already occupied
           //start from i as i is always >= index[i] and go till index[i] and shift the elements to the right by 1
            for(int j=i;j>index[i];j--){
                    target[j] = target[j-1];
            }
            
            target[index[i]] = nums[i];
        }
        return target;
    }
    public static void main(String[] args) {
       int[] nums = {0,1,2,3,4};
       int[] index = {0,1,2,2,1};
       Solution sol = new Solution();
       int[] result = sol.createTargetArray(nums, index);
       System.out.print("Output: ");
       for (int val : result) {
           System.out.print(val + " ");
       }
       System.out.println();
    }

}

// time complexity -> O(n^2) due to the nested loop for shifting elements, where n is the length of the input arrays. 
// The outer loop iterates through each element of the nums and index arrays, 
// while the inner loop shifts elements to the right when necessary.

// auxillary space -> O(n) due to the creation of the target array, which has the same length as the input arrays.

