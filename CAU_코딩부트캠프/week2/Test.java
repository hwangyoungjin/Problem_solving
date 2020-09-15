package week2;

public class Test {
   static boolean[][] arr=new boolean[4][5];
   static boolean[][] copy=new boolean[4][5];
  
   //가로 확인 , 세로 확인 , 복사하는 배열에 겹쳐있는지 확인 하는 매서드 
   static void rkfh(int i,int j) {
      if(j<4&&copy[i][j+1]!=true) {
      for(int k=j+1;k<5;k++) {
         if(arr[i][k]==true) {
            copys(i,k);
            tpfh(i, k);
         }
         else{
            break;
         }
      }
      }
      if(j>0&&copy[i][j-1]!=true) {
      for(int k=j-1;k>=0;k--)
         if(arr[i][k]==true) {
            copys(i,k);
            tpfh(i, k);
         }
         else{
            break;
         }
      }
   }
   static void tpfh(int i,int j) {

      for(int k=i; k<4; k++) {
         if(arr[k][j]==true) {
            copys(k, j);
            rkfh(k, j);
         }
         else {
            break;
         }
      }
   
   }

   static void copys(int i,int j) {
      copy[i][j]=true;
   }
//   배열 생성을 위한 랜덤값 반환 매서드 
   static boolean todtjd() {
      int a = (int)(Math.random()*2);
      if(a==1) {
         return true;
      }
      else {
         return false;
      }
   }
   public static void main(String[] args) {
      int c=0;
      int k;
      for(int i=0; i<4;i++) {
         for(int j=0; j<5;j++) {
            arr[i][j]=todtjd();
         }
      }
   
      for(int i=0;i<4;i++) {
         for(int j=0;j<5;j++) {
            if(arr[i][j]==true)
               k=1;
            else {
               k=0;
            }
            System.out.print(k+" ");
         }
         System.out.println();
      }
      
      for(int i=0;i<4;i++) {
         for(int j=0;j<5;j++) {
            if(arr[i][j]==true&&copy[i][j]!=true) {
                tpfh(i, j);
                c++;
            }
      
         }
      }      
   System.out.println();
      for(int i=0;i<4;i++) {
         for(int j=0;j<5;j++) {
            if(copy[i][j]==true)
               k=1;
            else {
               k=0;
            }
            System.out.print(k+" ");
         }
         System.out.println();
      }
      System.out.println(c);
   }// main end

}