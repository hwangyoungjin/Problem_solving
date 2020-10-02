package day10;


/*
* # 2차원배열[정렬]
* 영희 : 감
* 영희 : 김밥
* 영희 : 사과
* 철수 : 김밥
* 철수 : 사과
* 
* * # 문자열[정렬]
 * 1. compareTo() 메서드
 * 2. 2개의 문자열을 비교해 int형 값을 반환하는 메서드
 * 3. A.compareTo(B)
 * 4. 결과
 * 		A와 B가 같으면					0
 *      A가 B보다 사전적으로 순서가 앞이면		음수
 *      A보다 B가 사전적으로 순서가 앞이면		양수
*/

public class day1002 {
	public static void main(String[] args) {

		int jangCount = 5;
		String[][] jang = {
			{"철수", "김밥"},
			{"영희", "감"},
			{"철수", "사과"},
			{"영희", "사과"},
			{"영희", "김밥"},
			{"철수", "호두"},
			{"영희", "자두"},
			{"철수", "감"}
			
		};
		
		for(int i=0; i<jang.length; i++) {
			System.out.println(jang[i][0] + " : " + jang[i][1]);
		}
		
		//2 차원 배열 정렬 - SelectSort
		//이름 정렬
		for(int i=0; i<jang.length; i++) {
			for(int j=i+1; j<jang.length; j++) {
				if(jang[i][0].compareTo(jang[j][0])>0){ // 뒤가 앞보다 사전적으로 앞이면 
					String[] temp = jang[i];
					jang[i] = jang[j];
					jang[j] = temp;
				}
			}
		}
		
		System.out.println();
		System.out.println("이름 SelectSort 후 -----------------");
		for(int i=0; i<jang.length; i++) {
			System.out.println(jang[i][0] + " : " + jang[i][1]);
		}
		
		//상품 정렬
		String checkStr = jang[0][0]; // 다음이름과 이전이름 바뀌는 순간 교체
		int count=0; // 상품 정렬할 개수 체크
		
		for(int i=0; i<jang.length; i++) {
			if(!checkStr.equals(jang[i][0]) || i+1 == jang.length) { // 기존에 있던 name과 다르거나 마지막 length라면
				checkStr = jang[i][0];
				//sorting
				if(i+1 == jang.length) {
					i++;
				}
				for(int k=count; k<i; k++) {
					for(int j=k+1; j<i; j++) {
						if(jang[k][1].compareTo(jang[j][1])>0){ // 뒤가 앞보다 사전적으로 앞이면 
							String temp = jang[k][1];
							jang[k][1] = jang[j][1];
							jang[j][1] = temp;
						}
					}
				}
				count = i;
			}
		}
		
		System.out.println();
		System.out.println("상품 SelectSort 후 -----------------");
		for(int i=0; i<jang.length; i++) {
			System.out.println(jang[i][0] + " : " + jang[i][1]);
		}
		
	}
}
