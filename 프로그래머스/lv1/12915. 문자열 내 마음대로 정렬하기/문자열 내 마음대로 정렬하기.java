// 1. Arraylist에 n번째 인덱스를 맨 앞에 추가하여 저장한 후 정렬 
// 2. 이후 추가한 부분은 잘라내고 answer에 다시 저장

import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        ArrayList<String> list = new ArrayList<>();
        
        // 1. Arraylist에 n번째 인덱스를 맨 앞에 추가하여 저장한 후 정렬 
        for(int i = 0; i < strings.length; i++) {
            list.add(strings[i].charAt(n) + strings[i]);
        }
        
        Collections.sort(list);
        // System.out.println(list);
        
        // 추가한 부분은 잘라내고 answer에 다시 저장
        answer = new String[strings.length];
        
        for(int i = 0; i < strings.length; i++) {
            answer[i] = list.get(i).substring(1, list.get(i).length());
            // ArrayList[i] -> (X) 
            // ArrayList.get(i) -> (O)
            // string일 때 length() -> 괄호 넣기
        }
        
        return answer;
        }
}