package java_jungsuk3_PracticeProblem;

/**
 * fullPath:c:\jdk1.8\work\PathSeparateTest.java
 * path:c:\jdk1.8\work
 * fileName:PathSeparateTest.java
 * 
 * 다음과 같은 실행결과가 나오도록 코드를 완성하시오
 * @author USER
 *
 */
public class Exercise9_3 {
	public static void main(String[] args) {
		String fullPath = "c:\\jdk1.8\\work\\PathSeparateTest.java";
		String path = "";
		String fileName = "";
		/*
		(1) 알맞은 코드를 넣어 완성하시오.
		*/
		int index = fullPath.lastIndexOf("\\"); // '\\'의 시작위치를 반환 
		if( index != -1) {
			path = fullPath.substring(0,index); // 시작위치는 포함x
			fileName = fullPath.substring(index+1); // 시작위치 이후 부터 마지막
		}
		
		
		System.out.println("fullPath:"+fullPath);
		System.out.println("path:"+path);
		System.out.println("fileName:"+fileName);
		
		
	}
}
