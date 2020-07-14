package day04;

import java.util.Scanner;

public class day0402 { //뒤로가기[문제]
	/*
	 * # 쇼핑몰 뒤로가기
	 * 1. 남성의류
	 * 		1) 티셔츠
	 * 		2) 바지
	 * 		3) 뒤로가기
	 * 2. 여성의류
	 * 		1) 가디건
	 * 		2) 치마
	 * 		3) 뒤로가기
	 * 3. 종료
	 */
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		boolean run = true;
		while(run) {
			
			System.out.println("1.남성의류");
			System.out.println("2.여성의류");
			System.out.println("3.종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				System.out.println("1)티셔츠");
				System.out.println("2)바지");
				System.out.println("3)뒤로가기");
				int choice = scan.nextInt();
				if(choice == 1) {
					System.out.println("티셔츠 구매완료");
				}
				else if(choice ==2) {
					System.out.println("바지 구매완료");
				}
				else if(choice == 3) { //뒤로가기 선택
					continue;
				}
			}
			else if(sel == 2) { // 여성의류 선택
				System.out.println("1)가디건");
				System.out.println("2)치마");
				System.out.println("3)뒤로가기");
				int choice = scan.nextInt();
				if(choice == 1) {
					System.out.println("가디건 구매완료");
				}
				else if(choice ==2) {
					System.out.println("치마 구매완료");
				}
				else if(choice == 3) { //뒤로가기 선택
					continue;
				}
			}
			else if(sel == 3) { // 종료선택
				run = false;
				System.out.println("프로그램 종료");
			}
		}
	}
}
