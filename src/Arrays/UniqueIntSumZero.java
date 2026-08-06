package Arrays;

public class UniqueIntSumZero {

        public int[] sumZero(int n) {

            int sum = 0;
            int []res = new int[n];
            int num = 1;
            if(n%2 != 0){
                for(int i=0;i<=n-2;i+=2){
                    int num1 = num + 1;
                    int num2 = num1 * -1;
                    res[n-1] = 0;
                    res[i] = num1;
                    res[i+1] = num2;
                    num++;
                }
            }
            else{
                for(int i=0;i<n-1;i+=2){
                    int num1 = num + 1;
                    int num2 = num1 * -1;
                    res[i] = num1;
                    res[i+1] = num2;
                    num++;
                }
            }

            return res;
        }

}
