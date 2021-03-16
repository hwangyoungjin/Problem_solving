import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String,Integer> hm = new HashMap<>();
        for(String player : participant){
            hm.put(player, hm.getOrDefault(player, 0)+1);
        }
        for(String player : completion){
            hm.put(player, hm.get(player)-1);
        }
        
        Iterator it = hm.entrySet().iterator();
        
        while(it.hasNext()){
            Map.Entry e = (Map.Entry)it.next();
            if((int)e.getValue() == 1){
                answer = (String)e.getKey();
                break;
            }
        }

        return answer;
    }
}