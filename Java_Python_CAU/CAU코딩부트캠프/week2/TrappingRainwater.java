package week2;
/**
 * 고인 물의양 계산하기 ( leetcode 42 )
 * 
 * 예제)
 * 지형
 * [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
 * 
 * 담길 수 있는 물의 양 6
 * 
 * @author USER
 *
 */
public class TrappingRainwater {
	
	int height[]; // 지형높이
	int leftMax[]; // 왼쪽에서 오른쪽으로 이동하면서 높이 저장할 배열
	int rightMax[]; // 오른쪽에서 왼쪽으로 이동하면서 높이 저장할 배열
			
	public TrappingRainwater(int[] height) {
		this.height = height;
		this.leftMax = new int[height.length];
		this.rightMax = new int[height.length];
	}
	

	//물의양 구하기
	int rainWater(int[] height) {
		
		//왼쪽에서 오른쪽으로 물채우기
		for(int i=0; i<height.length; i++) {
			
			//init
			if(i==0) { 
				leftMax[i] = height[i];
			}	
			
			//현재 높이가 leftMax의 저장된  이전 높이보다 크다면 높이 값 갱싱
			else if(leftMax[i-1] < height[i]) { 
				leftMax[i] = height[i];
			}
			
			//현재 높이가 leftMax의 저장된 이전 높이보다 작다면 이전 높이 그대로 저장
			else { 
				leftMax[i] = leftMax[i-1];
			}
		}//for end
		
		
		//오른쪽에서 왼쪽으로 이동하면서 물 채우기
		for(int i=height.length-1; i>=0; i--) {
			
			//init
			if(i==height.length-1) { 
				rightMax[i] = height[i];
			}	
			
			// 현재 높이가 rightMax의 저장된 이전 높이보다 크다면 높이 값 갱싱
			else if(rightMax[i+1] < height[i]) { 
				rightMax[i] = height[i];
			}
			
			else { //현재 높이가 rightMax의 저장된 이전 높이보다 작다면 이전 높이 그대로 저장
				rightMax[i] = rightMax[i+1];
			}
		}//for end
		
		
		//최종 물의 양 구하기
		//Add min(leftMax[i],rightMax[i]) - height[i]
		int count = 0; //최종 물의양을 구할 변수 
		for(int i=0; i<height.length; i++) {
			count += Math.min(leftMax[i], rightMax[i]) - height[i];
		}//for end
		
		return count;
		
	}//rainWater end
	
	
	public static void main(String[] args) {
		//지형 배열
		int height[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}; 
		
		TrappingRainwater rain = new TrappingRainwater(height);
		
		System.out.println("물의양은 : "+ rain.rainWater(height));
	}
}
