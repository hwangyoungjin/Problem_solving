package day08;

import java.util.Scanner;

public class day0803 {
	/*
	 * # 배열 컨트롤러[2단계] : 벡터(Vector)
	 * 1. 추가
	 * . 값을 입력받아 순차적으로 추가
	 * 2. 삭제(인덱스)
	 * . 인덱스를 입력받아 해당 위치의 값 삭제
	 * 3. 삭제(값) 
	 * . 값을 입력받아 삭제
	 * . 없는 값 입력 시 예외처리
	 * 4. 삽입
	 * . 인덱스와 값을 입력받아 삽입
	 */
	
	//21분 시작
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int[] score = null;
		int count = 0; // 현재 존재하는 값의 개수
		
		while(true) {
			
			if(count>0) {
				for(int i=0; i<count; i++) {
					System.out.print(score[i]+"  ");
				}
			}
			System.out.println();
			System.out.println("[벡터 컨트롤러]");
			System.out.println("[1]추가");
			System.out.println("[2]삭제(인덱스)");
			System.out.println("[3]삭제(값)");
			System.out.println("[4]삽입");
			System.out.println("[0]종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			int[] temp = null;
			if(sel == 1) { // 추가
				if(count == 0) { // 맨처음
					score = new int[count+1];
				}

				else if(count > 0) {
					temp = score;
					score = new int[count+1]; 
					
					for(int i=0; i<count; i++ ) { // 이전 값 복사
						score[i] = temp[i];
					}
					
					temp = null;
				}
				System.out.print("추가 할 값 입력 : ");
				int su = scan.nextInt();
				score[count] = su;
				count ++;
				
				
			}
			else if(sel == 2) { // 삭제 (인덱스)
				System.out.print("삭제할 인덱스 0 부터  "+ (count-1)+" 까지 index 입력 : ");
				int delIdx = scan.nextInt();
				if(delIdx < 0 || delIdx > count) {
					System.out.println("index 잘못 입력");
				}
				else {
					
					if(delIdx == 0) { // 뒷 부분 복사
						temp = score;
						score = new int[count-1];
						
						for(int i=1; i<count; i++) {
							score[i-1] = temp[i];
						}
					}
					else { // delIdx 만 빼고 새로 복사
						temp = score;
						score = new int[count-1];
						
						for(int i=0; i<delIdx; i++) {
							score[i] = temp[i];
						}
						for(int i=delIdx+1; i<count; i++){
							score[i-1] = temp[i];
						}
						temp = null;
					}
					count--;
				}
			}

			else if(sel == 3) {
				System.out.print("삭제할 값 입력 : ");
				int delVal = scan.nextInt();
				int check = -1; 
				for(int i=0; i<count; i++) {
					if (score[i] == delVal) { // 삭제할 값이 존재한다면
						temp = score;
						score = new int[count-1]; 
						
						for(int k=0; k<i; k++) { // 삭제 할 인덱스 전까지 복사
							score[k] = temp[k];
						}
						for(int k=i+1; k<count; k++){// 삭제 할 인덱스 이후 부터 마지막까지 복사
							score[k-1] = temp[k];
						}
						temp = null;
						count--;
						check = 1;
						System.out.println(delVal + "값 삭제 완료");
					}
				}
				if(check<0) {
					System.out.println("일치하는 값이 없습니다.");
				}
				
			}
			else if(sel == 4) { // 삽입
				System.out.print("삽입할 인덱스 0 부터  "+ (count-1) +" 까지 index 입력 : ");
				int insertIdx = scan.nextInt();
		
				System.out.print("삽입할 data 입력 : ");
				int insertData = scan.nextInt();
		
				if(insertIdx < 0 || insertIdx > count) {
					System.out.println("index 잘못 입력");
				}
				else {
					
					if(insertIdx == 0) { // 뒷 부분 복사
						temp = score;
						score = new int[count+1];
						score[0] = insertData;
						for(int i=0; i<count; i++) { // 1부터 마지막까지 복사
							score[i+1] = temp[i];
						}
					}
					else { // 1이상 index
						temp = score;
						score = new int[count+1];
						score[insertIdx] = insertData; 
						for(int i=0; i<insertIdx; i++) {
							score[i] = temp[i];
						}
						for(int i=insertIdx; i<count; i++){
							score[i+1] = temp[i];
						}
						temp = null;
					}
					count++;
				}
			}
			else if(sel == 0) { // 종료
				break;
			}
			
		}
		
	}
}
