package day07;

import java.util.Scanner;

/*
 * # EXIT 게임
 * 1. game배열에서 exit변수와 값이 같은 위치를 입력한다.
 * 2. 정답을 맞추면 exit변수는 1증가한다.
 * 3. exit변수의 값이 16이되면 게임은 종료된다.
 */

public class day0707 {
	public static void main(String[] args) {
		int exit = 10;
		
		int[] game = {11, 15, 10, 14, 12, 13};

		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println(java.util.Arrays.toString(game));
			System.out.println();
			System.out.print(exit+"와 같은 위치(1~6) 입력 :  ");
			int index = scan.nextInt();
			if(exit == game[index-1]) {
				exit++;
			}
			if(exit == 16) {
				System.exit(0);
			}
		}
	}
}
