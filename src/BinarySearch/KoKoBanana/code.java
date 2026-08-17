//Leetcode 875 - KoKo Eating Bananas
//Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and
//will come back in h hours.
//
//Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas
//from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
//
//Return the minimum integer k such that she can eat all the bananas within h hours.
//
//
//
//com.example.college.Example 1:
//
//Input: piles = [3,6,7,11], h = 8
//Output: 4
//com.example.college.Example 2:
//
//Input: piles = [30,11,23,4,20], h = 5
//Output: 30

package BinarySearch.KoKoBanana;
public class code {

    public int minEatingSpeed(int[] piles, int h) {
        //here we are applying binary search not search a particular element but to find the min speed per hour for koko to eat the bananas
        // binary search on the possible answer (eating speed).
        // The possible speeds are:

        // 1  2  3  4  5  6  7  8  9  10  11  -> This is sorted!
        int max = piles[0];
        for(int ele : piles){
            if(ele > max)
                max = ele;
        }
        int left = 1; //denoting min possible speed
        int right = max; //denoting max possible speed
        int speed;
        while(left <= right){
            int mid= left + (right - left) / 2; //assuming koko speed
            int hours = 0;
            for(int i=0;i<piles.length;i++){
                hours += Math.ceil((double)piles[i] / mid);
            }
            if(hours <= h){ //mid works but try smaller speed to make koko eat slower if possible
                right = mid - 1;
            }
            else { //koko is eating much slower make her faster
                left = mid + 1;
            }
        }

        return left;
    }
}

//TC analysis :-
//to find the max ele - O(n)
//    Binary search - O(log(maxpilesize))
//Each binary-search step checks all piles: O(n)
//
//So total:
//
//O(n log(maxPile)) time
//O(1) for no auxillary space


