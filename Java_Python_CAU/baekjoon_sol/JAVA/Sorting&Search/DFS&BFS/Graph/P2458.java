package backjoon.dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class P2458 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int vNum = sc.nextInt();
        Graph bigGraph = new Graph(vNum);
        Graph smallGraph = new Graph(vNum);

        int count = sc.nextInt();

        // 단 방향
        for(int i=0; i<count; i++){
            int min = sc.nextInt();
            int max = sc.nextInt();
            bigGraph.createEdge(min,max);
            smallGraph.createEdge(max,min);
        }

        // bigGraph.print();
        // smallGraph.print();

        //자신의 위치 파악가능한 학생 저장용
        ArrayList<Integer> verify = new ArrayList<>();

        int check = 0;

        for(int i=1; i<=vNum; i++){
            check = 0;
            bigGraph.clearVisit();
            smallGraph.clearVisit();
            bigGraph.dfs(i);
            smallGraph.dfs(i);

            //1부터 vNum까지 두 그래프의 visit가 모두 false인 경우가 한번이라도 있으면 check=1
            //한번도 없으면 자신의 위치 파악가능한 학생이므로 check=0 그대로 되고 verify의 저장
            for(int j=1; j<=vNum; j++){
                if(bigGraph.visit[j] == false && smallGraph.visit[j] == false){
                    check = 1;
                }
            }

            if(check == 0 ){
                verify.add(i);
            }
        }

        //print
        System.out.println(verify.size());

    }
}

class Graph{
    private int vNum;
    private ArrayList<ArrayList<Integer>> graph;
    boolean[] visit;

    Graph(int vNum){
        this.vNum = vNum;
        this.visit = new boolean[vNum+1];

        graph = new ArrayList<ArrayList<Integer>>();

        for(int i=0; i<=vNum; i++){
            graph.add(new ArrayList<Integer>());
        }
    }

    // x->y
    public void createEdge(int x, int y){
        graph.get(x).add(y);
    }

    public void print(){
        for(int i=1; i<graph.size(); i++){
            System.out.print(i+" vertex : " );
            for(int j=0; j<graph.get(i).size(); j++){
                System.out.print("->"+graph.get(i).get(j));
            }
            System.out.println();
        }
    }

    public void clearVisit(){
        for(int i=1; i<visit.length; i++){
            this.visit[i] = false;
        }
    }

    public void dfs(int start){
        this.visit[start] = true;

        for(int v : graph.get(start)) {
            if (this.visit[v] == false) {
                dfs(v);
            }
        }
    }
}
