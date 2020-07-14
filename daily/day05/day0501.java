package day05;

import java.util.Scanner;

public class day0501 {
	/*
	 * # 숫자이동[1단계]
	 * 1. 숫자2는 캐릭터이다.
	 * 2. 숫자1을 입력하면, 캐릭터가 왼쪽으로
	 * 	    숫자2를 입력하면, 캐릭터가 오른쪽으로 이동한다.
	 * 3. 단, 좌우 끝에 도달했을 때, 예외처리를 해야한다.
	 */
	public static void main(String[] args) {
		int[] game = {0, 0, 2, 0, 0, 0, 0}; // 2는 캐릭터 , 캐릭터위치 설정
		int player = 0; // 위치 0~6
		for(int i=0; i<game.length; i++) {
			if(game[i] == 2) { // 플레이어 위치(index)
				player = i; //캐릭터위치 index=2
			}
		}
		Scanner scan = new Scanner(System.in);
		do{
			for(int i=0; i<game.length; i++) { // 현재 위치 출력
				if(game[i] == 2) {
					System.out.print("옷 ");
				}
				else {
					System.out.print(game[i]+" ");
				}
			}
			System.out.println();
			System.out.println("숫자 1 : 왼쪽 , 숫자2 : 오른쪽 ");
			System.out.print("입력 : ");
			int move = scan.nextInt();
			if(move==1) { // 왼쪽이동
				if(player -1 != -1) {
					game[player] = 0; // 이전 위치에 없으므로 0
					game[player-1] = 2; //왼쪽으로 위치이동
					player -= 1; // 플레이어 위치변경
				}
			}
			else if(move==2) { // 오른쪽이동
				if(player +1 != 7 ) {
					game[player+1] = 2; //오른쪽으로 위치이동
					game[player] = 0; // 이전위치 없으므로 0
					player += 1; //플레이어 위치변경					
				}
			}
		}while(true);
	}
}
