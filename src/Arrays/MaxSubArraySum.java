package Arrays;

public class MaxSubArraySum {

    public int findMaxSubArraySum(int arr[]){
        //using naive apporoach i.e using nested for loop 
        // to iterate over all possible subarrays and find the maximum sum
        // Tc : O(n^2) where n is the number of elements in the array, as we are using nested loops to iterate over all possible subarrays.
        int maxsum = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            int sum = 0;
            for(int j=i;j<arr.length;j++){
                sum += arr[j];
                if(sum > maxsum){
                    maxsum = sum;
                }
            }
        }
        return maxsum; 
    }

    
    public static void main(String[] args) {

        int[] arr = {2, 3, -8, 7, -1, 2, 3};
        MaxSubArraySum obj = new MaxSubArraySum();
        int maxSum = obj.findMaxSubArraySum(arr);
        System.out.println("Maximum Subarray Sum: " + maxSum);
    }
}
