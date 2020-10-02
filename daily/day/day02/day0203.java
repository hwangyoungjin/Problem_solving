package day02;

import java.util.Random;

public class day0203 {
	public static void main(String[] args) {
		Random ran = new Random();
		
		int rNum = ran.nextInt(2); // 0~1사이 랜덤 숫자
		if(rNum ==1 ) {
			System.out.println("동전은 앞면입니다.");
		}
		else
			System.out.println("동전은 뒷면");	
	}
}
