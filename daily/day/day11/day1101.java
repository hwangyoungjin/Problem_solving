package day11;

import java.util.Scanner;

/*
 * # 소수 찾기[3단계]
 * 1. 숫자를 한 개 입력받는다.
 * 2. 입력받은 숫자보다 큰 첫 번째 소수를 출력한다.
 * 
 * 예) Enter Number ? 1000
 *    1000보다 큰 첫번재 소수는 1009
 * 예) Enter Number ? 500
 *    500보다 큰 첫번째 소수는 503
 */

public class day1101 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter Number ? ");
		int number = scan.nextInt();
		
		int prime = number;
		
		while(true) {
			int integerCheck = -1;
			prime++; 
			
			//sqrt(prime) 까지만 나눠서 안나눠지면 prime이다.
			for(int i=2; i<(int)Math.sqrt(prime); i++) {

				if(prime%i == 0) { // 소수가 아님
					integerCheck = 1;
					break;
				}
				
			}
			
			if(integerCheck != 1) { // 소수
				System.out.println(number+"보다 큰 첫번째 소수는 : "+prime);
				break;
			}
		}
		
	}
}
