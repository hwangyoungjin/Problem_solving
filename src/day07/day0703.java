package day07;

import java.util.Scanner;

/*
 * # 소수찾기[2단계]
 * 정수 한 개를 입력받아, 2부터 해당 숫자까지의 모든 소수 출력
 * 예)
 * 입력 : 20
 * 2, 3, 5, 7, 11, 13, 17, 19
 */

public class day0703 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int su = scan.nextInt();
		int i;
		for(i=2; i<su; i++) { // 소수 찾기 
			int check = 0; // 1이면 소수x 
			for(int j=2; j<i; j++) { // 소수 조건
				if(i%j==0) {// ex.12%3==0 소수아님 
					check=1;
				}
			}
			if(check==0) {
				System.out.print(i+" ");
			}

		}
	}
}
