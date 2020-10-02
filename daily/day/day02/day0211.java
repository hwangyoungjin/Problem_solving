package day02;

import java.util.Scanner;

public class day0211 {
	public static void main(String[] args) {
		//연산자 기호 맞추기 게임
		Scanner scan = new Scanner(System.in);
		int su1 , su2 ;
		su1 = (int)(Math.random()*10+1);
		su2 = (int)(Math.random()*10+1);
		int operator = (int)(Math.random()*4+1);
		int result=0;
		switch(operator) { 
		case 1 : // 1) +  ,  2) - , 3) * , 4) % 
			result = su1+su2;
			break;
		case 2 : 
			result = su1-su2;
			break;
		case 3 :
			result = su1*su2;
			break;
		case 4 : 
			result = su1%su2;
			break;
		}
		System.out.println(su1 + " ? " + su2 + " = " + result);
		System.out.print("정답은 ? ( 1.[+] 2.[-] 3.[*] 4.[%] ) :  ");
		int choice = scan.nextInt();
		if(operator == choice) {
			System.out.println("정답입니다.");
		}
		else {
			System.out.println("틀렸습니다. 정답은 : "+operator+"번 입니다.");
		}
	}
}
