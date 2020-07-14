package day01;

import java.util.Scanner;

public class day0107 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count = 0;
		System.out.print("숫자 입력 : ");
		int x = scan.nextInt();
		System.out.print("숫자 입력 : ");
		int y = scan.nextInt();
		System.out.println("\n"+x+" x "+y+" = ?");
		do {
			if(count >=1 ) {
				System.out.print("재도전 하기 : ");
			}
			else {
				System.out.print("값 입력 : ");
			}
			
			int z = scan.nextInt();
			if( z == x*y) {
				System.out.println("정답!");
				break;
			}
			else {
				System.out.println("땡!");
			}
			count++;
		}while(true);
		
	}
}
