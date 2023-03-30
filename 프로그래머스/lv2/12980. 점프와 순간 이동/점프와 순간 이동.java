// 예1) 5 -> 4 -> 2 -> 1
// 예2) 6 -> 5 -> 4 -> 1 
// ((4 -> 1) 되는 과정은 (4 -> 2 -> 1)이랑 같음 == 순간이동)

public class Solution {
    public int solution(int n) {
        int ans = 0;
        
        while (n != 0) {
            if (n % 2 == 0) {
                n /= 2;  // 짝수일때는 같은 방법(순간이동) 진행되므로 ans++ 없음
            } else {
                n --;
                ans++;
                
            }
        }
        // System.out.println("Hello Java");

        return ans;
    }
}