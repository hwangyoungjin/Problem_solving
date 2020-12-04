package beakjoon;

import java.util.Arrays;
import java.util.Scanner;

public class P2805 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		
		int treeArr[] = new int[n];
		//나무의 수 받기
		for(int i=0; i<n; i++) {
			treeArr[i] = scan.nextInt();
		}
		
		Arrays.sort(treeArr); //오름차순 정렬
		
		//binarySearch를 통해 짜르는 범위를 좁혀간다.
		int middleHeight = 0; //mid값이 높이역할
		int minHeight = 0; //최솟값
		int maxHeight = treeArr[n-1];//최댓값
		long sum = 0;
		
		while(minHeight <= maxHeight) {
			middleHeight = (minHeight+maxHeight)/2; 
			sum = 0;
			
			// 길이 계산
			for(int i=0; i<treeArr.length; i++) {
				if(treeArr[i] > middleHeight) {
					sum +=  treeArr[i] - middleHeight;
				}	
			}
			
			if(sum >= m) { //합이 주어진 조건m 보다 크거나 같다면
				minHeight = middleHeight+1;
			}
			else { //아리면 m보다 작은것이므로 왼쪽으로 향해야 한다.
				maxHeight = middleHeight-1;
			}
		}
		System.out.println(maxHeight);
	}
}
