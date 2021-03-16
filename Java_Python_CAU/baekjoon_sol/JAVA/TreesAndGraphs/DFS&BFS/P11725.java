import java.util.*;

//2번 vertex부터 3,4,5,6,```` 순서로 부모node를 출력하는 문제
class Graph{
    private int vNumber;
    private ArrayList<ArrayList<Integer>> graph;
    private boolean[] visit;
    private int[] parent;
    
    //parent 출력
    public void printParent(){
        for(int i=2; i<parent.length; i++){
            System.out.println(parent[i]);
        }
    }
    
    //생성자
    Graph(int vNumber){
        this.vNumber = vNumber;
        visit = new boolean[vNumber+1]; // false로 자동 초기화
        graph = new ArrayList<ArrayList<Integer>>();
        
        //index가 해당 노드번호, value가 부모 node번호 0으로 자동초기화
        parent = new int[vNumber+1];

        //0번은 사용x
        for(int i=0; i<vNumber+1; i++){
            graph.add(new ArrayList<Integer>());
        }
    }
    
    //양방향 연결
    public void createEdge(int x, int y){
        graph.get(x).add(y);
        graph.get(y).add(x);
    }
    
    //dfs
    public void dfs(int startIdx){
        visit[startIdx] = true;
        
        for(int vIdx : graph.get(startIdx)){
            if(visit[vIdx] == false){
                //방문안했으면 지금 노드(statIdx)가 부모노드!!
                //(부모 노드를 자식 노드보다 항상 먼저 방문하기 때문이다.)
                parent[vIdx] = startIdx;
                dfs(vIdx);
            }
        }
    }
    
    public void cleanVisit(){
        for(int i=0; i<visit.length; i++){
            visit[i] = false;
        }
    }
}

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int vNumber = scan.nextInt();
        Graph graph = new Graph(vNumber);
        
        //edge 연결
        for(int i=1; i<vNumber; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            graph.createEdge(x,y);
        }
        
        //1번 노드부터 DFS
        graph.dfs(1);
        
        //부모출력
        graph.printParent();
    }
}