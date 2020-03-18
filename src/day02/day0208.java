package day02;

import java.util.Scanner;

public class day0208 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		do {
			int su = (int)(Math.random()*100+150);
			String to = Integer.toString(su);
			System.out.print("가운데 숫자 맞추기 (0~9 입력) : ");
			int select = scan.nextInt();
			for(int i=0; i<to.length(); i++) {
				System.out.print(to.charAt(i));
			}
			System.out.println();
			if(to.charAt(1)-'0' == select ) { // char 값 에서 '5'-'0' = 5 라는 숫자 값이 나온다
				System.out.println(su+" : "+select);
				System.out.println("정답!");
				break;
			}
			else {
				System.out.println(su+" : "+select);
				System.out.println("오답!");
			}
		}while(true);
		
	}
}
