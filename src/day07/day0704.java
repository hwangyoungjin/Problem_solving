package day07;

import java.util.Scanner;

/*
 * # 최대값 구하기[3단계]
 * 1. 가장 큰 값을 찾아 입력한다.
 * 2. 정답이면 해당 값을 0으로 변경한다.
 * 3. arr배열의 모든 값이 0으로 변경되면 프로그램은 종료된다.
 * 예)
 * 11, 87, 42, 100, 24
 * 입력 : 100
 * 
 * 11, 87, 42, 0, 24
 * 입력 : 87
 * 
 * 11, 0, 42, 0, 24
 */

public class day0704 {
	public static void main(String[] args) {
		int[] arr = {11, 87, 42, 100, 24};
		Scanner scan = new Scanner(System.in);
	
		while(true) {
			int check=0;
			System.out.println(java.util.Arrays.toString(arr));
			System.out.print("입력 : ");
			int su = scan.nextInt();
			for(int i=0; i<arr.length; i++) {
				if(arr[i]==su) {
					arr[i] = 0;
				}
				if(arr[i]==0) {
					check++;
				}
			}
			if(check==5) {
				System.out.println();
				System.out.println("찾기 완료");
				break;
			}
			
			
		}
	}
}
