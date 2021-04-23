package beakjoon;

import java.util.Arrays;
import java.util.Scanner;

public class P1300 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		
		int middle =0;
		int min = 1;
		int max = k; 
		//max는 우리가 찾는 값의 최대값인데  
		//우리가 찾는 값은 항상 해당 index인 k보다 낮으므로
		//max를 k로 지정
		
		//index
		int cnt = 0;
		int result = 0;
		//이분탐색
		while(min <= max) {
			middle = (min+max)/2;
			cnt = 0;
			//문제조건
			//middle의 값의 inx를 구해라
			for(int i=1; i<=n; i++) {
				cnt += Math.min(middle/i, n);
			}
			
			//비교
			if(cnt >= k) { //해당 middle값의 index가 k보다 크다는것은 k의 값은 middle안쪽에 있다는것
				result = middle;
				max = middle-1;
			}
			else {
				min = middle+1;
			}
		}
		System.out.println(result);
	}
}
