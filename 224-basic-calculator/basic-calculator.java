class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        int result = 0;
        int number = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Build number
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            }

            // Plus
            else if (ch == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            }

            // Minus
            else if (ch == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            }

            // Opening bracket
            else if (ch == '(') {
                stack.push(result);
                stack.push(sign);

                result = 0;
                sign = 1;
            }

            // Closing bracket
            else if (ch == ')') {
                result += sign * number;
                number = 0;

                int prevSign = stack.pop();
                int prevResult = stack.pop();

                result = prevResult + prevSign * result;
            }
        }

        // Add last number
        result += sign * number;

        return result;
    }
}