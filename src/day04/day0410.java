package day04;

public class day0410 {
	/*
	 * # 4의 배수만 저장
	 * - arr 배열에서 4의 배수만 골라 temp 배열에 저장
	 */
	public static void main(String[] args) {
		int[] arr = {44, 11, 29, 24, 76};
		int[] temp = null;
		int index = 0;
		for(int i=0; i<arr.length; i++) {
			if((arr[i]%4) ==0 ) {
				index++;
			}
		}
		temp = new int[index];
		int cnt = 0;
		for(int i=0; i<arr.length; i++) {
			if((arr[i]%4) ==0 ) {
				temp[cnt]=arr[i];
				cnt++;
			}
		}
		System.out.println(java.util.Arrays.toString(temp));
	}
}
