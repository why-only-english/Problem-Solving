// 가로 세로 상관 없이 긴 부분 중에 제일 긴 길이 * 남은 부분 중에 제일 긴 길이
import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int[] llong = new int[sizes.length];
        int[] sshort = new int [sizes.length];
        
        for (int i = 0; i < sizes.length; i++) {
            llong[i] = Math.max(sizes[i][0], sizes[i][1]);
        }
        
        for (int i = 0; i < sizes.length; i++) {
            sshort[i] = Math.min(sizes[i][0], sizes[i][1]);
        }
        
        int max1 = llong[0];
        int max2 = sshort[0];
 
        for (int num : llong) {
            if (num > max1) {
                max1 = num;
            }
        }
        
        for (int num : sshort) {
            if (num > max2) {
                max2 = num;
            }
        }

        // System.out.println(Arrays.toString(llong));
        // System.out.println(Arrays.toString(sshort));
        
        return answer = max1 * max2;
    }
}