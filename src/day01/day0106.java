package day01;

import java.util.Scanner;

public class day0106 {
	public static void main(String[] args) {
		// 로그인(2단계)[문제]
		
		
			Scanner scan = new Scanner(System.in);
		System.out.println("------회원가입을 위해 아이디 & 비번 입력-----");
		System.out.print("등록할 아이디 입력 : ");
		int dbId = scan.nextInt();
		System.out.print("등록할 비번 입력 : ");
		int dbPw = scan.nextInt();
		do {
			System.out.println("-----로그인을 위해 아이디&비번 입력 하기-----");
			System.out.print("아이디 입력 : ");
			int meId = scan.nextInt();
			System.out.print("비번 입력 : ");
			int mePw = scan.nextInt();
			
			if(dbId==meId && dbPw==mePw) {
				System.out.println("로그인 성공 ");
				break;
			}
			if(dbPw != mePw || dbId!=meId) {
				System.out.println("로그인 실패");
			}
		} while(true);
	}
}
