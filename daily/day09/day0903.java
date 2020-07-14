package day09;

import java.util.Scanner;

public class day0903 {

	/*
	 * # 쇼핑몰 [장바구니]
	 * 1. 로그인 후 쇼핑 메뉴를 선택하면, 다음과 같이 상품목록을 보여준다.
	 * 	1) 사과
	 *  2) 바나나
	 *  3) 딸기
	 * 2. 번호를 선택해 상품을 장바구니에 담을 수 있다.
	 * jang 배열 에서 
	 * 3. 로그인 회원의 인덱스 번호는 각 행의 첫번째 열에 저장한다.
	 * 4. 해당 회원이 구매한 상품의 인덱스 번호는 각 행의 두번째 열에 저장한다.
	 * 예)
	 * {
	 * 		{0, 1},				qwer회원 			> 사과구매
	 * 		{1, 2},				javaking회원 		> 바나나구매
	 * 		{2, 1},				abcd회원			> 사과구매
	 * 		{0, 3},				qwer회원			> 딸기구매
	 * 		...
	 * }
	 */

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		String[] ids = {"qwer", "javaking", "abcd"};
		String[] pws = {"1111",     "2222", "3333"};
		
		int MAX_SIZE = 100;
		int[][] jang = new int[MAX_SIZE][2]; 
		int count = 0; // 사용자와 관계없이 지금까지 선택된 상품의 개수 check	
		
		
		String[] items = {"사과", "바나나", "딸기"};

		
		int log = -1; // 로그인 상태 표시
		int loginIdx = 0; // 로그인 한 사람의 ids배열 index 저장
		
		while(true) {
			
			System.out.println("[MART]");
			System.out.println("[1]로 그 인");
			System.out.println("[2]로그아웃");
			System.out.println("[3]쇼     핑");
			System.out.println("[4]장바구니 확인");
			System.out.println("[0]종     료");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if(sel == 1) { // 로그인
				System.out.print("ID 입력 : ");
				String logId = scan.next();
				System.out.print("pw 입력 : ");
				String logPw = scan.next();
				for(int i=0; i<ids.length; i++) {
					if(ids[i].equals(logId) && pws[i].endsWith(logPw)) {
						log = 1; // 로그인 성공
						loginIdx = i; // 로그인한 사람 index 저장
						System.out.println(ids[i]+"님 환영합니다.");
					}
				}
				if(log<0) {
					System.out.println("로그인 실패");
				}
			}
			else if(sel == 2) { // 로그아웃
				log = -1;
				System.out.println(ids[loginIdx]+"님 정상적으로 로그아웃 되셨습니다."); 
			}
			else if(sel == 3) { // 쇼핑
				if(log>0) {
					while(true) {
						System.out.println("구매할 상품 선택");
						for(int i=0; i<items.length; i++) {
							System.out.println((i+1)+"번 : "+items[i]);
						}
						System.out.println("4번 : 뒤로가기");
						int ch = scan.nextInt();
						
						if(ch == 4) {
							break;
						}
						else if(ch>4) {
							System.out.println("번호 다시 입력해주세요");
						}
						
						// 1 or 2 or 3 입력
						jang[count][0] = loginIdx;
						jang[count][1] = ch;
						count++;
					}
				}
				else {
					System.out.println("로그인해주세요");
				}
			}
			else if(sel == 4) { // 장바구니 확인
				if(log>0) {
					if(count == 0 ) {
						System.out.println("선택된 상품이 없습니다.");
					}
					else {
						int apple=0;
						int banana=0;
						int strawberry=0;
						for(int i=0; i<count; i++) {
							if(jang[i][0] == loginIdx) { // 저장된 jang에 로그인한사람과 장바구니에 넣은 사람이 같은경우
								
								int ch = jang[i][1];
								switch(ch) {
								case 1:
									apple++;
									break;
								case 2:
									banana++;
									break;
								case 3:
									strawberry++;
									break;
								}
							}
						}
						
						if(apple == 0 && banana == 0 && strawberry ==0) {
							System.out.println("선택된 상품이 없습니다.");
						}
						
						System.out.println(items[0]+": "+apple+"개");	
						System.out.println(items[1]+": "+banana+"개");
						System.out.println(items[2]+": "+strawberry+"개");
					}	
				}
				else {
					System.out.println("로그인해주세요");
				}	
			}
			else if(sel == 0) { // 종료
				System.out.println("프로그램 종료");
				break;
			}
			
		}
	}
}
