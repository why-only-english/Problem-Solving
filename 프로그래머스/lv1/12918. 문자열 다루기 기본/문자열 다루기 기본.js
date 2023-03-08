function solution(s) {
    let answer = true;
    if (s.length !== 6 && s.length !== 4) {
        answer = false;
    }
    else if (s.length == 4 || s.length == 6) {
        if (/[a-zA-Z]/.test(s)) {    
            answer = false;
        }
    }
    return answer;
}