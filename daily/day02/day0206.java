package day02;

import java.util.Scanner;

public class day0206 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int com = (int)(Math.random()*3);
		System.out.print("가위(0), 바위(1), 보(2) 입력 : ");
		int me = scan.nextInt();
		if(me == com) {
			System.out.println("com : "+com+", me : "+me);
			System.out.println("비겼습니다.");
		}
		if((me == 0 && com==1) || (me == 1 && com ==2) || (me ==2 && com == 0)) {
			System.out.println("com : "+com+", me : "+me);
			System.out.println("졌습니다.");
		}
		if((me == 1 && com==0) || (me == 2 && com ==1) || (me ==0 && com == 2)) {
			System.out.println("com : "+com+", me : "+me);
			System.out.println("이겼습니다.");
		}
	}
}
