import java.util.*;

class Solution {
    int count;
    public int solution(int[] scoville, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue();
        
        for(int i = 0; i < scoville.length; i++){
            pq.offer(scoville[i]);
        }
        
        
        while(!pq.isEmpty()){
            if(pq.peek() >= k) return count;
            
            
            if(pq.size() <= 1) return -1;
            pq.offer(mix(pq.poll(), pq.poll()));
            count++;
           
        }
        
        return -1;    
        
    }
    
    
    public int mix(int first, int second){
        return (int)(first + (second*2));
    }
}