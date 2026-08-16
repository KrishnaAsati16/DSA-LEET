class Solution {
    public int[][] transpose(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;

        int[][] trans = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                trans[j][i] = arr[i][j];
            }
        }
        return trans;
    }
}
