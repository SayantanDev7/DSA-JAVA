package Arrays;
import java.util.Scanner;
public class ReverseArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        System.out.print("Enter the elements of the array: ");
        int[] arr = new int[n]; 
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.print("The Original array is:\n ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // //Naive Approach -> creeating another temporary array of same and storing the reverse version and then copying it back to original array
        // //TC -> O(n) Auxillary space->O(n)

        // int[] temp = new int[n];
        // //storing the reverse of arr in temp
        // for(int i=0;i<n;i++){
        //     temp[i]=arr[n-i-1];
        // }
        // // Copying the reversed elements back to the original array
        // for(int i=0;i<n;i++){
        //     arr[i] = temp[i];
        // }

        //Optimized Approach -> Swapping the elements from start and end of the array
        //Reversing the array in place
        //TC -> O(n) Auxillary space->O(1)

        for(int i=0;i<n/2;i++){
            int temp = arr[n-i-1];
            arr[n-i-1] = arr[i];
            arr[i] = temp;
        }

        System.out.print("The Reversed array is:\n ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        


        sc.close();
    }
}
