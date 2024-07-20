public class Solution {
    public static int getDivisorCount(int n) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                count++;
                if (i != n / i) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int solution(int number, int limit, int power) {
        int totalWeight = 0;

        for (int i = 1; i <= number; i++) {
            int attackPower = getDivisorCount(i);
            if (attackPower > limit) {
                attackPower = power;
            }
            totalWeight += attackPower;
        }

        return totalWeight;
    }
}
