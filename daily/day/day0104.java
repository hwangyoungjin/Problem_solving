package day01;

import java.util.Scanner;

public class day0104 {
	public static void main(String[] args) {
		//up & down 게임 
		int com = 8;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.print("수를 입력하세요 : ");
			int me = scan.nextInt();
			if(me<com) {
				System.out.println("Up!");
			}
			else if(me > com) {
				System.out.println("Down!");
			}
			else {
				System.out.println("정답입니다");
				break;
			}
		} while (true);
	}
}
