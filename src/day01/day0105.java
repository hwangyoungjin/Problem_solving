package day01;

import java.util.Scanner;

public class day0105 {
	public static void main(String[] args) {
		// 가위(0), 바위(1), 보(2) 게임 만들기
		int com = 1;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.print("가위(0), 바위(1), 보(2)를 입력 : ");
			int me = scan.nextInt();
			if (me >= 3) {
				System.out.println("다시 입력하세요");
				continue;
			}
			if(me > com) {
				System.out.println("이겼습니다.");
			}
			if(me < com) {
				System.out.println("졌습니다.");
			}
			if(me == com) {
				System.out.println("비겼습니다.");
			}
		}while(true);
		
	}
}
