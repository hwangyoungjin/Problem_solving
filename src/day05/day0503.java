package day05;

import java.util.Scanner;

public class day0503 {
	/*
	 * # 1 to 50[1단계] : 1 to 4
	 * 1. arr배열에 1~4 사이의 숫자를 중복없이 저장한다.
	 * 2. 사용자는 1부터 순서대로 해당 위치 값을 입력한다.
	 * 3. 정답을 맞추면 해당 값은 9로 변경되어 모든 값이 9가 되면 게임은 종료된다.
	 * 예)
	 * 4 2 3 1
	 * 입력 : 3 // index 3의 값이 1이므로 통과
	 * 4 2 3 9
	 * 입력 : 1 // index 3의 값이 2이므로 통과
	 * 4 9 3 9
	 * ...
	 */
	public static void main(String[] args) {
		int[] arr = new int[4];
		int[] check = new int[4]; 
		//arr와 index가 같으며 arr배열  값이 결정된 경우 1 , 안된경우 0
		
		int index =0;
		Scanner scan = new Scanner(System.in);
		
		//arr배열에 1~4 사이의 숫자를 중복없이 저장
		while(index<4) {
			int r=(int)(Math.random()*4); // index-ranndom
			if(check[r]==0) { // 값이 0 이면 해당 위치의 arr값 설정 안됨
				check[r]= 1; 
				arr[index] = r+1; // 값은 1~4이므로
				index += 1; //값이 저장되면 arr의 index 증가
			}
		}
		
		//중복없는지 확인
		
		int sol =0;
		int count = 0;
		while(count<4) { // 4개 맞추면 반복문 탈출
			
			for(int k=0; k<arr.length; k++) {
				System.out.print(arr[k]+" ");
			}
			System.out.println();
			System.out.println();
			System.out.print((sol+1)+"값 index 입력 : ");
			int ind = scan.nextInt();
			
			if(arr[ind]==(sol+1)) { //맞추면 sol값,count값 증가
				arr[ind] = 9;
				count +=1;
				sol +=1; 
			}
		}
		
		System.out.println(java.util.Arrays.toString(arr));
		
	}
}
