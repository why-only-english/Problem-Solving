function solution(phone_number) {
    var answer = '';
    let arr = phone_number.split('');
    
    for (let i = 0; i < arr.length-4; i++) {
        arr[i] = '*';
    }
    
    answer = arr.join('');
    return answer;
}