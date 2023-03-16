class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        char[] ch = s.toCharArray();  // 문자열 -> char 배열로 변환
        
        for(char c : ch) {
            if(c == 32) answer += " ";   // 공백일때 그대로
            else {
                if(c <= 90) {
                    c += n;   // n만큼 밀기
                    if(c > 90) c -= 26;  // 대문자 안에서 반복
                } else {
                    c += n;  // n만큼 밀기
                    if(c > 122) c -= 26; // 소문자 안에서 반복
                }
                answer += c;
            }
        }
        
        return answer;
    }
}