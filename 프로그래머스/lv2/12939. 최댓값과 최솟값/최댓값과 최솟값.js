function solution(s) {
    var answer = [];
    let arr = s.split(' ').sort((a,b) => (a-b));
    answer.push(arr[0], arr[arr.length-1]);
    return answer.join(' ');
}