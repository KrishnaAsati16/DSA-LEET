class Solution {
    public int maxSubArray(int[] arr) {
           int sum = 0, maxSum = Integer.MIN_VALUE;

        for (int ele : arr) {
            sum += ele;
            maxSum = Math.max(maxSum, sum);

            if (sum < 0)
                sum = 0;
        }
        return maxSum;
    }

    public static void main(String[] args) {
         Solution obj = new Solution();

        int[] arr = {2, 3, -8, 7, -1, 2, 3};
         int result = obj.maxSubArray(arr);

        System.out.println("Maximum Subarray Sum = " + result);
    }
    }
