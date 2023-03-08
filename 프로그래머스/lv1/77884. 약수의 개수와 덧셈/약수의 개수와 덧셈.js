function solution(left, right) {
    
    var answer = 0;
    
    for (i = left; i <= right; i++) {
        // 약수가 홀수 == 제곱수
        if (Number.isInteger(Math.sqrt(i))) {
            answer -= i
        }
        else {
            answer += i
        }
    }

    return answer;
}