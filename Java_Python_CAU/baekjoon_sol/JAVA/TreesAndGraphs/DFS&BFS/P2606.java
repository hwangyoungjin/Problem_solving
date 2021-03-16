package beakjoon;
import java.util.*;

class Graph{
    private int VNumber; 
    private ArrayList<ArrayList<Integer>> graph;
    private boolean[] visitArr;
    
    public Graph(int VNumber){ //생성자
        this.VNumber = VNumber;
        graph = new ArrayList<ArrayList<Integer>>();
        
        //0번 인덱스는 사용 x 이므로 +1해서 List 만들기
        for(int i=0; i<VNumber+1; i++){
            graph.add(new ArrayList<Integer>());
        }
        
        this.visitArr = new boolean[VNumber+1]; //기본값 false
    }
    

	//edge 추가 - 양방향
    public void createEdge(int x, int y){
        graph.get(x).add(y);
        graph.get(y).add(x);
    }
    
    public void dfs(int startVertex){
        //방문했으니 방문체크
        this.visitArr[startVertex] = true;
        
        //해당 vertex에 안에들어있는 vIdx의 대해
        for(int vIdx : graph.get(startVertex)){
            if(visitArr[vIdx] == false){//연결된 vertex를 방문 안했으면
               dfs(vIdx); //재귀
            }               
        }
    }
    
    public void clear(){
        for(int i=1; i<visitArr.length; i++){
            visitArr[i] = false;
        }
    }
    
    //방문 개수 return
    public int count(){
        int count = 0;
        //1번 컴퓨터는 포함하면 안되므로 2번 vertex부터
        for(int i=2; i<visitArr.length; i++){
            if(visitArr[i] == true){
                count++;
            }
        }

        return count;
    }
    
    //현재 그래프 출력
    public void print(){
        for(int i=1; i<graph.size(); i++){
            System.out.print("vertex "+ i +" : " );
            for(int j=0; j<graph.get(i).size(); j++){
                System.out.print("--> " + graph.get(i).get(j));
            }
            System.out.println();
        }
    }
}

public class Main{
    public static void main(String[] arg){
        Scanner scan = new Scanner(System.in);
        
        int VNumber = scan.nextInt();
        int ENumber = scan.nextInt();
        //System.out.println("VNumver :" + VNumber +", ENumber : "+ ENumber);
        Graph graph = new Graph(VNumber);
        int x = 0;
        int y = 0;
        for(int i=0; i<ENumber; i++){
            x = scan.nextInt();
            y = scan.nextInt();
            //System.out.println("x :" + x +", y : "+ y);
            graph.createEdge(x,y);
        }
        //연결정보
        //graph.print();
        
        //1번 탐색
        graph.dfs(1);
        
        //방문한 vertex 개수 출력
        System.out.println(graph.count());
    }
}