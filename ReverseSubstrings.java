import java.util.Stack;

public class ReverseSubstrings {
    
    public static String reverseParentheses(String s) {
        // Stack to hold the characters during traversal
        Stack<Character> stack = new Stack<>();
        
        // Traverse the string
        for (char c : s.toCharArray()) {
            if (c == ')') {
                // Reached a closing parenthesis, start popping till we find '('
                StringBuilder sb = new StringBuilder();
                while (stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop(); // Remove the opening parenthesis '('
                
                // Push the reversed string back into the stack
                for (char ch : sb.toString().toCharArray()) {
                    stack.push(ch);
                }
            } else {
                // Push the current character into the stack
                stack.push(c);
            }
        }
        
        // Build the result string from the stack
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        
        // Since we built the string in reverse order, we need to reverse it back
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        // Test the function with different inputs
        System.out.println(reverseParentheses("abd(jnb)asdf")); 
        System.out.println(reverseParentheses("abdjnbasdf")); 
        System.out.println(reverseParentheses("dd(df)a(ghhh)")); 
    }
}

