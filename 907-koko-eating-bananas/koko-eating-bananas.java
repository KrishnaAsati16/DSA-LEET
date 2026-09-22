class Solution {
    public int minEatingSpeed(int[] arr, int k) {
        int max = Integer.MIN_VALUE;

        for (int ele : arr) {
            max = Math.max(max, ele);
        }

        int lo = 1;
        int hi = max;
        int speed = max;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (hours(mid, arr) <= k) {
                speed = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return speed;
    }

    private long hours(int speed, int[] arr) {
        long h = 0;

        for (int ele : arr) {
            h += (ele + speed - 1) / speed;
        }

        return h;
    }
}