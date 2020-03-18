package day03;

public class day0306 { //369 게임 2단계
	public static void main(String[] args) {
		/*
		 * # 369게임[2단계]
		 * 1. 1~50까지 반복을 한다.
		 * 2. 그 안에서 해당 숫자의 369게임의 결과를 출력한다.
		 * 예) 1 2 짝 4 5 짝 7 8 짝 10 11 12 짝 ...
		 */
		int x=0; // 1 의자리
		int y=0; // 10의자리
		for(int i = 1; i<=50; i++) { // su[50]개 배열의 1부터 50까지 넣기
			int count =0; // 짝짝 출력할 개수
			x = i%10;
			y = i/10;
			if (x !=0 && x%3 == 0 ) { // 일의자리 수에 3,6,9 있으면 짝 +1
				count ++;
			}
			if (y !=0 && y%3 == 0) { // 일의자리 수에 3,6,9 있으면 짝 +1
				count ++;
			}
			if(count == 0) {
				System.out.print(i+" ");
			}
			else if(count == 1) {
				System.out.print("짝 ");
			}
			else if(count == 2) {
				System.out.print("짝짝 ");
			}
			
			switch (i) {
			case 10:
				System.out.println();
				break;
			case 20:
				System.out.println();
				break;
			case 30:
				System.out.println();
				break;
			case 40:
				System.out.println();
				break;
			case 50:
				System.out.println();
				break;
			}
		}
		
		
	}
}
