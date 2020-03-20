package day06;

import java.util.Scanner;


public class day0601 {
	/* 
	 * # 틱택토
	 * === 틱택토 ===
	 * [X][X][O]
	 * [ ][O][ ]
	 * [ ][ ][ ]
	 * [p1]인덱스 입력 : 6
	 * === 틱택토 ===
	 * [X][X][O]
	 * [ ][O][ ]
	 * [O][ ][ ]
	 * [p1]승리
	 * 
	 */
	// 출력 

	
	// 출력 함수
	static void printGame (int[] game) { 
		System.out.println("====틱택톡====");
		int line = 0;
		for(int i=0; i<game.length; i++) {
			if(game[i]==0) { // 아직 입력안된 index
				System.out.print("[ ]");
			}
			else if(game[i]==1) { // p1이 선택한 index
				System.out.print("[X]");
			}
			else if(game[i]==2) { // p2가 선택한 index
				System.out.print("[O]");
			}
			line ++;
			if(line%3 ==0 && line != 0) {
				System.out.println();
			}
		}
	}
	
	// 승리했는지 판단
	static int winerChoice(int[] game, int player) {
		if(game[0] == player && game[1] == player && game[2] == player) { //세로
			if(player==1) {
				System.out.println("[p1]이 이겼습니다.");
			}
			else if(player==2) {
				System.out.println("[p2]가 이겼습니다.");
			}
			return 1;
		}
		else if(game[3] == player && game[4] == player && game[5] == player) { //세로
			if(player==1) {
				System.out.println("[p1]이 이겼습니다.");
			}
			else if(player==2) {
				System.out.println("[p2]가 이겼습니다.");
			}
			return 1;
		}
		else if(game[6] == player && game[7] == player && game[8] == player) { //세로
			if(player==1) {
				System.out.println("[p1]이 이겼습니다.");
			}
			else if(player==2) {
				System.out.println("[p2]가 이겼습니다.");
			}
			return 1;
		}
		else if(game[0] == player && game[3] == player && game[6] == player) { //가로
			if(player==1) {
				System.out.println("[p1]이 이겼습니다.");
			}
			else if(player==2) {
				System.out.println("[p2]가 이겼습니다.");
			}
			return 1;
		}
		else if(game[1] == player && game[4] == player && game[7] == player) { //가로
			if(player==1) {
				System.out.println("[p1]이 이겼습니다.");
			}
			else if(player==2) {
				System.out.println("[p2]가 이겼습니다.");
			}
			return 1;
		}
		else if(game[2] == player && game[5] == player && game[8] == player) { //가로
			if(player==1) {
				System.out.println("[p1]이 이겼습니다.");
			}
			else if(player==2) {
				System.out.println("[p2]가 이겼습니다.");
			}
			return 1;
		}
		else if(game[0] == player && game[4] == player && game[8] == player) { // 대각선
			if(player==1) {
				System.out.println("[p1]이 이겼습니다.");
			}
			else if(player==2) {
				System.out.println("[p2]가 이겼습니다.");
			}
			return 1;
		}
		else if(game[2] == player && game[4] == player && game[6] == player) { // 대각선
			if(player==1) {
				System.out.println("[p1]이 이겼습니다.");
			}
			else if(player==2) {
				System.out.println("[p2]가 이겼습니다.");
			}
			return 1;
		}
		
		//비겼을경우
		for(int i=0; i<game.length; i++) {
			if(game[i] == 0) {// 0이 하나라도 있다면 아직 게임 끝나지X
				return 0;
			}
		}
			// 1이나 2로 모두 가득 찼다면 P1,P2 비겼다
		return 2;
	}
	public static void main(String[] args) {
		int[] game = new int[9]; //p1(1)이면 x출력, p2(2)이면 'o'
		Scanner scan = new Scanner(System.in);
		int index = 0; // 값넣을 index
		int turn = 1; // 1이면 p1, 2이면 p2
		
		while(true) {
			if(turn == 1 ) { // p1 차례
				System.out.print("[p1] 인덱스 입력 : " );
				index = scan.nextInt();
				if(game[index] != 0) {
					System.out.println("이미 선택되었습니다. 다시 선택하세요");
					continue;
				}
				game[index] = 1;
				printGame(game); // 입력후 적용된 화면 출력
				if(winerChoice(game, turn)==1) {
					break;
				}
				else if (winerChoice(game, turn)==2) {
					System.out.println("비겼습니다.");
					break;
				}
				turn = 2;
				//누가이겼는지 판달할 함수
			}
			else if(turn == 2) { // p2 차례
				System.out.print("[p2] 인덱스 입력 : ");
				index = scan.nextInt();
				if(game[index] != 0) {
					System.out.println("이미 선택되었습니다. 다시 선택하세요");
					continue;
				}
				game[index] = 2;
				printGame(game); // 입력후 적용된 화면 출력
				if(winerChoice(game, turn)==1) {
					break;
				}
				else if (winerChoice(game, turn)==2) {
					System.out.println("비겼습니다.");
					break;
				}
				turn = 1;
				//누가이겼는지 판달할 함수
			}
		}
	}
}
