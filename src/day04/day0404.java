package day04;

public class day0404 { // 학생 성석관리 문제
	public static void main(String[] args) {
		int[] arr = new int[5];
		//문제1 arr배열에 1~100점 사이의 정수를 5개 저장
		for(int i=0; i<arr.length; i++) {
			arr[i]=(int)(Math.random()*100+1);
		}
		//문제2 전교생의 총점과 평균 출력
		int sum=0;
		int count =0;
		float average = 0f;
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
			if(arr[i]>=60) {count++;}
		}
		average = sum/(float)arr.length;
		System.out.println("총점 : "+ sum);
		System.out.printf("평균점수 : %.2f", average);
		System.out.println();
		
		//문제3 성적이 60점 이상이면 합격 , 합격생수 출력
		System.out.println("합격생 수 : "+count);
	}
}
