package day06;

import java.util.Scanner;

/*
 * # 미니마블
 * 1. 플레이어는 p1과 p2 2명이다.
 * 2. 번갈아가며 1~3 사이의 숫자를 입력해 이동한다.
 * 3. 이동하다가 다음 플레이어와 같은 위치에 놓이게 되면,
 *    상대 플레이어는 잡히게 되어 원점으로 되돌아간다.
 * 4. 먼저 3바퀴를 돌면 이긴다.
 *    
 *  [p2]1~3 입력 : 1
 *  1 2 3 4 5 6 7 8 
 *  0 1 0 0 0 0 0 0 
 *  0 0 0 2 0 0 0 0 
 *  
 *  [p1]1~3 입력 : 3
 *  [p1]이 p2를 잡았다!
 *  1 2 3 4 5 6 7 8 
 *  0 0 0 0 1 0 0 0 
 *  2 0 0 0 0 0 0 0 
 */
public class day0602 {
	static void positionOutput(int[] game, int[] p1, int[] p2) { //position output
		for(int i=0; i<game.length; i++) {
			System.out.print(game[i]+" ");
		}
		System.out.println();

		for(int i=0; i<p1.length; i++) {
			System.out.print(p1[i]+" ");
		}
		System.out.println();
		
		for(int i=0; i<p2.length; i++) {
			System.out.print(p2[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int[] game = {1, 2, 3, 4, 5, 6, 7, 8};
		int[] p1   = {0, 0, 0, 0, 0, 0, 0, 0};
		int[] p2   = {0, 0, 0, 0, 0, 0, 0, 0};
		
		int turn = 1; //1 is p1 turn, 2 is p2 turn 
		
		int idx1 = 0;	int idx2 = 0;
		p1[idx1] = 1;	p2[idx2] = 2;
		
		int p1count = 0; //p1 round
		int p2count = 0; //p2 round
		
		positionOutput(game,p1,p2);
		
		while(true) {
			if(p1count == 3) {
				System.out.println("p1 승리");
				break;
			}
			if(p2count == 3) {
				System.out.println("p2 승리");
				break;
			}
			int temp = 0;
			if(turn==1) { // p1 turn
				System.out.print("[p1] 현재 ["+(p1count+1)+"]바퀴째 (1~3 입력) : ");
				temp = scan.nextInt();
				p1[idx1] = 0;
				idx1 += temp;
				p1[idx1] = 1; // 위치 변경

				if(idx1 > 7) { //plus 1round
					idx1 = idx1%7;
					p1count++;
				}
				
				if(idx1 == idx2) { //p1 caught p2
					p2[idx2] = 0;
					idx2=0;
					p2[idx2] = 2;
					System.out.println();
					System.out.println("p1이 p2를 잡았다!");
				}
				turn=2;
				positionOutput(game,p1,p2);
			}
			else if(turn==2) { // p2 turn
				System.out.print("[p2] 현재 ["+(p2count+1)+"]바퀴째 (1~3 입력) : ");
				temp = scan.nextInt();
				p2[idx2] = 0;
				idx2 += temp;
				
				if(idx2 > 7) { // plus 1round
					idx2 = idx2%7;
					p2count++;
				}
				
				p2[idx2] = 2;
				
				if(idx1 == idx2) { //p2 caught p1
					p1[idx1] = 0;
					idx1=0;
					p1[idx1] = 1;
					System.out.println();
					System.out.println("p2가 p1을 잡았다!");
				}
				turn=1;
				positionOutput(game,p1,p2);
			}
		}
		
	}
}
