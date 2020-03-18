package day02;

import java.util.Scanner;

public class day0207 {
	public static void main(String[] args) {
		int myAcc = 1234;
		int myMoney = 8700;
		int yourAcc = 4321;
		int yourMoney = 12000;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("계좌번호 입력하세요 : ");
		int acc = scan.nextInt();
		if( yourAcc == acc ) {
			System.out.print("이체 할 금액을 입력하세요 : ");
			int money = scan.nextInt();
			if(money <= myMoney) {
				myMoney -= money;
				yourMoney += money;
				
				System.out.println("myMoney = "+myMoney+"원");
				System.out.println("yourMoney = "+yourMoney+"원");
			}
			else {
				System.out.println("잔액이 부족합니다.");
			}
		}
		else {
			System.out.println("존재하지 않는 계좌번호 입니다.");
		}
		
		
	}
}
