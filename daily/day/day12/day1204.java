package day1201;

import java.util.Scanner;

/*
 * # 끝말잇기 게임
 * 제시어 : 자전거
 * 입력 : 거미
 * 제시어 : 거미
 * 입력 : 미술
 * ...
 */

public class day1204 {
	public static void main(String[] args) {
		
		String start = "자전거";
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("제시어 : " + start);
			System.out.print("입력 : ");
			String input = scan.next();
			if(input.charAt(0) == start.charAt(start.length()-1)) {
				start = input;
			}
			else {
				System.out.println("다시 입력하세요");
			}
		}
	}
}