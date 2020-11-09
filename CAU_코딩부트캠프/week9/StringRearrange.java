package week9;

import java.util.HashMap;
import java.util.Iterator;

public class StringRearrangeBangmin {

   public static void main(String[] args) {
      String str1="aaaaabbbbbcccc";
      StringBuffer nstr=new StringBuffer();
      StringBuffer block = new StringBuffer();
      //      String str1="aab";
      int c,q1=0;
      String k = null;
      HashMap<String,Integer> str =new HashMap<String,Integer>();


      for(int i=0;i<str1.length();i++) {
         c=0;
         Iterator<String> it= str.keySet().iterator();
         while(it.hasNext()){
            if(it.next().equals(str1.substring(i,i+1))){
               c++;
            }
         }
         if(c>0)
            str.put(str1.substring(i,i+1),str.get(str1.substring(i,i+1))+1);
         else
            str.put(str1.substring(i,i+1),1);
      }
      //여기까지 해쉬맵으로 문자열 값 옴김



      Iterator<String> it= str.keySet().iterator();
      while(it.hasNext()){      
         k=it.next();
         System.out.println("해쉬맵에 잘들어갓는지 확인    "+k+str.get(k));
      }
      //잘 저장됏는지 확인 



      it= str.keySet().iterator();
      while(it.hasNext()){
         String s=it.next();
         if(q1<str.get(s)){
            q1=str.get(s);
            k=s; //key == 최대개수의 key값
         }
      }
      //가장 많은 문자의 개수 뽑아 내고첫번쨰 키값 k에 저장
      System.out.println("가장 많은 개수 를 가지고있는 문자    "+k);
      
      c=1;
      while(true){
         if(c==0) {
            break;
         }
         c=0;
         it= str.keySet().iterator();
         while(it.hasNext()){
            String s=it.next();
            if(!(k.equals(s))&&str.get(s)>0){ //최대많은개수의 키값과 다르고, 개수가 1개 이상이면
               str.put(s,str.get(s)-1); // 개수를 하날 줄이고
               block.append(s); // 버퍼에 붙여준다. 개수가 가장 많은게 a이면 bcbc... 순열로 들어간다.
               c++; 
            }
         }
      }
      //k을 제외한 나머지를 스트링버퍼 배열에 저장 
      System.out.println("나머지 문자들이 스트링버퍼에 번갈아 잘들어갓는지 확인    "+ block);
      block.reverse(); 
      System.out.println("리버스 됐는지 확인    "+block);
      //꺼꾸로 넣어주면 중복되는거 상관없이 그냥 넣으면됨 
      if(block.length()>=q1-1) {
         //이게 최소한의 조건   ㅇ:가장많은개수를가지고있는 문자 ,ㅁ:그이외 문자들   라할때  
         //ㅇㅁㅇㅁㅇㅁㅇㅁㅇ .......ㅇ로 끝나면         "ㅁ의개수 = ㅇ의개수-1"    일때가 마지노선 이므로 최소한의 조건은 위조건을 만족해야함 
         

         while(true){
            if(str.get(k)==0) {
               break;
            }         
               str.put(k,str.get(k)-1);
               nstr.append(k);
               if(block.length()>0) {
                  nstr.append(block.substring(0,1));
                  block.delete(0,1);
               }
         }
         if(block.length()>0) {
            nstr.append(block);
         }
         System.out.println("결과    "+nstr);
      }
      else 
         System.out.println("\"\"");

   }
}
