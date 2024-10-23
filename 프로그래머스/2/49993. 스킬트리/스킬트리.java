import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skill_tree : skill_trees) {
            int k = 0;  
            boolean isValid = true;  

            for (int j = 0; j < skill_tree.length(); j++) {
                char currentSkill = skill_tree.charAt(j);

                if (skill.indexOf(currentSkill) != -1) {
                    if (currentSkill != skill.charAt(k)) {
                        isValid = false;
                        break;
                    } else {
                        k++;
                    }
                }
            }

            if (isValid) {
                answer++;
            }
        }
        return answer;
    }
}
