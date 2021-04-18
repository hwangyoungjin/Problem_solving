package backjoon.dynamicprogramming;

import java.util.*;

public class P2294CoinChange {
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
        int checkNum = 0;
        int[] numCoin = new int[money+1];
        numCoin[0] = 0;
        for(int m=1; m<numCoin.length; m++){
            numCoin[m] = Integer.MAX_VALUE-1;
            for(int i=coin.length-1; i>=0; i--){
                if(m>=coin[i]){
                    checkNum = numCoin[m-coin[i]]+1;
                    if(checkNum<numCoin[m]){ //더 작은 동전인 경우 swap
                        numCoin[m] = checkNum;
                    }
                }
            }
        }
        //System.out.println(Arrays.toString(numCoin));
        if(numCoin[numCoin.length-1]==Integer.MAX_VALUE-1){
            return -1;
        }
        //System.out.println("numCoin["+ (numCoin.length-1) + "] = "+numCoin[numCoin.length-1]);
        return numCoin[numCoin.length-1];
    }
}
