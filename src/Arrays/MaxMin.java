// Given an array of integers arr[], 
// the task is to find the maximum and minimum elements in the array using the minimum number of comparisons.

// Example:
// Input: arr[] = [3, 5, 4, 1, 9]
// Output: [1, 9]
// Explanation: The minimum element is 1, and the maximum element is 9.

// Input: arr[] = [22, 14, 8, 17, 35, 3]
// Output: [3, 35] 
// Explanation: The minimum element is 3, and the maximum element is 35.
package Arrays;
public class MaxMin{
    public int[] FindMaxMin(int arr[]){

        // /Naive approach: Iterate through the array and keep track of the maximum and minimum elements found so far.
        // // Initialize max and min with the first element of the array
        // Tc : O(n) where n is the number of elements in the array, as we are iterating through the array once to find the maximum and minimum elements.
        // // Sc : O(1) as we are using a constant amount of extra space
        int max = arr[0];
        int min = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
            else if(arr[i]<min){
                min = arr[i];
            }
        }
        //storing the masx and min in an array and returning it
        int[] result = new int[2]; //it takes O(1) space as we are using a constant amount of extra space
        result[0] = min;
        result[1] = max;
        return result;
    }
    
    public static void main(String[] args){
        MaxMin obj = new MaxMin();
        int arr[] = {3, 5, 4, 1, 9};
        int[] result = obj.FindMaxMin(arr);
        System.out.println("Minimum element: " + result[0]);
        System.out.println("Maximum element: " + result[1]);
    }


}

//to make it more optimzed we have to use pairwise comparison method which will reduce the number of comparisons to 3n/2 - 2 for n elements in the array.