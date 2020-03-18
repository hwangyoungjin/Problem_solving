package day01;

import java.util.Scanner;

public class day0108 {
	public static void main(String[] args) {
		//유효성 검사
		Scanner scan = new Scanner(System.in);
		System.out.print("성적 입력 : ");
		int grade = scan.nextInt();
		if(grade >= 60 && grade<=100) {
			System.out.println(" 합 격 ");
		}
		else if(grade >=0 && grade<=60) {
			System.out.println(" 불합격 ");
		}
		else {
			System.out.println("성적을 잘못 입력 하셨습니다.");
		}
	}
}
