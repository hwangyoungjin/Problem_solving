package week9;

import java.util.Arrays;

/**
 * [Level-1]
 * 2D 보드와 단어가 주어지면 보드 안에 단어가 순차적으로 접근할 수 있는지 탐색해보자.
 * Input : board = [["A", "B", "C", "E"], [ "S", "F", "C", "S"], 
 * 					[ "A", "D", "E", "E"]], 
 * 		   word = "ABCCED”
 * Ouput : true
 * 
 * 이동은 가로, 세로만 가능
 * @author USER
 *
 */

class Solution {
	
	boolean solution (String[][] board , String word) {
		
		//board 원소 하나하나에 대해 검사
		for(int y=0; y<board.length; y++) {
			for(int x=0; x<board[0].length; x++) {
				//검사할때마다 방문기록용 check 갱신
				boolean[][] check = {{false,false,false,false}
									,{false,false,false,false}
									,{false,false,false,false}};
				if(search(word,0,new StringBuffer(),check,board,x,y)) { 
					//찾을단어, 찾을단어의 시작위치, 찾은단어 저장할 buf, 방문기록용 check, 
					//board, 시작 좌표 (x,y)
					return true; //찾으면 true 반환
				}
			}
		}//board 원소하나하나에 대해 word를 찾지못한경우 false
		return false;
	}
	
	boolean search(String word, int idx, 
					StringBuffer buf, 
					boolean[][] check, 
					String[][] board, 
					int curX, int curY) {
		check[curY][curX] = true; //1. 방문했다고 체크
		
		//2. word의 해당 자리(idx)에 대해서
		String wordNum = word.substring(idx,idx+1);  
		//System.out.println("wordNum : "+wordNum);
		
		//3-1. Borad의 현재 위치의 값(curX,curY)과 같으면
		if(board[curY][curX].equals(wordNum)) { 
			idx++; //4. word의 위치 인덱스 ++
			buf.append(wordNum); //5. buf의 추가
			//System.out.println("buf : "+buf.toString());
			//System.out.println("word : "+word+", result : 
			//"+ buf.toString().equals(word));
			
			if(buf.toString().equals(word)) { //6-1. buf에 채운 단어가 word랑 같다면 true
				//System.out.println("true");
				return true;
			}
			else { //6-2. 다르다면 해당 위치에서 동남서북에 대해 검사
				int[][] dest = {{0,1},{1,0},{0,-1},{-1,0}}; //동남서북
				for(int j=0; j<4; j++) { //동남서북의 대해 검사 
					
					/*
					 * switch(j) { case 0: System.out.println("동"); 
					 * break; case 1:
					 * System.out.println("남"); break; 
					 * case 2: System.out.println("서"); break; case
					 * 3: System.out.println("북"); break; }
					 */
					
					//이동 할 동남서북의 위치 값
					int nextY = curY + dest[j][0];
					int nextX =  curX + dest[j][1];
					
					//7. board 검사할 인덱스 범위가 초과하지 않았고 해당 위치를 방문하지 않았으면
					if(nextY>=0 && nextY<3 && nextX>=0 && nextX<4 
							&& !check[nextY][nextX]) {
						if(search(word,idx,buf,check,board,nextX,nextY)) {
							//8. 해당 위치에서 이어서 다음 word 탐색
							//9. 탐색해서 찾았으면 true
							return true;
						}
					}
				}// 동남서북에서 못찾았으면 맨처음 시작한 board 위치에선 찾을 수 없는것
				return false;
			}
		}
		//3-2. Borad의 현재 위치의 값(curX,curY)과 다르면 탐색 시작도 안하고 바로 false 리턴
		return false;
	}
		
}
public class SearchWord {
	public static void main(String[] args) {
		Solution s = new Solution();
		String[][] board = {{"A", "B", "C", "E"}, 
							{"S", "F", "C", "S"}, 
							{"A", "D", "E", "E"}};
		String word = "ABCCED";
		System.out.println(s.solution(board, word));
	}
}
