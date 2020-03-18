package day01;

public class day0102 {
	public static void main(String[] args) {
		// 비교 연산자 OpEx06_문제
		// 문제 1
		int su = (int)(Math.random()*100+1);
		int su1=30;
		if(su%3==0) {
			System.out.println(su +" 는 3의 배수 true");
		}
		System.out.println();
		
		//문제2 
		if(su%2==0) {
			System.out.println("true");
		}
		System.out.println();
		
		//문제 3
		int money= 178600;
		if((money%5000)/1000>=3) {
			System.out.println("1000원 짜리 개수 = "+(money%5000)/1000 +"개이므로 : true");
		}
		System.out.println();
		
		
		
		
	}
}
