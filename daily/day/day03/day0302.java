package day03;

import java.util.Scanner;

public class day0302 { //Up & Down 게임(2단계)
	public static void main(String[] args) {
		int score = 100;
		Scanner scan = new Scanner(System.in);
		int su = (int)(Math.random()*100+1);
		while(true) {
			System.out.print("[범위 : 1~100] 정답 : ");
			int choice = scan.nextInt();
			if(su < choice) {
				score -= 5;
				System.out.println("Down!");
			}
			else if(su > choice) {
				score -= 5;
				System.out.println("Up!");
			}
			else if(su==choice) {
				System.out.println("정답입니다. 점수 : "+score);
				System.exit(0);
			}
		}
	}
}
