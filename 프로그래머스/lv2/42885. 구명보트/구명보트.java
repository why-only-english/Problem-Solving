import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);   // 정렬
        
        int min = 0;   // 최솟값 == 0번째 인덱스
        
        for(int max = people.length - 1; max >= min; max--) {
            if(people[min] + people[max] <= limit) {
                min ++;
            }
            answer ++;
        }
        
        return answer;
    }
}