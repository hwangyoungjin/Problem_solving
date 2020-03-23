package day07;

import java.util.Scanner;

/*
 * # 숫자이동[2단계]
 * 1. 숫자2는 캐릭터이다.
 * 2. 숫자1을 입력하면, 캐릭터가 왼쪽으로
 * 	    숫자2를 입력하면, 캐릭터가 오른쪽으로 이동한다.
 * 3. 단, 좌우 끝에 도달했을 때, 예외처리를 해야한다.
 * 4. 숫자 1은 벽이다. 벽을 만나면 이동할 수 없다.
 * 5. 단, 숫자3을 입력하면, 벽을 격파할 수 있다.
 */

public class day0706 {
	public static void main(String[] args) {
		int[] game = {0, 0, 1, 0, 2, 0, 0, 1, 0};
		int wall1 = 2, wall2 = 7;
		int player = 4;
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println(java.util.Arrays.toString(game));
			System.out.print("(1-왼쪽 , 2-오른쪽, 3-격파) 입력 :");
			int su = scan.nextInt();
			if(su==1) { // 왼쪽
 				if(game[wall1+1]==game[player]) {
					System.out.println("벽이므로 갈 수 없습니다.");
					continue;
				}
				game[player] = 0;
				player--;
				game[player] = 2;
			
			}
			else if(su==2) { //오른쪽
				if(game[wall2-1]==game[player]) {
					System.out.println("벽이므로 갈 수 없습니다.");
					continue;
				}
				game[player] = 0;
				player++;
				game[player] = 2;
			}
			else if(su==3) { 
				if(game[wall1+1]==game[player]) { //왼쪽에 벽 존재
					game[wall1] = game[player];
					game[player] = 0;
					player--;
					if(player == 0) {
						System.out.println(java.util.Arrays.toString(game));
						break;
					}
					wall1--;
					game[wall1] = 1;
					
				}
				else if(game[wall2-1]==game[player]) { //오른쪽에 벽 존재
					game[wall2] = game[player];
					game[player] = 0;
					player++;
					if(player == game.length-1) {
						System.out.println(java.util.Arrays.toString(game));
						break;
					}
					wall2++;
					game[wall2] = 1;
				}
			}
		}
	}
}
