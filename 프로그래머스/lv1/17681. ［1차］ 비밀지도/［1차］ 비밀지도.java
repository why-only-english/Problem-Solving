class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0; i<n; i++){
        	// 비트 연산자 이용
            String arrs = Integer.toBinaryString(arr1[i] | arr2[i]); 
            // arrs의  길이 대입 
            int len = arrs.length();
            
            // led의 길이가 n보다 작으면 n-len만큼 앞에 0 채우기
            // ex) n이 6일 때 1101이라면 -> 001101
            if(len < n) {
            	for(int j = 0; j < n-len; j++) {
            		arrs = "0" + arrs;
            	}
            }  
            answer[i] = arrs;
		}
        
        // 1을 #으로 0을 공백으로
        for(int i=0; i<n; i++) {
        	answer[i] = answer[i]
                .replace("1", "#")
                .replace("0", " ");    
        }
    	return answer;
    }
}