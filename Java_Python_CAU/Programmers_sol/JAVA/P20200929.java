//2020-09-29
/*
[문제]
문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. 예를 들어 s가 a234이면 False를 리턴하고 1234라면 True를 리턴하면 됩니다.

제한 사항
s는 길이 1 이상, 길이 8 이하인 문자열입니다.
입출력 예
s	return
a234	false
1234	true
 */

//[풀이]
class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        if(s.length() == 4 || s.length() == 6){ //문자열 길이가 4 or 6이고
            answer = true;
            for(int i=0; i<s.length(); i++){ // 모든 배열에 대해
                if(s.charAt(i) < '0' || s.charAt(i) > '9' ){ 
                    //숫자가 아닌게 하나라도 있으면 false
                    answer = false;
                }
            }
        }
        return answer;
    }
}

/*
[문제]
함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다. 다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.

제한 조건
x는 -10000000 이상, 10000000 이하인 정수입니다.
n은 1000 이하인 자연수입니다.
입출력 예
x	n	answer
2	5	[2,4,6,8,10]
4	3	[4,8,12]
-4	2	[-4, -8]
*/

//풀이
class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        answer[0] = x;
        for(int i=1; i<n; i++){ //n-1번 반복
            answer[i] = answer[i-1] + x;
        }
        return answer;
    }
}


