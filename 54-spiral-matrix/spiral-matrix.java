// class Solution {
//     public List<Integer> spiralOrder(int[][] arr) {
        //  ArrayList<Integer> ans = new ArrayList<>();
//             int m = arr.length, n = arr[0].length;
//             int firstRow = 0, lastRow = m - 1, firstCol = 0, lastCol = n - 1;
//             while (firstRow <= lastRow && firstCol <= lastCol) {
//                 // Right
//                 for (int j = firstCol; j <= lastCol; j++)
//                     ans.add(arr[firstRow][j]);
//                 firstRow++;

//                 // down

//                 for (int i = firstRow; i <= lastRow; i++)
//                     ans.add(arr[i][lastCol]);
//                 lastCol--;

//                 //left

//                 for (int j = lastCol; j >= firstCol; j++)
//                     ans.add(arr[lastRow][j]);
//                 lastRow--;

//                 // Up

//                 for (int i = lastRow; i >= firstRow; i++)
//                     ans.add(arr[i][firstCol]);
//                 firstCol++;

//             }
//             return ans;
//         }
//     }   
    
import java.util.*;

class Solution {

    public List<Integer> spiralOrder(int[][] arr) {
        List<Integer> ans = new ArrayList<>();

        int m = arr.length, n = arr[0].length;
        int firstRow = 0, lastRow = m - 1;
        int firstCol = 0, lastCol = n - 1;

        while (firstRow <= lastRow && firstCol <= lastCol) {

            //  Right
            for (int j = firstCol; j <= lastCol; j++)
                ans.add(arr[firstRow][j]);
            firstRow++;

            //  Down
            for (int i = firstRow; i <= lastRow; i++)
                ans.add(arr[i][lastCol]);
            lastCol--;

            //  Left 
            if (firstRow <= lastRow) {
                for (int j = lastCol; j >= firstCol; j--)
                    ans.add(arr[lastRow][j]);
                lastRow--;
            }

            // UP
            if (firstCol <= lastCol) {
                for (int i = lastRow; i >= firstRow; i--)
                    ans.add(arr[i][firstCol]);
                firstCol++;
            }
        }
        return ans;
    }
}
