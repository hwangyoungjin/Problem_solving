package day08;

import java.util.Scanner;

public class day0802 {
	/*
	 * # ATM[4단계] : 전체 기능구현
	 * 1. 회원가입
	 * . id와 pw를 입력받아 가입
	 * . 가입 시 돈 1000원 부여
	 * . id 중복체크
	 * 2. 회원탈퇴
	 * . 로그인시에만 이용가능
	 * 3. 로그인
	 * . id와 pw를 입력받아 로그인
	 * . 로그아웃 상태에서만 이용가능
	 * 4. 로그아웃
	 * . 로그인시에만 이용가능
	 * 5. 입금
	 * . 로그인시에만 이용가능
	 * 6. 이체
	 * . 로그인시에만 이용가능
	 * 7. 잔액조회
	 * . 로그인시에만 이용가능
	 */
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int MAX = 5;
		
		int[] arId = new int[MAX];
		int[] arPw = new int[MAX];
		int[] arMoney = new int[MAX];
		int arCount = 0;
		int arIdx = -1; // 로그인시 회원아이디 배열의 인덱스

		
		String menu = "=== ATM ===\n";
		menu += "1.회원가입\n2.회원탈퇴\n3.로그인\n4.로그아웃\n";
		menu += "5.입금\n6.이체\n7.잔액조회\n0.종료";
		
		int logId = 0; // 로그인 한 id
		int logPw = 0; // 로그인 한 pw
		while(true) {
			
			System.out.println(menu);
			
			int sel = scan.nextInt();
			
			if(sel == 1) { // 회원가입
				if(arIdx >= 0) { 
					System.out.println(logId+"님이 로그인 중입니다.");
					continue;
				}
				
				if(arCount == 5) {
					System.out.println("가입인원 초과");
					continue;
				}
				System.out.print("id : " );
				int id = scan.nextInt();
				
				int check =0;
				for(int i=0; i<MAX; i++) {
					if(arId[i] == id ) {
						System.out.println("이미 존재하는 id입니다.");
						check = -1;
					}
				}
				if(check != -1) {				
					arId[arCount] = id;
					System.out.print("pw : " );
					int pw = scan.nextInt();
					arPw[arCount] = pw;
					arMoney[arCount] = 1000;
					System.out.println("회원가입 완료!");
					arCount++;
				}
			}
			
			
			else if(sel == 2) { // 회원탈퇴
				if(arIdx < 0) { 
					System.out.println("로그인 부탁드립니다.");
					continue;
				}
				else {
					for(int i=0; i<MAX; i++) {
						if(arId[i] == logId && arPw[i] == logPw) {
							arId[i] = 0;
							arPw[i] = 0;
							System.out.println("회원탈퇴 완료");
							arIdx = -1;
						}
					}
				}
			}
			
			else if(sel == 3) { // 로그인
				if(arIdx >= 0) { 
					System.out.println(logId+"님이 로그인 중입니다.");
					continue;
				}
				
				System.out.print("id : " );
				logId = scan.nextInt();
				System.out.print("pw : " );
				logPw = scan.nextInt();
				
				for(int i=0; i<MAX; i++) {
					if(arId[i] == logId && arPw[i] == logPw) {
						arIdx = i;
						System.out.println(logId+"님 로그인 성공");
					}
				}
				if(arIdx < 0){	
					System.out.println("id/pw가 존재하지 않습니다.");
				}
			}
			else if(sel == 4) { //로그아웃
				if(arIdx < 0) { 
					System.out.println("로그인 부탁드립니다.");
					continue;
				}
				else {
					logId=0;
					logPw=0;
					arIdx = -1;
					System.out.println("로그아웃 완료");
				}
			}
			else if(sel == 5) { //입금
				if(arIdx < 0) { 
					System.out.println("로그인 부탁드립니다.");
					continue;
				}
				else {
					System.out.println("현재 잔액 "+arMoney[arIdx]);
					System.out.print("입금할 금액 입력 : ");
					int money = scan.nextInt();
					arMoney[arIdx] += money;
					System.out.println("현재 잔액 "+arMoney[arIdx]);
				}
			}
			else if(sel == 6) { //이체
				if(arIdx < 0) { 
					System.out.println("로그인 부탁드립니다.");
					continue;
				}
				else {
					System.out.println("이체할 id를 입력해주세요 : ");
					int reciever = scan.nextInt();
					
					int check = -1;
					for(int i=0; i<MAX; i++) {
						if(arId[i] == reciever ) { //reciever가 존재
							check = 1;
						}
					}
					if(check != 1) {
						System.out.println("존재 하지 않는 이체 id 입니다.");
						continue;
					}
					
					System.out.println("이체할 금액을 입력해주세요 : ");
					int money = scan.nextInt();
					
					
					if(arMoney[arIdx] < money) {
						System.out.println("잔액부족");
						continue;
					}
					else {
						for(int i=0; i<MAX; i++) {
							if(arId[i] == reciever) {
								arMoney[i] += money;
								arMoney[arIdx] -= money;
								System.out.println("이체 완료");
							}
						}
					}
					
				}
				
			}
			else if(sel == 7) { //잔액조회
				if(arIdx < 0) { 
					System.out.println("로그인 부탁드립니다.");
					continue;
				}
				else {
					System.out.println("현재 잔액 "+arMoney[arIdx]);
				}
			}
			else if(sel == 0) {
				break;
			}
		}
		
	}
}
