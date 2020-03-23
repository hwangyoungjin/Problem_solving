package day07;

import java.util.Scanner;

/*
 * # ATM[3단계]
 * 1. 가입
 * . 계좌번호와 비밀번호를 입력받아 가입
 * . 계좌번호 중복검사
 * 2. 탈퇴
 * . 계좌번호를 입력받아 탈퇴
 */

public class day0701 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int[] accs = {1001, 1002, 0, 0, 0};
		int[] pws  = {1111, 2222, 0, 0, 0};
		
		int cnt = 2;
		
		boolean run = true;
		Loop1 : while(run) { 
			System.out.println(java.util.Arrays.toString(accs));
			
			System.out.println("1.가입");
			System.out.println("2.탈퇴");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if(sel == 1) {//가입
				System.out.print("계좌번호 생성 : ");
				int myAcc = scan.nextInt();
				for(int i=0; i<accs.length; i++) {
					if(myAcc == accs[i]) {
						System.out.println("이미 등록된 계좌번호 입니다.");
						System.out.println();
						continue Loop1;
					}
				}
				System.out.print("비밀번호 생성 : ");
				int myPw = scan.nextInt();
				for(int i=0; i<accs.length; i++) {
					if(accs[i] == 0) {
						accs[i] = myAcc;
						pws[i] = myPw;
						System.out.println("가입 완료");
						System.out.println();
						continue Loop1;
					}
				}
			}
			else if(sel == 2) {//탈퇴
				System.out.print("계좌번호를 입력하세요 : ");
				int yourAcc = scan.nextInt();
				for(int i=0; i<accs.length; i++) {
					if(yourAcc == accs[i]) {
						accs[i] = 0;
						pws[i] = 0;
						System.out.print("탈퇴완료");
					}
				System.out.println("없는 계좌입니다.");
				System.out.println();
						
				}
			}
			
		}

	}
}
