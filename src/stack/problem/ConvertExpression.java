package stack.problem;

import stack.Stack;

public class ConvertExpression {
    public static void main(String[] args) {
        String expression = "1+2*3";
        // StringBuilder result = infixToPostfix(expression);
        // System.out.println(result);
    }

    // public static StringBuilder infixToPostfix(String a){
    //     StringBuilder ans = new StringBuilder();

    //     Stack<Character> stack = new Stack<>();
    //     int i = 0;
    //     int n = a.length();
    //     while(i<n){
    //         char ch = a.charAt(i);
    //         // if it is operand add it ans
    //         if(isOperand(ch)){
    //             ans.append(ch);
    //         }

    //         else if(ch=='('){
    //             stack.push('(');
    //         }
    //         else if(ch==')'){
    //             while (!stack.isEmpty() && stack.peek() != '(') {
    //                 ans.append(stack.pop());
    //             }
    //             if (!stack.isEmpty() && stack.peek() == '(') {
    //                 stack.pop(); // Remove '('
    //             } else {

    //                 return new StringBuilder().append("InvalidExpression"); 
    //             }
    //         }
    //         else{
    //             while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
    //                 if (ch == '^' && stack.peek() == '^') {
    //                     break; // right-associative operator
    //                 } else {
    //                     ans.append(stack.pop());
    //                 }
    //             }
    //             stack.push(ch);
    //         }
    //         i++;
    //     }
    //     return ans;
    // }

    // private static boolean isOperand(char ch) {
    //     return Character.isLetterOrDigit(ch);
    // }

    // private static int precedence(char ch) {
    //     switch (ch) {
    //         case '()':
    //         case '-': return 1;
    //         case '*':
    //         case '/': return 2;
    //         case '^': return 3;
    //     }
    //     return -1; // for non-operators
    // }
}
