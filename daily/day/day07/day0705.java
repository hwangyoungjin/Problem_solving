package day07;

import java.util.Scanner;

/*
 * # 1 to 50[2단계] : 1 to 9
 * 1. arr배열에 1~9 사이의 숫자를 저장한다.
 * 2. shuffle을 통해 숫자를 섞는다.
 * 3. 사용자는 1부터 순서대로 해당 위치 값을 입력한다.
 * 4. 정답을 맞추면 해당 값은 0으로 변경되어 모든 값이 0이되면 게임은 종료된다.
 */

public class day0705 {
	static void shuffle(int[] arr) {
		for(int i=0; i<20; i++) { //20번이면 충분
			int r = (int)(Math.random()*9);
			int tem = arr[r];
			arr[r] = arr[0];
			arr[0] = tem;
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr = new int[9];
		for(int i=1; i<=arr.length; i++) {
			arr[i-1]=i;
		}
		shuffle(arr);
		
		int cnt = 1;
		while(cnt<10) {
			System.out.println(java.util.Arrays.toString(arr));
			System.out.print(cnt+" 위치값(1~9) 입력 : ");
			int su = scan.nextInt();
			if(arr[su-1]==cnt) {
				System.out.println("정답");
				cnt++;
			}
			else {
				System.out.println("틀렸습니다.");
			}
		}
		System.out.println();
		System.out.println("모두 맞췄습니다.");
	}
}
