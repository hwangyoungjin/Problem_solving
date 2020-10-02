package day04;

import java.util.Scanner;

public class day0507 {
	public static void main(String[] args) {
		/*
		 * # 영화관 좌석예매
		 * 1. 사용자로부터 좌석번호(index)를 입력받아 예매하는 시스템이다.
		 * 2. 예매가 완료되면 해당 좌석 값을 1로 변경한다.
		 * 3. 이미 예매가 완료된 좌석은 재구매할 수 없다.
		 * 4. 한 좌석당 예매 가격은 12000원이다.
		 * 5. 프로그램 종료 후, 해당 영화관의 총 매출액을 출력한다.
		 * 예)
		 * seat = 0 0 0 0 0 0 0
		 * 
		 * 좌석선택 : 1
		 * seat = 0 1 0 0 0 0 0
		 * 
		 * 좌석선택 : 3
		 * seat = 0 1 0 1 0 0 0
		 * 
		 * 좌석선택 : 3
		 * seat = 0 1 0 1 0 0 0
		 * 이미 예매가 완료된 자리입니다.
		 * ----------------------
		 * 매출액 : 24000원
		 */
		Scanner scan = new Scanner(System.in);
		
		int[] seat = new int[7];
		int[] seat1 = {1,2,3,4,5,6,7};
		
		int income = 0;
		boolean run = true;
		while(run) {
			System.out.println("=메가 영화관=");
			System.out.println("1.좌석예매");
			System.out.println("2.종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if(sel == 1) { // 좌석 예매
				System.out.println("   번호   "+java.util.Arrays.toString(su));
				System.out.println("현재자리"+java.util.Arrays.toString(seat));
				System.out.print("좌석번호 선택 : ");
				int index = scan.nextInt();
				if(seat[index] == 0) {
					seat[index] = 1;
					income += 12000;
				}
				else if(seat[index]== 1) {
					System.out.println("이미 예매된 자리입니다.");
				}
			}
			else if(sel == 2) {
				run = false;
				System.out.println("------------------");
				System.out.println("총 매출액 : " + income);
			}
		}

	}
}
