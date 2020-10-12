package daily;
/**
 * 가장 큰 수
[문제 설명]
0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

제한 사항
numbers의 길이는 1 이상 100,000 이하입니다.
numbers의 원소는 0 이상 1,000 이하입니다.
정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
입출력 예
numbers	return
[6, 10, 2]	6210
[3, 30, 34, 5, 9]	9534330
 * @author USER
 *
 */
import java.util.*;

class Solution5 {
	public String solution(int[] numbers) {
    	//int 배열을 Integer배열로 변환
    	List<Integer> intNumbers = new ArrayList<>();
        
    	for(int i=0; i<numbers.length; i++) {
            //기본형->참조형 오토박싱(반대는 언박싱)
    		intNumbers.add(numbers[i]); 
    	}
    	//Integer클래스의 맞게 정렬기준만들어서 정렬하기
    	Collections.sort(intNumbers, new Comparator<Integer>(){ 
            //익명클래스 Comparator 새로운 기준 만들기
            @Override
            public int compare(Integer su1, Integer su2){
                //ex. su1 = 10, su2 = 2인경우 2가 더 큼
            	//ex. su1 = 314, su2 = 36인경우 36가 더 큼
            	//ex. su1 = 929, su2 = 925인경우 929가 더 큼
                
            	String str1 = su1+""+su2;
            	String str2 = su2+""+su1;
            	//문자열 순서를 바꿔 더한 후 값 비교
            	return (Integer.valueOf(str2)-Integer.valueOf(str1));
            }
        });
        
        //List안에 값 String으로 복사
        String answer = "";
        Iterator it = intNumbers.iterator();
        while(it.hasNext()){
            answer += (it.next()+"");
        }
        if(answer.charAt(0) == '0'){
            return "0";
        }
        return answer;
    }
}

public class P201011 {
	public static void main(String[] args) {
		Solution5 sol = new Solution5();
		int[] numbers = {6,10,2};
		System.out.println(sol.solution(numbers));
	}
}
