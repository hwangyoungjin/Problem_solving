package day1201;

import java.util.Scanner;

/*
 * # 타자연습 게임[1단계]
 * 1. 문제를 섞는다.(shuffle)
 * 2. 순서대로 문제를 출제하고, 문제를 다 맞추면 게임 종료
 * 예)
 * 문제 : mysql
 * 입력 : mydb
 * 문제 : mysql
 * 입력 : mysql	<--- 정답을 맞추면, 다음 문제 제시
 * 문제 : jsp
 */

public class day1205 {
	public static void main(String[] args) {

		String[] words = {"java", "mysql", "jsp", "spring"};
		suffle(words);
		int index =0;
		Scanner scan = new Scanner(System.in);
		while(index < words.length) {
			System.out.println("문제 : "+words[index]);
			System.out.print("입력 : ");
			String input = scan.next();
			if(words[index].equals(input)) {
				System.out.println("-----정답!-----");
				index++;
			}
			else {
				System.out.println("----틀렸습니다.-----");
			}
		}
		System.out.println("끝났습니다.");
	}
	static void suffle(String[] words) {
		for(int i = 0; i<1000; i++) {
			int su = (int)(Math.random()*words.length);
			String temp = words[su];
			words[su] = words[0];
			words[0] = temp;
		}
	}

}
