package day05;

import java.util.Scanner;

public class day0502 {
	/*
	 * # 기억력 게임
	 * 1. 같은 숫자의 위치를 2개 랜덤 입력해 정답을 맞추는 게임이다.
	 * 2. 정답을 맞추면 back에 해당 숫자를 저장해,
	 *    back에 모든 수가 채워지면 게임은 종료된다.
	 * 예)
	 * front = [1, 1, 2, 2, 3, 3, 4, 4, 5, 5]
	 * back  = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
	 * 첫 번쨰 index 입력1 : 0
	 * 두 번쨰 index 입력2 : 1
	 * 
	 * front = [1, 1, 2, 2, 3, 3, 4, 4, 5, 5]
	 * back  = [1, 1, 0, 0, 0, 0, 0, 0, 0, 0]
	 */
	
	//화면지우기
	public static void clearScreen() {
	    for (int i = 0; i < 80; i++)
	      System.out.println("");
	  }
	
	//front배열 3초 오픈
	public static void arrayOpen() {
		System.out.println("3초 동안 공개");
		for(int j=0; j<front.length; j++) {
			System.out.print(front[j] + " ");
		}
		System.out.println();
		
		
		try { //delay 3초

			Thread.sleep(3000);

			} catch (InterruptedException e) {

			System.out.println(e.getMessage());    //sleep 메소드가 발생시키는 InterruptedException

			}

		
		clearScreen(); // 화면클리어
	}
	static int[] front = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
	
	public static void main(String[] args) {
		int[] back = {0,0,0,0,0,0,0,0,0,0};
		Scanner scan = new Scanner(System.in);
		
		// 셔플(shuffle)
		int i = 0;
		while(i < 1000) {
			int r = (int)(Math.random()*10);
			int temp = front[0];
			front[0] = front[r];
			front[r] = temp;
			
			i += 1;
		}
		arrayOpen();
		
		while(true) {
			int count=0; // back의 0의 개수
			for(int j=0; j<back.length; j++ ) {
				if(back[j] == 0) {
					count++;
				}
			}
			if(count == 0) {
				System.exit(0);
			}
			System.out.print("첫 번쨰 index 입력 (다시보고 싶으면 10) : ");
			int index1 = scan.nextInt();
			if(index1==10) {
				System.out.println();
				arrayOpen();
				continue;
			}
			System.out.print("두 번쨰 index 입력 (다시보고 싶으면 10)  : ");
			int index2 = scan.nextInt();
			if(index2==10) {
				System.out.println();
				arrayOpen();
				continue;
			}
			
			if(front[index1]==front[index2]) {
				back[index1] = front[index1];
				back[index2] = front[index1];
				System.out.println("정답");
			}
			else {System.out.println("떙");}
			
			for(int j=0; j<back.length; j++) {
				System.out.print(back[j] + " ");
			}
			System.out.println();
		}
	}
}
