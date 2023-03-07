function solution(seoul) {
    var answer = '';
    let cnt = 0;
    for (let i = 0; i < seoul.length; i++) {
        if (seoul[i] === 'Kim') {
            answer += `김서방은 ${i}에 있다`
        }
    }
    return answer;
}