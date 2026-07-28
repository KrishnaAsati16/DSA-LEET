class Solution {
    public int findKthLargest(int[] arr, int k) {
            // minheap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int ele : arr){
            pq.add(ele); // log k
            if(pq.size()>k) pq.remove(); // log k
        }
        return pq.peek();
        }   
}
    