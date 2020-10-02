package day03;

import java.util.Scanner;

public class day0301 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.print("숫자를 입력 하세요 : ");
			int su = scan.nextInt();
			int suNega = ~su+1;
			if(su == -100) {
				System.out.println("프로그램 종료");
				System.exit(0);
			}
		}
		
	}
}
