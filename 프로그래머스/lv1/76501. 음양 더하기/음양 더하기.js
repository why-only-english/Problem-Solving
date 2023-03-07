function solution(absolutes, signs) {
    var answer = 0;
    
    for (let i = 0; i < signs.length; i++) {
        if (signs[i] === true) answer += absolutes[i];  // 양수
        else answer -= absolutes[i];                    // 음수
    }
    return answer;
}