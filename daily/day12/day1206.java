package day1201;

import java.util.Scanner;

/*
 * # 타자연습 게임[2단계]
 * 1. 문제를 섞는다.(shuffle)
 * 2. 순서대로 문제를 출제하고, 문제를 다 맞추면 게임 종료
 * 3. 단 문제를 출제할 때, 단어의 랜덤한 위치 한 곳만 *로 출력
 * 예)
 * 문제 : mys*l
 * 입력 : mysql	<--- 정답을 맞추면, 다음 문제 제시
 * 문제 : *sp
 * 입력 : jsp
 * ...
 */

public class day1206 {
	public static void main(String[] args) {

		String[] words = {"java", "mysql", "jsp", "spring"};
		suffle(words);
		int index =0;
		Scanner scan = new Scanner(System.in);
		
		while(index < words.length) {
			
			//특정 한곳 *으로 표시
			int ran = (int)(Math.random()*words[index].length());
			String question = words[index].substring(0,ran)+"*"+words[index].substring(ran+1);
			System.out.println("문제 : "+question);
			
			
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
