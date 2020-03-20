package day06;

import java.util.Scanner;

/*
 * # 배열 컨트롤러[1단계] : 최종
 * 1) 추가
 * 2) 삭제
 * 3) 삽입
 */

public class day0603 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int[] arr = {10,20,0,0,0};
		int cnt = 3; // arr[] index+1	
		while(true) {
			System.out.println(java.util.Arrays.toString(arr));
			
			System.out.println("[1]추가");
			System.out.println("[2]삭제");
			System.out.println("[3]삽입");
			System.out.println("[0]종료");

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if(sel == 1 ) {
				if(cnt == 6) {
					System.out.println("더이상 추가 할 수 없습니다. 숫자를 삽입해서 변경하세요");
					continue;
				}
				System.out.print("추가 할 값 입력 : ");
				int data = scan.nextInt();
				arr[cnt-1] = data;
				cnt++;
			}
			
			else if(sel==2) {
				System.out.print("삭제할 위치(1,2,3,4,5) 입력 : ");
				int idx = scan.nextInt();
				arr[idx-1] = 0;
			}
			
			else if(sel==3) {
				System.out.print("삽입할 위치(1,2,3,4,5) 입력 : ");
				int idx = scan.nextInt();
				
				System.out.print("삽입할 값 입력 : ");
				int data = scan.nextInt();
				arr[idx-1] = data;

				
			}
			else if(sel==0) {
				System.out.println();
				System.out.println("==프로그램 종료==");
				break;
			}		
		}
	}
}
