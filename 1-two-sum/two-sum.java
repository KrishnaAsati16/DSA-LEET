// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         int[] arr = new int[2];

//         for (int i = 0; i < nums.length; i++) {
//             for (int j = i + 1; j < nums.length; j++) {
//                 if (nums[i] + nums[j] == target) {
//                     arr[0] = i;
//                     arr[1] = j;
//                     return arr;   
//                 }
//             }
//         }
//         return arr;
//     }
// }
// class Solution{
//  boolean twoSum(int arr[], int target) {
//         HashSet<Integer> set = new HashSet<>();
//         for(int ele : arr){
//             int rem = target-ele;
//             if(set.contains(rem)) return true;
//             set.add(ele);
//         }
//         return false;
//     }
// }

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int rem = target - nums[i];
            if(map.containsKey(rem)) 
                return new int[]{map.get(rem), i};
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}

    