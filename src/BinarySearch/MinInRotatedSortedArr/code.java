package BinarySearch.MinInRotatedSortedArr;

public class code {

    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[right]){ // i.e right half is rotated and left half is sorted
                //since min is on the right half i.e go to right half
                left = mid + 1;
            }
            else{
                //right half is sorted and left half is rotated
                //since min is on the left half it can be mid itself also
                right = mid;
            }
        }
        return nums[left];
    }
}

// // You never searched through the elements.

/// / You simply kept narrowing the possible location of the minimum
