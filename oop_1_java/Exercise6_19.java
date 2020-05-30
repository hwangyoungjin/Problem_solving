package java_jungsuk3_PracticeProblem;

public class Exercise6_19 {
	public static void change(String str123) {
		System.out.println(str123);
		str123+="456";
		System.out.println(str123);
	}
	
	public static void main(String[] args) {
		String str = "ABC123";
		System.out.println(str);
		change(str);
		//change에서 str123은 +연산 후 새로 문자열을 만들기 때문에 str은 바뀌지 않는다.
		System.out.println("After change : "+str);
	}
	
}
