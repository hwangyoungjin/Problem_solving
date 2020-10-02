package day11;

import java.util.Scanner;

public class day1102 {

	public static void main(String[] args) {
		
		
		//문제1) 1~백만 사이의 숫자를 입력받고 가운데 숫자 출력 
        //(단 ! 짝수자리의 수는 짝수자리라고 출력)
		// 예)  123 ==> 2
		// 예)  1234 ==> 짝수의 자리이다
		// 예)  1 ==> 1
		// 예)  1234567 ==> 4
		
		// 힌트 자리수를 구하고 배열을 만든다음 하나씩 저장 
		// 예) ==> 123 ==> 3 ==> arr[] = new int[3];
		
		Scanner scan = new Scanner(System.in);
		System.out.print("1~1,000,000 사이의 숫자를 입력하세요 : ");
		int input = scan.nextInt();
		String str = String.valueOf(input);
		if(str.length()%2 == 0) {
			System.out.println("짝수의 자리이다.");
		}
		else {
			int center = str.length()/2;
			System.out.println("가운데 숫자는 : "+ str.charAt(center) );
		}
		
	}

}