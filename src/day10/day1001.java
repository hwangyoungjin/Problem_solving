package day10;

import java.util.Scanner;

/*
 * # 2차원배열[삭제]
 * . 이름과 번호를 입력받아 삭제하기
 * 예)
 * 입력 : 철수	1
 * 삭제 : 김밥
 * 
 * 입력 : 철수 2
 * 삭제 : 바나나
 */

public class day1001 {
	public static void main(String[] args) {

		String[][] jang = {
			{"철수", "소고기"},
			{"철수", "김밥"},
			{"영희", "김치"},
			{"철수", "바나나"},
			{"철수", "새우깡"},
			{"영희", "오징어"},
			{"영희", "맛밤"}
		};
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("삭제할 이름을 입력해주세요 : ");
			String name = scan.next();
			int count = 0; // 해당 이름의 상품 개수 체크
			for(int i=0; i<jang.length; i++) {
				if(name.equals(jang[i][0])) { // 입력한 이름과 같은 이름이 있다면
					count ++;
					System.out.println(jang[i][0]+"님의 "+count+"번째 상품 : "+jang[i][1]); // 해당 이름이 담은 상품 출력	
				}
			}
				
			System.out.println("삭제할 번호를 입력해주세요 : ");
			int num = scan.nextInt();
			if(num <1 && num > count) {
				System.out.println("번호 오류");
				continue;
			}
			
			// 이름과 번호 찾은 상태 -> 해당이름과 번호 위치 찾기
			int check=0;
			int delIdx  = 0; //삭제할 index
			
			
		Loop1 : for(int i=0; i<jang.length; i++) {
				if(name.equals(jang[i][0])){
					check += 1; // 해당 이름일때 
					if(check==num) { // 이때 삭제할 번호 num과 같다면
						delIdx = i; // 찾았을때 해당 row index
						break Loop1;
					}
				}
			}
			
			// 복사
			String[][] temp = jang;
			jang = new String[temp.length-1][2];
			
			int j=0;
			for(int i=0; i<temp.length; i++) {
				if(i != delIdx) { // 삭제할 index가 아닌경우만 복사
					jang[j] = temp[i];
					j++;
				}
			}
			
			/*
			 * for(int i=0; i<delIdx; i++) { for(int j=0; j<2; j++) { jang[i][j] =
			 * temp[i][j]; } }
			 * 
			 * for(int i=delIdx+1 ; i<temp.length; i++) { for(int j=0; j<2; j++) {
			 * jang[i-1][j] = temp[i][j]; } }
			 */
			
			System.out.println(temp[delIdx][0]+"님의 "+ temp[delIdx][1]+" 상품 삭제 완료");
			temp = null;
		}
	}
}