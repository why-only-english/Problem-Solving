import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        ArrayList<String> c1List = new ArrayList<>(Arrays.asList(cards1));
        ArrayList<String> c2List = new ArrayList<>(Arrays.asList(cards2));
        
        // for (int i = 0; i < goal.length; i++) {
        //     // get과 remove 차이 이용
        //     if (c1List.size() > 0 && goal[i].equals(c1List.get(0))) {
        //         c1List.remove(0);
        //     } else if (c2List.size() > 0 && goal[i].equals(c2List.get(0))) {
        //         c2List.remove(0);
        //     } else {
        //         return "No";
        //     }
        // }
        
        for (int i = 0; i < goal.length; i++) {
            // get과 remove 차이 이용
            if (c1List.size() > 0 && c1List.get(0).equals(goal[i])) {
                c1List.remove(0);
            } else if (c2List.size() > 0 && c2List.get(0).equals(goal[i])) {
                c2List.remove(0);
            } else {
                return "No";
            }
        }
        return answer;
    }
}