//   class Solution {
//         public int leastWeightCapacity(int[] arr, int n, int d) {
//             int max = Integer.MIN_VALUE, sum =0;
//             for(int ele: arr){
//               max = Math.max(max,ele);
//               sum+= ele;
//             }
//                     int lo = max, hi= sum , ans = sum;
//             while(lo<=hi){
//            int mid = lo +(hi-lo)/2;
//            if(days(mid.arr)<=d) {
//                hi = mid ;
//                ans = mid;
//            }
//            else lo = mid;
//             }
//                   return ans;
//         }
//         // 1 2 3 4  5 6 7 8 9  10
//         private static  int days (int capacity, int []arr){
//             int days = 0; int c = capacity ;
//             for(int ele: arr){
//                 if(c>=ele) c-= ele;
//                 else{
//                     days++;
//                     c = capacity - ele;
//                 }
//             }
//             days++;
//             return days ;
//         }
//     }


//-----------------------driver issue ----------------------------------
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int ele : weights) {
            max = Math.max(max, ele);
            sum += ele;
        }

        int lo = max, hi = sum, ans = sum;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (countDays(mid, weights) <= days) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    private int countDays(int capacity, int[] weights) {
        int count = 0;
        int c = capacity;
        for (int ele : weights) {
            if (c >= ele) c -= ele;
            else {
                count++;
                c = capacity - ele;
            }
        }
        count++;
        return count;
    }
}