package week2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 일정 간격 병합
 * 
 * ex.1
 * 입력 : [[1, 3], [2, 6], [8, 10], [15, 18]]
 * 출력 : [[1, 6], [8, 10], [15, 18]]
 * 
 * 위와 같이 아무 규칙도 없는 간격의 모음 들이 입력 되면 겹치는 간격을 병합합니다.
 * 
 * ex.2
 * 입력 : [[1, 4], [4, 5]]          
 * 출력 : [[1, 5]]
 * 
 * ex.3
 * 입력 : [[1, 9], [2, 6], [16,25]]    
 * 출력 : [[1, 9], [16, 26]]
 * 
 * @author USER
 *
 */
class Gap implements Comparable{
	private int start;
	private int end;
	
	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Gap) {
			Gap gap = (Gap)o;
			return this.start - gap.start;
		}
		return -1;
	}
	
	@Override
	public String toString() {
		return "["
				+ start
				+","
				+ end
				+"]";
	}
	
}
public class MergeGap {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		ArrayList<Gap> list = new ArrayList<Gap>();  
		ArrayList<Gap> newList = new ArrayList<Gap>();
		while(true) {
			Gap gap = new Gap();
			System.out.println("====간격을 입력하세요(종료: -1 입력)====");
			
			System.out.print("start : ");
			int start = scan.nextInt();
			if(start == -1) {
				break;
			}
			gap.setStart(start);
			System.out.print("end : ");
			int end = scan.nextInt();
			if(end == -1) {
				break;
			}
			gap.setEnd(end);
			list.add(gap);
		}// while end
		
		Collections.sort(list);
		
		//Merge
		int cnt=0; // 앞에서 순차적으로 선택할 index
		
		while(cnt+1 != list.size()) { //선택할 대상이 없으면 종료
			
			Gap gap1 = list.get(cnt); //기준
			
			for(int i=cnt+1; i<list.size(); i++) { // 선택대상과 뒤에있는 비교할 대상 순차적으로 선택 
				Gap tem = list.get(i); //gap1의 다음 객체를 받아와서
				
				if(gap1.getEnd() >= tem.getStart()) { // gap1의 end가 tem의 start보다 크거나 같으면
					if(gap1.getEnd() < tem.getEnd()) { //gap1의 end가 tem의 end보다 작다면 
						gap1.setEnd(tem.getEnd()); // gap1의 end를 tem의 end로 바꾸기 						
					}
					//gap1이  tem의 end보다 크다면 그대로(변경 x)
		
					//뒤에 더이상 비교할 대상이 없는경우 
					if(i+1==list.size()) { 
						cnt=i;
						newList.add(gap1);
					}
				}
				else{ // gap1의 end가 tem의 start보다 작다면
					cnt = i;
					newList.add(gap1); // gap1 새로운 list의 저장
					
					// 더이상 비교할 대상없으면 마지막 간격 저장
					if(cnt+1 == list.size()) { 
						newList.add(tem);
					}
					break;
				}			
			}// for end		
		}//while end
				
		//print
		for(Gap gap : newList) {
			System.out.println(gap);
		}
	}// main end
}
