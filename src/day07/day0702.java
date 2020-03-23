package day07;


//# 삼각형 그리기
/*
 * 문제 3)
 * @##
 * @@#
 * @@@
 */
public class day0702 {
	public static void main(String[] args) {
		int line = 0;
		for(int i=1; i<=3; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("@");
			}
			for(int j=3; j>i; j--) {
				System.out.print("#");
			}
			System.out.println();
		}
	}
}
