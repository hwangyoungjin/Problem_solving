package day02;

import java.util.Scanner;

public class day0201 {
	public static void main(String[] args) {
		int price1 = 8700;
		int price2 = 6200;
		int price3 = 1500;
		Scanner scan = new Scanner(System.in);
		System.out.println("=== 롯데리아 ===");
		System.out.println("1.불고기 버거 : " + price1 + "원");
		System.out.println("2.새우    버거 : " + price2 + "원");
		System.out.println("3.콜          라 : " + price3 + "원");
		System.out.print("메뉴를 선택하세요 : ");
		int menu = scan.nextInt();
		System.out.print("현금을 입력하세요 : ");
		int money = scan.nextInt();
		if(menu == 1 && money >= price1) {
			System.out.println("영수증 출력");
		}
		else if(menu == 2 && money >= price2) {
			System.out.println("영수증 출력");
		}
		else if(menu == 3 && money >= price3) {
			System.out.println("영수증 출력");
		}
		else {
			System.out.println("현금 부족합니다.");
		}
	}
}
