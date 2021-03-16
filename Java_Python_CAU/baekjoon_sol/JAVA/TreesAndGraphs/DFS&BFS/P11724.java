import java.util.*;

class Graph{
    private int vNumber;
    private ArrayList<ArrayList<Integer>> graph;
    private boolean[] visit;
    
    //getter
    boolean[] getVisit(){
        return this.visit;
    }
    
    //생성자
    Graph(int vNumber){
        this.vNumber = vNumber;
        graph = new ArrayList<ArrayList<Integer>>();
        visit = new boolean[vNumber+1];
        for(int i=0; i<vNumber+1; i++){
            graph.add(new ArrayList<Integer>());
        }
    }
    
    //edge연결
    public void createEdge(int x, int y){
        graph.get(x).add(y);
        graph.get(y).add(x);
    }
    
    //dfs
    public void dfs(int start){
        visit[start] = true;
        
        for(int vIdx : graph.get(start)){ //방문 안했으면 재귀
            if(visit[vIdx] == false){
                dfs(vIdx);
            }
        }
    } 
}

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        //vertex 와 edge 개수 받기
        int vNumber = scan.nextInt();
        int eNumber = scan.nextInt();
        
        Graph graph = new Graph(vNumber);
        
        //그래프 연결
        for(int i=0; i<eNumber; i++){
            int x= scan.nextInt();
            int y= scan.nextInt();
            graph.createEdge(x,y);
        }
        
        //연결된 그래프 체크하기
        int number = 0;
        boolean[] visit = graph.getVisit();
        for(int i=1; i<=vNumber; i++){
            if(visit[i] == false){ //방문 안했으면
                number++;
                graph.dfs(i);
            }
        }
        System.out.println(number);
    }
}