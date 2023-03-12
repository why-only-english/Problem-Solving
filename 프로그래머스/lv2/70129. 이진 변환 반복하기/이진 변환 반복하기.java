class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];    // 배열 크기 2 [cnt, cntZero]

        while (s.length() > 1) {
            
            int cntOne = 0;  // 0이 제거된 1의 개수
            for (int i = 0; i < s.length(); i++) {
                
                if (s.charAt(i) == '0') answer[1] += 1;
                else cntOne += 1;
            }
            
            s = Integer.toBinaryString(cntOne);   // 2진수로 변환
            answer[0] += 1;   // 이진 변환 회차
        }
        
        return answer;
    }
}
