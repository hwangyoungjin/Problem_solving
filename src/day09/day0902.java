package day09;

public class day0902 {
	/*
	 * # 문자열[정렬]
	 * 1. compareTo() 메서드
	 * 2. 2개의 문자열을 비교해 int형 값을 반환하는 메서드
	 * 3. A.compareTo(B)
	 * 4. 결과
	 * 		A와 B가 같으면						0
	 *      A가 B보다 사전적으로 순서가 앞이면		음수
	 *      A보다 B가 사전적으로 순서가 앞이면		양수
	 *      
	 */

	public static void main(String[] args) {

		String str1 = "가";
		String str2 = "나";
		String str3 = "가";
		
		int rs1 = str1.compareTo(str2);
		System.out.println(rs1);			// 음수
		
		int rs2 = str2.compareTo(str1);
		System.out.println(rs2);			// 양수
		
		int rs3 = str1.compareTo(str3);
		System.out.println(rs3);			// 0
		
		// 문제 ) 사전 순으로 이름 정렬
		String[] names = {"홍길동", "김유신", "마동석", "자바킹", "서동요"};
		
		
		//insert Sorting
		for(int i=0; i<names.length; i++) {
			for(int j=i+1; j<names.length; j++) {
				int check = names[i].compareTo(names[j]);
				if(check > 0 ) { // 사전적으로 names[j]가 더 순서가 앞
					String temp = names[i];
					names[i] = names[j];
					names[j] = temp;
				}
			}
		}
		
		//print
		for(int i=0; i<names.length; i++) {
			System.out.println((i+1)+"번 째 단어 : "+names[i]);
		}
		
	}
}
