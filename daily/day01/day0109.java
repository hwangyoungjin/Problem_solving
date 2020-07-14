package day01;

import java.util.Scanner;

public class day0109 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("키를 입력하세요 : ");
		int height = scan.nextInt();
		if(height >= 120 ) {
			System.out.println("놀이기구 이용 가능!");
		}
		if(height < 120) {
			System.out.print("부모님과 함께 오셨나요?(yes:1, no:0) : ");
			int check = scan.nextInt();
			if(check == 1) {
				System.out.println("놀이기구 이용가능!");
			}
			else {
				System.out.println("놀이기구 이용 불가!");
			}
		}
	}
}
