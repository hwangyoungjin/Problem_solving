package day04;

import java.util.Scanner;

public class day0401 { // 랜덤학생 
	/*
	 * # 랜덤학생
	 * 1. 10회 반복을 한다.
	 * 2. 1~100 사이의 랜덤 숫자를 저장한다.(학생의 성적)
	 * 3. 성적이 60점 이상이면 합격생이다.
	 * ---------------------------------------
	 * . 전교생(10명)의 총점과 평균을 출력한다.
	 * . 합격자 수를 출력한다.
	 * . 1등 학생의 번호와 성적을 출력한다.
	 */
	
	public static void main(String[] args) {
		int su =0; //합격자 수 
		int[] score = new int[10];
		int sum =0;
		int count =0; // 합격자 수
		int x=0; // 가장 높은 점수의 인덱스 값
		int max=0; //가장 높은점수
		Scanner scan = new Scanner(System.in);
		for(int i=0; i<10; i++) {
			score[i] = (int)(Math.random()*100+1);
			sum += score[i];
			if(score[i] >= 60) {
				count++;
			}
			//가장 높은 점수의 i값
			if(score[i] > max) { 
				max = score[i];
				x=i;
			}
		}
		float average = sum/10f;
		System.out.println(java.util.Arrays.toString(score));
		System.out.printf("평균 점수 : %.2f", average);
		System.out.println();
		System.out.println("합격자 수 : "+count);
		System.out.println("1등 학생 - 번호 : "+(x+1)+", 점수 : "+score[x]);
	}
}
