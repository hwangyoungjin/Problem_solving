package day02;

import java.util.Scanner;

public class day0212 {
	public static void main(String[] args) {
		int[][] dan = new int[10][10]; // index 0은 사용하지x
		for(int i=1; i<dan.length; i++) {
			for(int j=1; j<dan[i].length; j++) {
				dan[i][j]=(i)*(j); // i, j 모두 1부터 9까지 돌린다.
			}
		}
		int i = 1;
		int sum =0;
		Scanner scan = new Scanner(System.in);
		while(i <= 5) { // su는 1부터~9까지
			int su1 = (int)(Math.random()*9+1);
			int su2 = (int)(Math.random()*9+1);
			System.out.println(su1+"*"+su2+" =  ? ");
			System.out.print("정답 : ");
			int sol = scan.nextInt();
			if(sol == dan[su1][su2]) {
				sum+=20;
			}
			i++;
		}
		System.out.println("성적 : "+ sum);
	}
}
