import java.util.ArrayList;
import java.util.Collections;

public class ArrayFormInteger {

    public static void main(String[] args) {

        int[] num = {1, 2,1, 0};
        int k = 34;

        ArrayList<Integer> ans = addToArrayForm(num, k); //Auxillary space taking SC: O(N)

        System.out.println(ans);
    }

    public static ArrayList<Integer> addToArrayForm(int[] num, int k) {

        ArrayList<Integer> ans = new ArrayList<>();

        int i = num.length - 1;
        int carry = 0;

        while (i >= 0 || k > 0 || carry > 0) {

            int dig1 = (k > 0) ? k % 10 : 0;
            int dig2 = (i >= 0) ? num[i] : 0;

            int sum = dig1 + dig2 + carry;

            carry = sum / 10;

            ans.add(sum % 10);

            i--;
            k /= 10;
        }

        Collections.reverse(ans); //Reverse = O(n)

        return ans;
    }
}

//The loop runs until you've processed
//
//every digit of num
//every digit of k
//        so number of iterations :-
//max(
//        num.length,
//        number of digits in k
//)
//    TC is O(max(n,digits(k)))