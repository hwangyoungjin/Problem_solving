package day02;

import java.util.Scanner;

public class day0204 {
	public static void main(String[] args) {
		int su = (int)(Math.random()*100+1);
		Scanner scan = new Scanner(System.in);
		System.out.print("홀/짝 선택하기 (1: 홀수 , 2:짝수) : ");
		int choice = scan.nextInt();
		if(choice == su%2) { // su가 홀수 이면 su%2 = 1
			System.out.println("정답입니다.");
		}
		else if(choice == su%2 + 2) { // su가 짝수이면 su%2+2 = 2 
			System.out.println("정답입니다.");
		}
		else {
			System.out.println("틀렸습니다. su : "+su);
		}
		
	}
}
