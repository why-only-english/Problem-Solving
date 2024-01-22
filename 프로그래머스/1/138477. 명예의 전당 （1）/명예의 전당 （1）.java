import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        // 발표 점수 결과 담는 배열
        int[] result = new int[score.length];
        
        // 순위 담을 List (rank)
        List<Integer> rank = new ArrayList<>();
        
        for (int i = 0; i < score.length; i++) {
            // rank에 score 추가
            rank.add(score[i]);
            
            // rank 사이즈가 k 넘어가면 최하위 점수 제거
            if (rank.size() > k) {
                rank.remove(Collections.min(rank));
            }
            
            // 최하위 점수 result에 담기
            result[i] = Collections.min(rank);
        }
        
        return result;
    }
}