import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        ArrayList<String> list = new ArrayList<>();
        
        for (int i = 0; i < words.length; i++) {
            // 중복 제거
            if (list.contains(words[i])) {
                // 사람 번호
                answer[0] = (i % n) + 1;
                // 차례
                answer[1] = (i / n) + 1;
                break;
            }
            
            list.add(words[i]);
            
            // 마지막 문자 != 시작 문자
            if (i > 0 && words[i].charAt(0) != words[i-1].charAt(words[i-1].length()-1)) {
                // 사람 번호
                answer[0] = (i % n) + 1;
                // 차례
                answer[1] = (i / n) + 1;
                break;
            }
        }
        return answer;
    }
}