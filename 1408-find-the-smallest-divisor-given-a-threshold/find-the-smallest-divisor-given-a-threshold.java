class Solution {
    public int smallestDivisor(int[] nums, int threshold) {

        // Step 1: array ka maximum nikalo
        int maxVal = 0;
        for (int num : nums) {
            if (num > maxVal) maxVal = num;
        }

        // Step 2: divisor ki range set karo
        int left = 1;          // sabse chhota divisor
        int right = maxVal;    // sabse bada divisor (ye hamesha valid hai)
        int answer = maxVal;

        // Step 3: binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (sumWithDivisor(nums, mid) <= threshold) {
                // mid valid hai, ise save karo aur chhota try karo
                answer = mid;
                right = mid - 1;
            } else {
                // sum bahut bada hai, divisor badhao
                left = mid + 1;
            }
        }

        return answer;
    }

    // Har element ko divisor se divide karke ceil ka sum return karta hai
    private long sumWithDivisor(int[] nums, int divisor) {
        long total = 0;
        for (int num : nums) {
            total += (num + divisor - 1) / divisor;   // ceil(num / divisor)
        }
        return total;
    }
}