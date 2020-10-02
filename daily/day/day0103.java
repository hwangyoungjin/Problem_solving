package day01;

import java.util.Scanner;

public class day0103 {
	public static void main(String[] args) {
		//논리 연산자 OpEx08_문제
		int kor = 100;
		int eng = 87;
		int math = 41;
		float average = (kor+eng+math)/3f;
		if(average >= 60) {
			System.out.println("true");
		}
		if((kor)<=50 || eng <= 50 || math <=50) {
			System.out.println("false");
		}
		System.out.println();
		System.out.println();
		
		//문제2
		int height1 = 199;
		int weight1 = 199;
		int height2 = 200;
		int weight2 = 68;
		if(height1>=200 || weight1>=200 ) {
			System.out.println("true");	
		}
		if(height2>=200 || weight2>=200 ) {
			System.out.println("true");
		}
		System.out.println();
		
		// InputEx02_문제 1
//		Scanner scan = new Scanner(System.in);
//		System.out.print("숫자를 입력하세요 : ");
//		int num1 = scan.nextInt();
//		System.out.print("숫자를 입력하세요 : ");
//		int num2 = scan.nextInt();
//		int sum = num1+num2;
//		System.out.println("합 : "+ sum);
//		
		//문제 2
		Scanner scan = new Scanner(System.in);
//		System.out.print("숫자를 입력하세요 : ");
//		int su = scan.nextInt();
//		if(!(su%2 == 0)) {
//			System.out.println("su는 홀수 : true");
//		}
//		else
//			System.out.println("su는 짝수");
//		
//		System.out.println();
//		System.out.println();
		
		//문제 3
		System.out.print("성적를 입력하세요(1~100) : ");
		int grade = scan.nextInt();
		if(grade >= 60 && grade<=100) {
			System.out.println("true");
		}
		
		//
	}
}
