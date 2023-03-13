class Solution {
    public String solution(String s) {
        String answer = "";
        String[] temp = s.split("");
        System.out.println(temp[0]);  // t      
        
        int idx = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i].equals(" ")) {
                idx = 0; // 인덱스 초기화
            }
            else if (idx % 2 == 0) {   // 짝수
                temp[i] = temp[i].toUpperCase();  // 대문자
                idx += 1;
            }
            else if (idx % 2 != 0) {   // 홀수
                temp[i] = temp[i].toLowerCase();  // 소문자
                idx += 1;
            }
            answer += temp[i];
        }
        return answer;
    }
}