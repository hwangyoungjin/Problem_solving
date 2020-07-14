package day1201;

//# 문자열 2차원

public class day1202 {
	public static void main(String[] args) {

		// 문제) 이름은 name배열에 성적은 score배열에 각각 저장 및 출력

		String str = "김철수/87,이만수/42,이영희/95";

		String[] name = new String[3];
		int[] score = new int[3];

		String[] split1 = str.split(",");
		String[] split2 = null;
		
		for(int i=0; i<split1.length; i++) {
			split2 = split1[i].split("/");
			name[i] = split2[0];
			score[i] = Integer.parseInt(split2[1]);
		}
		
		for(int i=0; i<3; i++) {
			System.out.println(name[i]+"의  score : "+score[i]);
		}
	}
}