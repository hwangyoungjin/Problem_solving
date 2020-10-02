package day02;

import java.util.Scanner;

public class day0205 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[][] dan = new int[9][9];
		for(int i=0; i<dan.length; i++) {
			for(int j=0; j<dan[i].length; j++) {
				dan[i][j]=i*j;
			}
		}
		int su1 ,su2;
		su1=(int)(Math.random()*9+1);
		su2=(int)(Math.random()*9+1);
		System.out.println(su1+" x "+ su2 +" = ? ");
		int sol = scan.nextInt();
		if(sol == dan[su1][su2]) {
			System.out.println("정답입니다.");
		}
		else {
			System.out.println("틀렸습니다.");
		}
	}
}
