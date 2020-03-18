package day02;

import java.util.Scanner;

public class day0213 {
	public static void main(String[] args) {
		//영수증 출력 2단계 +필요한금액 있을때 상황 추가
		int price1 = 8700;
		int price2 = 6200;
		int price3 = 1500;
		
		System.out.println("=== 롯데리아 ===");
		System.out.println("1.불고기 버거 : " + price1 + "원");
		System.out.println("2.새우    버거 : " + price2 + "원");
		System.out.println("3.콜         라 : " + price3 + "원");
		int i = 0; // 5번 반복 
		int sum = 0; // 총 금액
		int[] menu = new int[5];
		int menu1 =0 , menu2=0, menu3=0;
		Scanner scan = new Scanner(System.in);
		while(i<5) {
			System.out.print(" 메뉴 선택 : ");
			menu[i] = scan.nextInt();
			if(menu[i]==1) {
				sum+=price1;
				menu1++;
			}
			else if(menu[i]==2) {
				sum+=price2;
				menu2++;
			}
			else if(menu[i]==3) {
				sum+=price3;
				menu3++;
			}
			i++;
		}
		System.out.println("총 금액 : "+ sum);
		int changes = 0; // 잔돈
		while(true) {
			int lack = 0; // 필요한 금액
			int money =0;
			System.out.print("현금 입력 : ");
			money = scan.nextInt();
			if((money) >= sum) { // 입금한 금액이 총 금액보다 많다
				changes = money-sum; 
				System.out.println("=== 롯데리아 영수증 ===");
				System.out.println("1. 불고기버거 : "+menu1+"개");
				System.out.println("2. 새우   버거 : "+menu2+"개");
				System.out.println("3.  콜     라   : "+menu3+"개");
				System.out.println("4. 총   금  액  : "+sum+"원");
				System.out.println("5.  잔     돈   : "+changes+"원");
				break;
			}
			else if((money)<sum){ // 입금한 금액이 총금액보다 적은 경우 필요한 금액 및 추가 금액 계산 해보기 
				lack = sum-money; // 필요한 금액 책정
				sum = lack;
				System.out.println("현금이 부족합니다. 입금 금액 : "+money+" 부족금액 : "+ lack);
			}
		}

	}
}
