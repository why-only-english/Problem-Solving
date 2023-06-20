class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        // 첫 글자는 무조건 -1
        answer[0] = -1;
        
        for (int i = 1; i < s.length(); i++) {
            int idx = s.substring(0,i).lastIndexOf(s.charAt(i));
            
            if (idx != -1) {
                answer[i] = i - idx;
            }
            else {
                answer[i] = idx;
            }
        }
        
        // System.out.println(s.lastIndexOf("n"));
        return answer;
    }
}