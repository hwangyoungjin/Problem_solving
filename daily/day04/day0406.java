package day04;

public class day0406 {
	public static void main(String[] args) {
		int[] hakbuns = {1001, 1002, 1003, 1004, 1005};
		int[] scores  = {  87,   11,   45,   98,   23};
		int max=0;
		int num=0;
		for(int i=0; i<scores.length; i++) {
			if(max < scores[i]) {
				max = scores[i];
				num = hakbuns[i];
			}
		}
		System.out.println(num+"번("+max+"점)");
	}
}
