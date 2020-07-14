package day08;

import java.util.Random;
import java.util.Scanner;

public class day0801 {
	/* 
	 * # 1 to 50[3단계] : 1 to 18
	 * 1. 구글에서 1 to 50 이라고 검색한다.
	 * 2. 1 to 50 순발력 게임을 선택해 게임을 실습해본다.
	 * 3. 위 게임을 숫자범위를 좁혀 1 to 18로 직접 구현한다.
	 * 4. 숫자 1~9는 front 배열에 저장하고,
	 *    숫자 10~18은 back 배열에 저장한다.
	 */

	//22분 시작
	/*
	 * public static void main(String[] args) {
	 * 
	 * final int SIZE = 9; Scanner scan = new Scanner(System.in); int[] front = new
	 * int[SIZE]; int[] back = new int[SIZE]; boolean anser = false; int score = 0;
	 * int[] checkRand = new int[18];
	 * 
	 * //checkRan init for(int i=0; i<18; i++) { checkRand[i] = 0; }
	 * 
	 * int ch=0; while(ch<18) { int ran = (int)Math.random()*18+1;
	 * System.out.print("ran : "+ ran);
	 * 
	 * if(ch<9 && checkRand[ran] == 0) { front[ch] = ran; checkRand[ran] = 1; ch++;
	 * } else if(checkRand[ran] == 0) { back[ch-9] = ch+1; checkRand[ran] = 1; ch++;
	 * } }
	 * 
	 * int check = 1; while(check<19) {
	 * System.out.println("=========1 to 18===========");
	 * System.out.println("===========index============"); for(int i=0; i<18; i++) {
	 * System.out.print(i+"\t"); } System.out.println(); for(int i=0; i<9; i++) {
	 * System.out.print(front[i]+"\t"); } for(int i=0; i<9; i++) {
	 * System.out.print(back[i]+"\t"); } System.out.println();
	 * System.out.println(check + "인  index 입력"); int su = scan.nextInt(); if(su ==
	 * check) { check++; } }
	 * 
	 * }
	 */
	
		public static void main(String[] args) {

			Scanner scan = new Scanner(System.in);
			Random ran = new Random();
			
			final int SIZE = 9;
			
			int[] front = new int[SIZE];
			int[] back  = new int[SIZE];

			for(int i=0; i<SIZE; i++) { // 배열 초기화
				front[i] = i + 1;
				back[i] = SIZE + (i+1);
			}
			
			for(int i=0; i<1000; i++) { // 섞기
				int r = ran. nextInt(SIZE);
				int temp = front[0];
				front[0] = front[r];
				front[r] = temp;
				
				r = ran.nextInt(SIZE);
				temp = back[0];
				back[0] = back[r];
				back[r] = temp;
			}
			
			int num = 1;
			while(true) {
				
				int answer = 0;
				for(int i=0; i<SIZE; i++) { 
					if(front[i] == num) { //front에서 num 찾아서 index값 anser에 저장
						answer = i;
					}
				}
				System.out.println(num + "[" + answer + "]");
				
				for(int i=0; i<SIZE; i++) {  
					if(front[i] == 0) { // 0 이면 더이상 출력 할 값없으므로 공란으로 
						System.out.print("\t");
					}else { // 0 이 아니면 출력
						System.out.print(front[i] + "\t");
					}
					if(i % 3 == 2) { //한줄 내리기
						System.out.println("\n");
					}
				}
				
				System.out.print("[" + num + "]의 인덱스 입력 : ");
				int idx = scan.nextInt();
				
				if(front[idx] == num) { //맞춘경우 
					if(1 <= num && num <= SIZE) { // back에서 가져올 수 있는 범위 1~9이면 가져오기 
						front[idx] = back[idx];
					}else { // 9 넘으면 가져올 수 없으므로 0으로
						front[idx] = 0;
					}
					
					num += 1; // 찾아야 하는 수 ++
				}
				
				if(num == 19) { // 다찾으면 종료
					break;
				}
			}
			
		}
}
