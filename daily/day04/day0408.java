package day04;

import java.util.Scanner;

public class day0408 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[] lotto1 = {0, 0, 7, 7, 7, 0, 0, 0};
		int[] lotto2 = {0, 0, 7, 7, 0, 0, 7, 0};
		int[] lotto3 = {7, 0, 7, 7, 7, 0, 7, 0};
		
		boolean run = true;
		while(run) {
			
			System.out.println("[1]번복권 결과확인");
			System.out.println("[2]번복권 결과확인");
			System.out.println("[3]번복권 결과확인");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if(sel == 1) {
			
			}
			else if(sel == 2) {
			
			}
			else if(sel == 3) {
				int check = -1;
				int cnt = 0;
				for(int i=0; i<8; i++) {
					if(lotto1[i] == 7) {
						cnt += 1;
						if(cnt == 3) {
							check = 1;
						}
					}else {
						cnt = 0;
					}
				}
				if(check == 1) {
					System.out.println("당첨!");
				}else {
					System.out.println("꽝!");
				}				
			}
			
		}

	}
}
