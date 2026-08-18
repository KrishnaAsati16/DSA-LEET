
// public class RemoveAdjacentDuplicates {
//     static String removeDuplicates(String s) {
//         Stack<Character> st = new Stack<>();
//         for (int i = 0; i < s.length(); i++) {

//             char ch = s.charAt(i);

//             // If stack not empty and top == current char → pop
//             if (!st.isEmpty() && st.peek() == ch) {
//                 st.pop();
//             }
//             // Else push
//             else {
//                 st.push(ch);
//             }
//         }

//         // Build result string
//         StringBuilder result = new StringBuilder();

//         for (char c : st) {
//             result.append(c);
//         }

//         return result.toString();
//     }


// }


class Solution {
    public String removeDuplicates(String s) {
        StringBuilder stack = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (stack.length() > 0 && stack.charAt(stack.length() - 1) == c) {
                stack.deleteCharAt(stack.length() - 1);
            } else {
                stack.append(c);
            }
        }
        return stack.toString();
    }
}