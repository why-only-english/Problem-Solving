import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        Stack<Character> stack = new Stack<>();
        
        // 문자 제거하기
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 채워져있고 중복이면 pop
            if(!stack.empty() && stack.peek() == c) { 
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        // answer = (stack.size() == 0) ? 1 : 0;
        answer = stack.empty() ? 1 : 0;
        
        return answer;
    }
}