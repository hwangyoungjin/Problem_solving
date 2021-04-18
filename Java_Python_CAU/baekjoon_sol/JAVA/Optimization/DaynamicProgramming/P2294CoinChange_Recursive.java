package backjoon.dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Recursive
 */
public class P2294CoinChangeRecursive {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        //동전 개수
        int su = sc.nextInt();
        int[] coin = new int[su];

        //money
        int money = sc.nextInt();

        //동전 적은 금액부터 입력 들어오므로 내림차순 정렬하기위해
        //뒤부터 저장
        for(int i=su-1; i>=0; i--){
            coin[i] = sc.nextInt();
        }
        System.out.println(count(money,coin));
    }

    static int count(int money, int[] coin){

        /** 0인경우 바로 return,**/
        if(money == 0){
            return 0;
        }

        /**1인경우 바로 return,**/
        if(money == 1){
            return 1;
        }

        /**Coin 개수만큼 count값 넣어서 최솟값 찾기**/
        int[] num = new int[coin.length];
        for(int i=coin.length-1; i>=0; i--){
            if(money >= coin[i]) // coin i
            num[i] = count(money-coin[i],coin)+1;
            else{ // 동전으로 바꿀 수 없으면 MAX_VALUE
                num[i] = Integer.MAX_VALUE-1;
            }
        }

        Arrays.sort(num);
        //min Value
        System.out.println(money + "의 필요한 동전 = "+ num[0]);
        return num[0];
    }
}
