class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st= new Stack<>();
        for(int i: asteroids){
            if(i>0){
                st.push(i);
            } 
            else{
                while(!st.isEmpty() && st.peek()<-i && st.peek()>0 ){
                    st.pop();
                }            
                if(!st.isEmpty() && st.peek()==-i){
                    st.pop();
                    continue;
                }
                if((!st.isEmpty() && st.peek()<-i) || st.isEmpty()) st.push(i);
            }
            
        }
        int[] ans= new int[st.size()];
        for(int i=st.size()-1; i>=0; i--){
            ans[i]= st.pop();
        }
        return ans;
    }
}