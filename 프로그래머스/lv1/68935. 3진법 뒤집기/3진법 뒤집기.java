import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        String temp = "";   // 앞뒤 반전(3진법) 저장할 공간
        
        while (n != 0) {
            temp += n % 3;
            n = n / 3;
        }
        System.out.println(temp);
        
        answer = Integer.parseInt(temp, 3);   // 3진법 변환
        return answer;
    }
}