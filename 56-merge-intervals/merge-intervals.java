class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // Step 1: sort intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            // overlapping
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                // no overlap
                result.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        // add last interval
        result.add(new int[]{start, end});

        return result.toArray(new int[result.size()][]);
    }
}
