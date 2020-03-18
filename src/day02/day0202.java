package day02;

import java.util.Scanner;

public class day0202 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] su = new int[3];
		int max = 0;
		for(int i=0; i<su.length; i++) {
			System.out.print("숫자를 입력하세요 : ");
			su[i] = scan.nextInt();			
		}
		for(int i=0; i<su.length; i++) {
			if(max <= su[i]) {
				max = su[i];
			}
		}
		System.out.println("최댓값 : " + max);
		
	}
}
