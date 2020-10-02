package day1201;


//# 문자열 2차원

public class day1203 {
	public static void main(String[] args) {

		// 문제) 이름과 성적을 하나의 문자열로 연결
		// 정답) "김철수/87,이만수/42,이영희/95"
		
		String[] name = {"김철수", "이만수", "이영희"};
		int[] score = {87, 42, 95};
		
		String str = "";
		
		for(int i=0; i<name.length; i++) {
			str+=name[i]+"/"+score[i];
			if(i+1 != name.length) {
				str +=",";
			}		
		}
		System.out.println(str);
	}
}
