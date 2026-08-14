//its a game of choosing the right boundary and condition check accordingly

package BinarySearch.SearchInRotatedSortedArray;

public class code {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left)/2;
            if(target == nums[mid])
                return mid;
            // mid helps us determine which half is sorted.

            // Ex -> 5 6 7 8 9 1 2 3 4
            if(nums[mid] > nums[right]){
                //i.e Left half is sorted, while the rotation/break is in the right half
                if(target < nums[mid] && target >= nums[left]){
                    //search in the LHS of mid
                    right = mid - 1;
                }
                else{
                    //search in the RHS of mid
                    left = mid + 1;
                }
            }
            else{ //Right half is sorted, rotation/break is in the left half
                //i.e RHS of mid has ele > nums[mid]
                if(target > nums[mid] && target <= nums[right]){
                    //search in the RHS ie the sorted part
                    left = mid + 1;
                }
                else{
                    //search in the LHS i.e the rotated half
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
