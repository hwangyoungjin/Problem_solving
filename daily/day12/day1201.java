package day1201;


//# 문자열 1차원

public class day1201 {
	public static void main(String[] args) {

		String str = "11/100/89";
		// 문제 1) arr 배열에 각 점수를 저장하고, 총점 출력
		// 정답 1) 200
		int[] arr = new int[3];
		
		String arrStr[] = str.split("/"); 
		
		int sum=0;
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(arrStr[i]);
			sum+=arr[i];
			System.out.println("arr["+i+"] : " + arr[i]);
		}
		System.out.println("총점 : "+ sum);
		
		
		// 문제 2) scores 배열의 각 점수를 슬러시를 구분자로 하나의 문자열로 연결
		// 정답 2) 11/100/89
		int[] scores = {11, 100, 89};
		String text = "";
		for(int i=0; i<scores.length; i++) {
			text += String.valueOf(scores[i]);
			if(i+1 != scores.length) {
				text += "/";
			}
		}
		System.out.println("Text : "+ text);
	}
}