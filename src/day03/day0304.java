package day03;

import java.util.Scanner;

public class day0304 { //atm 2단계 종합 문제
	public static void main(String[] args) {
		/*
		 * # ATM[2단계]
		 * 1. 로그인
		 * . 로그인 후 재 로그인 불가
		 * . 로그아웃 상태에서만 이용 가능
		 * 2. 로그아웃
		 * . 로그인 후 이용가능
		 * 3. 입금
		 * . 로그인 후 이용가능
		 * 4. 출금
		 * . 로그인 후 이용가능
		 * 5. 이체
		 * . 로그인 후 이용가능
		 * 6. 조회
		 * . 로그인 후 이용가능
		 * 7. 종료
		 */
		Scanner scan = new Scanner(System.in);
		
		int dbAcc1 = 1111;
		int dbPw1 = 1234;
		int dbMoney1 = 50000;
		
		int dbAcc2 = 2222;
		int dbPw2 = 2345;
		int dbMoney2 = 70000;	
		
		int log = -1;						// -1(로그아웃), 1(dbAcc1로그인), 2(dbAcc2로그인)
		
		boolean run = true;
		while(run) {
			
			System.out.println("1.로그인");
			System.out.println("2.로그아웃");
			System.out.println("3.입금");
			System.out.println("4.출금");
			System.out.println("5.이체");
			System.out.println("6.조회");
			System.out.println("0.종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if(sel == 1) { //로그인
				if(log != -1) { //로그인 중
					System.out.println("로그인 후 재이용 불가, 로그아웃 후 이용 해주세요");
				}
				else {
					System.out.print("본인의 계좌를 입력 해주세요 : ");
					int myAcc = scan.nextInt();
					System.out.print("본인의 비빌번호 4자리 입력해주세요 : ");
					int myPw = scan.nextInt();
					
					if(myAcc == dbAcc1 && myPw == dbPw1) {
						System.out.println("환영합니다. "+dbAcc1+"님");
						log=1;
					}
					else if(myAcc == dbAcc2 && myPw == dbPw2) {
						System.out.println("환영합니다. "+dbAcc2+"님");
						log=2;
					}
				}
			}
			else if(sel == 2) { // 로그아웃
				if(log == -1) { //로그인 되어있음
					System.out.println("로그인 후 이용해주세요");
				}
				else {
					log = -1;
					System.out.println("로그아웃 되었습니다.");
				}
			}
			else if(sel == 3) { // 입금
				if(log == -1) {
					System.out.println("로그인 후 이용해주세요");
				}
				else if(log == 1) {
					System.out.print("현재 잔액 : "+dbMoney1+"원, 입금 할 금액 : ");
					int deposit = scan.nextInt();
					dbMoney1 += deposit;
					System.out.println("입금이 완료되었습니다. 현재잔액 : "+dbMoney1+"원");
				}
				else if(log == 2) {
					System.out.print("현재 잔액 : "+dbMoney2+"원, 입금 할 금액 : ");
					int deposit = scan.nextInt();
					dbMoney2 += deposit;
					System.out.println("입금이 완료되었습니다. 현재잔액 : "+dbMoney2+"원");
				}
			}
			else if(sel == 4) { // 출금
				if(log == -1) {
					System.out.println("로그인 후 이용해주세요");
				}
				else if(log==1) {
					System.out.print("현재 잔액 : "+dbMoney1+"원, 출금 할 금액 : ");
					int withdraw = scan.nextInt();
					if(withdraw > dbMoney1) {
						System.out.println("잔액 부족");
					}
					else {
						dbMoney1 -= withdraw;
						System.out.println("출금이 완료되었습니다. 현재 잔액 : "+dbMoney1+"원");
					}
				}
				else if(log==2) {
					System.out.print("현재 잔액 : "+dbMoney2+"원, 출금 할 금액 : ");
					int withdraw = scan.nextInt();
					if(withdraw > dbMoney2) {
						System.out.println("잔액 부족");
					}
					else {
						dbMoney2 -= withdraw;
						System.out.println("출금이 완료되었습니다. 현재 잔액 : "+dbMoney2+"원");
					}
				}
			}
			else if(sel == 5) { //이체
				if(log == -1) {
					System.out.println("로그인 후 이용해주세요");
				}
				else if (log==1) {
					System.out.println("안녕하세요. "+dbAcc1+"님");
					System.out.print("이체 할 계좌를 입력해주세요 : ");
					int yourAcc = scan.nextInt();
					if(yourAcc == dbAcc2) {
						System.out.print("이체할 금액 : ");
						int trans = scan.nextInt();
						if(trans > dbMoney1) {
							System.out.println("잔액 부족");
						}
						else {
							dbMoney1 -= trans;
							dbMoney2 += trans;
							System.out.println(dbAcc1+"님의 계좌에서 "+dbAcc2+"님의 계좌로 "+trans+"원 이체 완료되었습니다.");
							System.out.println(dbAcc1+"님의 남은 잔액은 : "+dbMoney1+"원 입니다.");
						}
					}
					else {
						System.out.println("존재하지 않는 계좌입니다.");
					}
				}
				else if (log==2) {
					System.out.println("안녕하세요. "+dbAcc2+"님");
					System.out.print("이체 할 계좌를 입력해주세요 : ");
					int yourAcc = scan.nextInt();
					if(yourAcc == dbAcc1) {
						System.out.print("이체할 금액 : ");
						int trans = scan.nextInt();
						if(trans > dbMoney2) {
							System.out.println("잔액 부족");
						}
						else {
							dbMoney2 -= trans;
							dbMoney1 += trans;
							System.out.println(dbAcc2+"님의 계좌에서 "+dbAcc1+"님의 계좌로 "+trans+"원 이체 완료되었습니다.");
							System.out.println(dbAcc2+"님의 남은 잔액은 : "+dbMoney2+"원 입니다.");
						}
					}
					else {
						System.out.println("존재하지 않는 계좌입니다.");
					}
				}
			}
			else if(sel == 6) { // 조회
				
				if(log == -1) {
					System.out.println("로그인 후 이용해주세요");
				}
				else if(log==1) {
					System.out.println("안녕하세요. "+dbAcc1+"님");
					System.out.println(dbAcc1+"님의 현재 잔액은 : "+dbMoney1+"원 입니다.");
				}
				else if(log==2) {
					System.out.println("안녕하세요. "+dbAcc2+"님");
					System.out.println(dbAcc2+"님의 현재 잔액은 : "+dbMoney2+"원 입니다.");
				}
			}
			else if(sel == 0) {
				run = false;
				System.out.println("프로그램 종료");
			}
		}
	}
}
