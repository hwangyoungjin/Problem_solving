package day01;

public class day0101 {
	public static void main(String[] args) {
		// 산술연산자 OpEx03_문제 &  변수 VarEx02_문제
		// 문제1
		int su = 100;
		float tax = 0.1f;
		int sum = su*12-(int)(su*12*(tax));
		System.out.println("월급 : " + sum);
		System.out.println();
		
		// 문제2
		int[] su1 = {30, 50, 4};
		int sum1 = 0;
		for(int i=0; i<su1.length; i++ ) {
			sum1 += su1[i];
		}
		float average = sum1/(float)su1.length; 
		System.out.println("평균 : " + average);
		System.out.println();
		
		// 문제3
		int x = 3; //가로
		int y = 6; //세로
		float area = (x*y)/2f; //넓이
		System.out.println("넓이 : " + area );
		System.out.println();
		
		// 문제4
		int su2 = 100;
		int minute = 0;
		int second = 0;
		minute = su/60;
		second = su%60;
		System.out.println("100초는  "+minute+"분, "+second+"초");
		System.out.println();
		
		// 문제5
		int money = 800;
		int oh = money/500;
		int beak = (money%500)/100;
		System.out.println(money+"는  500원 : "+oh+"개  , 100원 : "+beak+"개");
		System.out.println();
		
		// 문제 6
		
		
	}
}
