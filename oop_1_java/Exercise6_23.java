package java_jungsuk3_PracticeProblem;

/*max값구하기 , 절대값 반환하기*/
public class Exercise6_23 {
	static int max(int[] arr) {
		int max =0;
		if(arr == null || arr.length == 0) {
			return -999999;
		}
		for(int i=0; i<arr.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		return max;
	}
	
	static int abs(int value) {
		if(value >= 0) {
			return value;
		}
		else {
			return -value;
		}
	}
	public static void main(String[] args) {
		int[] data = {3,2,9,4,7};
		System.out.println(java.util.Arrays.toString(data));
		System.out.println("최댓값 : "+max(data));
		System.out.println("최댓값 : "+max(null));
		System.out.println("최댓값 : "+max(new int[] {}));
		
		int value=5;
		System.out.println(value+"의 절대값 : "+abs(value));
		value = -10;
		System.out.println(value+"의 절대값 : "+abs(value));
	}
}
