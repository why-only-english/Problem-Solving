function solution(s) {
    var answer = [];
    
    let arr = s.split('');
    let l = arr.length;
    
    if (l % 2 === 0) answer = arr.splice(l / 2 - 1, 2);
    else answer = arr.splice((l - 1) / 2, 1);
    
    return answer.join('');
}