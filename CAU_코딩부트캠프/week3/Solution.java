package test;

import java.util.*;

/**
 * 문제 설명
 * 직사각형을 만드는 데 필요한 4개의 점 중 3개의 좌표가 주어질 때, 나머지 한 점의 좌표를 구하려고 합니다. 
 * 점 3개의 좌표가 들어있는 배열 v가 매개변수로 주어질 때, 직사각형을 만드는 데 필요한 나머지 한 점의 좌표를 return 하도록 solution 함수를 완성해주세요. 
 * 단, 직사각형의 각 변은 x축, y축에 평행하며, 반드시 직사각형을 만들 수 있는 경우만 입력으로 주어집니다.
 * 
 * 제한사항
 * v는 세 점의 좌표가 들어있는 2차원 배열입니다.
 * v의 각 원소는 점의 좌표를 나타내며, 좌표는 [x축 좌표, y축 좌표] 순으로 주어집니다.
 * 좌표값은 1 이상 10억 이하의 자연수입니다.
 * 직사각형을 만드는 데 필요한 나머지 한 점의 좌표를 [x축 좌표, y축 좌표] 순으로 담아 return 해주세요.
 * 입출력 예
 * v	result
 * [[1, 4], [3, 4], [3, 10]]	[1, 10]
 * [[1, 1], [2, 2], [1, 2]]	[2, 1]
 * 입출력 예 설명
 * 입출력 예 #1
 * 세 점이 [1, 4], [3, 4], [3, 10] 위치에 있을 때, [1, 10]에 점이 위치하면 직사각형이 됩니다.
 * 
 * 입출력 예 #2
 * 세 점이 [1, 1], [2, 2], [1, 2] 위치에 있을 때, [2, 1]에 점이 위치하면 직사각형이 됩니다.
 * @author USER
 *
 */


public class Solution {
    public static  int[] solution(int[][] v) {
        int[] answer = new int[2];
        int x = 0;
        int y = 0;
        
        //x좌표 비교
        if(v[0][0]==v[1][0]){
            x = v[2][0];
        }
        else if(v[0][0]==v[2][0]){
            x = v[1][0];                
        }
        else{
            x = v[0][0];
        }

        //y좌표
        if(v[0][1]==v[1][1]){
            y = v[2][1];
        }
        else if(v[0][1]==v[2][1]){
            y = v[1][1];                
        }
        else{
            y = v[0][1];
        }
        answer[0] = x;
        answer[1] = y;
        return answer;
    }
    
    public static void main(String[] arg){
        Scanner scan = new Scanner(System.in);
        int[][] van = new int[3][2];
        for(int i=0; i<3; i++){
            System.out.print("x 좌표 입력 : ");
            int x = scan.nextInt();
            System.out.print("y 좌표 입력 : ");
            int y = scan.nextInt();
            van[i][0] = x;
            van[i][1] = y;
        }
        
        int[] answer = solution(van);
        System.out.print("["+answer[0]+","+answer[1]+"]");
        
    }
}