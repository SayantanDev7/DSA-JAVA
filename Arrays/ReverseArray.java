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

        // Reversing the array in-place
        //Naive Approach -> creeating another temporary array of same and storing the reverse version and then copying it back to original array

        int[] temp = new int[n];
        //storing the reverse of arr in temp
        for(int i=0;i<n;i++){
            temp[i]=arr[n-i-1];
        }
        // Copying the reversed elements back to the original array
        for(int i=0;i<n;i++){
            arr[i] = temp[i];
        }

        System.out.print("The Reversed array is:\n ");
        for(int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        


        sc.close();
    }
}
