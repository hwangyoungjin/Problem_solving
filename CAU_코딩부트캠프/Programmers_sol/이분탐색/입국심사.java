import java.util.*;
class Solution {
    /*이분 탐색은 대부분 long타입이고 초기 min, max 값 설정이 중요!!*/
    /*int->long 자동형변환 안되서 계속틀림...형변환타입써준다!!!!!!!*/
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long max = (long)n*(times[times.length-1]);
        long answer = max;
        long min = 1;
        
        long middle = 0;
        long sum = 0;
        while(min <= max){
            sum=0;
            middle = (min+max)/2;
            //System.out.println("middle = "+middle);
            for(int i=0; i<times.length; i++){
                sum += middle/times[i];  
            }
            if(sum >= n){
                if(middle<answer){
                     answer=middle;
                 }
                max = middle-1;
            }else{
                min = middle+1; 
            }
           // System.out.println("min : "+min+", max : "+max);
        }
        
        return answer;
    }
}