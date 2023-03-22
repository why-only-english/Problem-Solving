class Solution {
    public int[] solution(int brown, int yellow) {
        int div1 = 0, div2 = 0;  // 약수 1, 약수 2
        int length = 0, width = 0;  // 가로 > 세로
        
        for(int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {   // 약수 구하기
                div1 = i;     
                div2 = yellow / i;
                // 2(가로+세로+2) == brown 이면 문제 조건 만족
                if ((2*(div1+div2+2)) == brown) {  
                    length = i + 2;
                    width = yellow / i + 2;
                }
            }
        }
        
        int[] answer = {length, width};

        return answer;
    }
}