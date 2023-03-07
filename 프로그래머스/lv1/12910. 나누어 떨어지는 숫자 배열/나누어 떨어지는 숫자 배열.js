function solution(arr, divisor) {
    var answer = [];
    
    
    for (let i = 0; i < arr.length; i++) {  
        // 나누어 떨어지는 값 저장
        if (arr[i] % divisor === 0) answer.push(arr[i]);
    }
    
    // 하나도 없다면 -1 저장
    if (answer.length === 0 ) answer.push(-1);
    
    return answer.sort((a,b) => (a-b));  // 오름차순 정렬
}