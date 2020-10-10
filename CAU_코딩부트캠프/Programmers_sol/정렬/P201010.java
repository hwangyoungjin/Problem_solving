package daily;
/**
 * 문제 설명
배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.

예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
2에서 나온 배열의 3번째 숫자는 5입니다.
배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한사항
array의 길이는 1 이상 100 이하입니다.
array의 각 원소는 1 이상 100 이하입니다.
commands의 길이는 1 이상 50 이하입니다.
commands의 각 원소는 길이가 3입니다.
입출력 예
array					commands							return
[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
입출력 예 설명
[1, 5, 2, 6, 3, 7, 4]를 2번째부터 5번째까지 자른 후 정렬합니다. [2, 3, 5, 6]의 세 번째 숫자는 5입니다.
[1, 5, 2, 6, 3, 7, 4]를 4번째부터 4번째까지 자른 후 정렬합니다. [6]의 첫 번째 숫자는 6입니다.
[1, 5, 2, 6, 3, 7, 4]를 1번째부터 7번째까지 자릅니다. [1, 2, 3, 4, 5, 6, 7]의 세 번째 숫자는 3입니다.
 * @author USER
 *
 */

import java.util.*;

class Solution3 { //O(n^2)
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        //주어진 commands에 맞춰 2차원 가변배열의 '열' 새로 만들기
        int[][] newArr = new int[commands.length][];

        for(int i=0; i<commands.length; i++){
            //commands[i]의 들어있는 값의 대해 필요한 만큼 '행' 새로만들기
            int n = commands[i][1]-commands[i][0]+1; //필요한 길이
            newArr[i] = new int[n]; //필요한 길이만큼 메모리 할당

            int a = commands[i][0]-1; //시작 index
            int b = commands[i][1]-1; //종료 index
            int c = 0; //newArr에 순차적으로 들어갈 index
            for(int j=a; j<=b; j++){ //array 배열값 복사
                newArr[i][c++] = array[j];
            }
            //해당 배열 정렬
            Arrays.sort(newArr[i]);
            int k = commands[i][2]-1; // return할 위치 k 값
            answer[i] = newArr[i][k]; // 정렬된 배열에서 위치k값 넣기
        }
        return answer;
    }
}

//Arrays의 copyOfRange이용하기
class Solution4 { //O(n^2)
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            //index를 활용하여 필요한 부분 복사
        	int[] newArr = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]-1);
        	
            //해당 배열 정렬
            Arrays.sort(newArr);
            
            answer[i] = newArr[commands[i][2]-1]; // 정렬된 배열에서 위치k값 넣기
        }
        return answer;
    }
}

public class P201010 {
	public static void main(String[] args) {
		Solution4 sol = new Solution4();
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		System.out.println(Arrays.toString(sol.solution(array, commands)));
	}
}
