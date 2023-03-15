class Solution {
    public int solution(int n) {
        int answer = 0;
        int cntOne = 0; // 2진수 변환했을 때 1의 개수
        String twoChange = Integer.toBinaryString(n); // 2진수 변환
        
        for (int i = 0; i < twoChange.length(); i++) {
            if (twoChange.charAt(i) == '1') cntOne++;
        }
        
        for (int i = n + 1; ; i++) {
            String temp = Integer.toBinaryString(i); // 다음 큰 숫자 2진수 변환
            int cntOneNext = 0; // 다음 큰 숫자 2진수 변환했을 때 1의 개수
            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == '1') cntOneNext++;
            }
            
            if(cntOneNext == cntOne) {
                answer = i;
                break;
            }
        }
                
        return answer;
    }
}