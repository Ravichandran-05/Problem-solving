/**
 
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'

 */

class Solution {
    public boolean isValid(String str) {
        if(str == null)
            return false;
        Stack<Character> s = new Stack<>();
        int i;
        for(i=0;i<str.length();i++)
        {
            if(str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) =='[')
            {
                s.push(str.charAt(i));
            }
            else if(!s.isEmpty() && str.charAt(i) == ')' && s.peek() == '(')
                {
                    s.pop();
                }
            
            else if(!s.isEmpty() && str.charAt(i) == '}' && s.peek() == '{')
                {
                    s.pop();
                }
            
            else if(!s.isEmpty() && str.charAt(i) == ']' && s.peek() == '[')
                {
                    s.pop();
                }
            
            else
            {
                return false;
            }
        }
        return s.isEmpty();
    }
}