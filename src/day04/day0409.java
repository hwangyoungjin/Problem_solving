package day04;

import java.util.Random;

public class day0409 {
	public static void main(String[] args) {
Random ran = new Random();
		
		int[] check = new int[5];
		int[] arr = new int[5];
		
		for(int i=0; i<5; i++) {
			int r = ran.nextInt(5);
			arr[i] = r; // 
			if(check[r] == 0) {
				check[r] = 1;
			}else {
				i -= 1;
			}
		}
		
		for(int i=0; i<5; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		for(int i=0; i<5; i++) {
			System.out.print(check[i] + " ");
		}
		System.out.println();
	}
}
