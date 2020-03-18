package day01;

import java.util.Scanner;

public class day01 {
	public static void main(String[] args) {
		//식권 자판기
		Scanner scan = new Scanner(System.in);
		int[] money = {50000, 10000, 5000, 1000, 500, 100}; //금액
		int[] charge = {    1,     1,    1,    1,   5,   10}; // 잔돈
		
		int tickets =5; // 식권 개수
		int price = 3200; // 식권가격
		
		while(true) {
			System.out.println("[1] 관리자");
			System.out.println("[2] 사용자");
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if(sel==1) {
				while(true) {
					System.out.println("1)식권충전");
					System.out.println("2)잔돈충전");
					System.out.println("3)뒤로가기");
					System.out.print("메뉴 선택 : ");
					int choice = scan.nextInt();
					if(choice ==1) {
						System.out.println("식권가격 : "+price);
						System.out.print("식권 매수 : ");
						int su = scan.nextInt();
						if(tickets <= 0) { // 식권 개수가 0개이면 매진 출력
							System.out.println("식권 매진");
							break;
						}
						int sum = su*price; // 총 식권 구매 가격
						System.out.println("가격은 : "+sum+"입니다.");
						// 5만원이 있는지 없는지 확인 
						if( sum >= 50000 && charge[0]>=0) { // 5만원권이 존재하고 총가격이 5만원을 넘었을때
							charge[0] -= sum/money[0] ; // 개수 줄이기
							System.out.println("50000원 : "+ sum/money[0] +"매"); // 필요개수
							sum %= money[0]; // money값 줄이기
						}
						if(sum >= 10000 && charge[1]>=0) {//만원권 존재 총가격이 만원이상
							charge[1] -= sum/money[1];
							System.out.println("10000원 : "+ sum/money[1]+"매");
							sum %= money[1];
						}
						if(sum >= 5000 && charge[2]>=0) {//오천원권 존재 && 총가격 5천원이상
							charge[2] -= sum/money[2]; 
							System.out.println("5000원 : "+sum/money[2]+"매");
							sum %= money[2];
						}
						if(sum >= 1000 && charge[3]>=0) {//오천원권 존재
							charge[3] -= sum/money[3];
							System.out.println("1000원 : "+sum/money[3]+"매");
							sum %= money[3];
						}
						if(sum >= 500 && charge[4]>=0) {//오천원권 존재
							charge[4] -= sum/money[4];
							System.out.println("500원 : "+sum/money[4]+"개");
							sum %= money[4];
						}
						if(sum >= 100 && charge[5]>=0) {//오천원권 존재
							charge[5] -= sum/money[5];
							System.out.println("100원 : "+sum/money[5]+"개");
							sum %= money[5];
						}
						tickets -= su; // 식권 구매후 개수 감소
					}
					else if(choice == 2) { // 잔돈 충전
						
					}
					else if(choice == 3) {
						break;
					}
				}
			}
			else if(sel ==2 ) {
				while(true) {
					System.out.println("1)구입");
					System.out.println("2)뒤로가기");
					System.out.print("메뉴 선택 : ");
					int choice = scan.nextInt();
					if(choice==1) {}
					else if (choice==2) {
						break;
					}
				}
			}
		}
	}
}
