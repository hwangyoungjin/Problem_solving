package day07;

/*
 * # 중복숫자 금지[2단계]
 * 1. arr배열에 1~10 사이의 랜덤 숫자 5개를 저장한다.
 * 2. 단 중복되는 숫자가 없어야 한다.
 */

public class day0708 {
	public static void main(String[] args) {
		int[] arr = new int[5];
		int[] cnt = new int[10];//1~10사이 숫자 체크
		
		
		int index=0;
		while(index<5) {
			int ran = (int)(Math.random()*10);
			if(cnt[ran]==0) { //0이면 미사용 1이면 사용
				arr[index] = ran+1;
				index++;
				cnt[ran] = 1;
			}
		}
		System.out.println(java.util.Arrays.toString(arr));
	}
}
